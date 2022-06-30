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
    var productsRepository : ProductsRepository = ProductsRepository()
    val state: LiveData<UIState> get() = _state
    private val _localState = MutableLiveData(UIState())

    init {
        _state.addSource(_localState) { _state.value = it }
    }
    fun onCreate(itemId: String?){
        uiScope.launch {
            _localState.value = _localState.value?.copy(loading = true)
            itemId?.let {
                productsRepository.getItemByProductId(it)
            }
            _state.value = state.value?.copy(item = productsRepository.item.value)
            _localState.value = _localState.value?.copy(loading = false)
        }
    }

    fun getDescription(itemId : String?){
        uiScope.launch {
            _localState.value = _localState.value?.copy(loading = true)
            itemId?.let {
                productsRepository.getProductDescriptionById(it)
            }
            _state.value = state.value?.copy(description = productsRepository.descriptionById.value)
            _localState.value = _localState.value?.copy(loading = false)
        }
    }

    data class UIState(
        val loading: Boolean = false,
        val item: Item? = null,
        val description: Description? = null
    )
}
