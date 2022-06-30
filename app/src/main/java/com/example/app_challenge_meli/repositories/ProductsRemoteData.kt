package com.example.app_challenge_meli.repositories

import android.util.Log
import com.example.app_challenge_meli.apis.RetrofitHelper
import com.example.app_challenge_meli.model.description.Description
import com.example.app_challenge_meli.model.item.Item
import com.example.app_challenge_meli.model.search.Search
import com.google.firebase.crashlytics.FirebaseCrashlytics

class ProductsRemoteData {

    /**
     * Obtiene productos del servicio por medio de una query
     * @param query
     **/
    suspend fun getAllProducts(query : String?): Search {
        try {
            val response = RetrofitHelper.service.getProductsByQuery(query)
            val search = response.body() ?: Search()
            return search
        }
        catch (e: Exception){
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log(e.message.toString())
            Log.e("Error", "getAllProducts($query) ")
        }
        return  Search()
    }

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