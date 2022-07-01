package com.example.app_challenge_meli.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_challenge_meli.model.description.Description
import com.example.app_challenge_meli.model.item.Item
import com.example.app_challenge_meli.repositories.ProductsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val _state = MediatorLiveData<UIState>()
    var productsRepository: ProductsRepository = ProductsRepository()
    val state: LiveData<UIState> get() = _state
    private val _localState = MutableLiveData(UIState())

    init {
        _state.addSource(_localState) { _state.value = it }
    }

    /**
     * Obtiene informacion del producto y los guarda en state
     * @param item_id
     **/
    private suspend fun getProductInfo(itemId: String?) {
        itemId?.let {
            productsRepository.getItemByProductId(it)
        }
    }

    /**
     * Obtiene descripción del producto y los guarda en state
     * @param item_id
     **/
    private suspend fun getDescription(itemId: String?) {
        itemId?.let {
            productsRepository.getProductDescriptionById(it)
        }
    }

    fun getData(itemId: String?) {
        uiScope.launch {
            _localState.value = _localState.value?.copy(loading = true)
            getDescription(itemId)
            getProductInfo(itemId)
            _state.value = state.value?.copy(
                item = productsRepository.item.value,
                description = productsRepository.descriptionById.value,
                isSuccess = (productsRepository.isSucces.value != null && productsRepository.isSucces.value == true)
            )
            _localState.value = _localState.value?.copy(loading = false)
        }


    }

    data class UIState(
        val loading: Boolean = false,
        val item: Item? = null,
        val description: Description? = null,
        val isSuccess : Boolean = true
    )
}
