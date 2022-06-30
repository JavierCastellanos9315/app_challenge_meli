package com.example.app_challenge_meli.model.search

data class Paging(
    var limit: Int? = 0,
    var offset: Int? = 0,
    var primary_results: Int? = 0,
    var total: Int? = 0
)