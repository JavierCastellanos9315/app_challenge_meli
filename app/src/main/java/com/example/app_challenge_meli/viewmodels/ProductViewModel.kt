package com.example.app_challenge_meli.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.app_challenge_meli.model.search.Producto
import com.example.app_challenge_meli.repositories.ProductsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel(){
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val _state = MediatorLiveData<UIState>()
    val state: LiveData<UIState> get() = _state
    private var productsRepository : ProductsRepository = ProductsRepository()
    private val _localState = MutableLiveData(UIState())

    init {
        _state.addSource(_localState) { _state.value = it }

        viewModelScope.launch {
            _localState.value = _localState.value?.copy(loading = true)
            _state.value = state.value?.copy(products = productsRepository.searchByQuery.value?.results)
            _localState.value = _localState.value?.copy(loading = false)
        }
    }

    fun onProductClicked(product: Producto) {
        _state.value = _state.value?.copy(navigateTo = product)
    }


    fun onCreate() {
    }

    fun getProducts(query : String) {
        uiScope.launch {
            _localState.value = _localState.value?.copy(loading = true)
            try {
                productsRepository.getProductsByQuery(query)
            }
            catch (e: Exception){
                Log.e("Error", "getProduct($query) ")
            }
            _state.value = state.value?.copy(products = productsRepository.searchByQuery.value?.results)
            _localState.value = _localState.value?.copy(loading = false)
        }
    }

    fun setNavigateTo() {
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UIState(
        val loading: Boolean = false,
        val products: ArrayList<Producto>? = null,
        val navigateTo: Producto? = null,
    )
}