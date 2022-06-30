package com.example.app_challenge_meli.repositories

import android.util.Log
import com.example.app_challenge_meli.apis.RetrofitHelper
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
}