package com.example.app_challenge_meli.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.app_challenge_meli.model.description.Description
import com.example.app_challenge_meli.model.item.Item
import com.example.app_challenge_meli.model.search.Search
import com.google.firebase.crashlytics.FirebaseCrashlytics

class ProductsRepository {
    var repository = ProductsRemoteData()
    private var _searchByQuery  = MediatorLiveData<Search>()
    val searchByQuery: LiveData<Search> get() = _searchByQuery

    private var _description  = MediatorLiveData<Description>()
    val descriptionById: LiveData<Description> get() = _description

    private var _item  = MediatorLiveData<Item>()
    val item: LiveData<Item> get() = _item

    /**
     * Obtiene productos del servicio por medio de una query
     * @param query
     **/
    suspend fun getProductsByQuery(query : String?) {
        try {
            repository.getAllProducts(query).also { _searchByQuery.value = it }
        }
        catch (e: Exception){
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log(e.message.toString())
            Log.e("Error", "getProductsByQuery($query) ")
        }
    }

    suspend fun getProductDescriptionById(item_id : String?){
        try {
            repository.getDescriptionByProductId(item_id).also {
                _description.value = it }
        }
        catch (e: Exception){
        }
    }

    suspend fun getItemByProductId(item_id : String?){
        try {
            repository.getItemByProductId(item_id).also {
                _item.value = it
            }
        }
        catch (e: Exception){
        }

    }

}