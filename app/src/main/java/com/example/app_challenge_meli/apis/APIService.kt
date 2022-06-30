package com.example.app_challenge_meli.apis

import com.example.app_challenge_meli.model.description.Description
import com.example.app_challenge_meli.model.item.Item
import com.example.app_challenge_meli.model.search.Search
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    /**
     * Obtiene productos del servicio por medio de una query
     * @param query
     **/
    @GET("/sites/MCO/search")
    suspend fun getProductsByQuery(
        @Query("q") q: String?
    ): Response<Search>

    /**
     * Obtiene descripción del producto
     * @param item_id
     **/
    @GET("/items/{ITEM_ID}/description")
    suspend fun getDescriptionByProductId(
        @Path("ITEM_ID") item_id: String?
    ): Response<Description>

    /**
     * Obtiene informacion del producto
     * @param item_id
     **/
    @GET("/items/{ITEM_ID}")
    suspend fun getItemByProductId(
        @Path("ITEM_ID") item_id: String?
    ): Response<Item>
}