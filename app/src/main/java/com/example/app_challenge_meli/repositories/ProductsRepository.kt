package com.example.app_challenge_meli.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.app_challenge_meli.model.search.Search

class ProductsRepository {
    var repository = ProductsRemoteData()
    private var _searchByQuery  = MediatorLiveData<Search>()
    val searchByQuery: LiveData<Search> get() = _searchByQuery

    /**
     * Obtiene productos del servicio por medio de una query
     * @param query
     **/
    suspend fun getProductsByQuery(query : String?) {
        try {
            repository.getAllProducts(query).also { _searchByQuery.value = it }
        }
        catch (e: Exception){
            Log.e("Error", "getProductsByQuery($query) ")
        }
    }

}