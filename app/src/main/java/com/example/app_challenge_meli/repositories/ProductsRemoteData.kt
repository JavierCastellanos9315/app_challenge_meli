package com.example.app_challenge_meli.repositories

import android.util.Log
import com.example.app_challenge_meli.apis.RetrofitHelper
import com.example.app_challenge_meli.model.description.Description
import com.example.app_challenge_meli.model.item.Item
import com.example.app_challenge_meli.model.search.Search
import com.google.firebase.crashlytics.FirebaseCrashlytics
import retrofit2.Response

class ProductsRemoteData {

    /**
     * Obtiene productos del servicio por medio de una query
     * @param query
     **/
    suspend fun getAllProducts(query : String?): Response<Search> {
            return RetrofitHelper.service.getProductsByQuery(query)
    }

    /**
     * Obtiene descripción del producto
     * @param item_id
     **/
    suspend fun getDescriptionByProductId(item_id : String?) : Description {
        try {
            val response = item_id?.let { RetrofitHelper.service.getDescriptionByProductId(it) }
            val descriptionItem = response?.body() ?: Description()
            return descriptionItem
        }
        catch (e: Exception){
        }
        return Description()
    }

    /**
     * Obtiene informacion del producto
     * @param item_id
     **/
    suspend fun getItemByProductId(item_id : String?) : Item {
        try {
            val response = item_id?.let { RetrofitHelper.service.getItemByProductId(it) }
            return response?.body() ?: Item()
        }
        catch (e: Exception){
        }
        return Item()
    }
}