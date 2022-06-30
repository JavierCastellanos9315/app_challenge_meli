package com.example.app_challenge_meli.repositories

import android.util.Log
import com.example.app_challenge_meli.apis.RetrofitHelper
import com.example.app_challenge_meli.model.search.Search

class ProductsRemoteData {

    suspend fun getAllProducts(query : String?): Search {
        try {
            val response = RetrofitHelper.service.getProductsByQuery(query)
            val search = response.body() ?: Search()
            return search
        }
        catch (e: Exception){
            Log.e("Error", "getAllProducts($query) ")
        }
        return  Search()
    }
}