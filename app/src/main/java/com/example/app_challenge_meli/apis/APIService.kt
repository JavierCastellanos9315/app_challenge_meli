package com.example.app_challenge_meli.apis

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

}