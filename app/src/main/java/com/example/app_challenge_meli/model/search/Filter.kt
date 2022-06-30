package com.example.app_challenge_meli.model.search

data class Filter(
    var id: String? = "",
    var name: String? = "",
    var type: String? = "",
    var values: List<ValueX>? = listOf()
)