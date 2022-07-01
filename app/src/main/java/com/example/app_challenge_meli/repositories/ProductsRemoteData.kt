package com.example.app_challenge_meli.repositories

import com.example.app_challenge_meli.apis.RetrofitHelper
import com.example.app_challenge_meli.model.description.Description
import com.example.app_challenge_meli.model.item.Item
import com.example.app_challenge_meli.model.search.Search
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
    suspend fun getDescriptionByProductId(item_id : String?) : Response<Description> {
            return RetrofitHelper.service.getDescriptionByProductId(item_id)

    }

    /**
     * Obtiene informacion del producto
     * @param item_id
     **/
    suspend fun getItemByProductId(item_id : String?) : Response<Item> {

            return RetrofitHelper.service.getItemByProductId(item_id)
    }
}