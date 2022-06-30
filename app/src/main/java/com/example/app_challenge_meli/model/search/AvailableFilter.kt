package com.example.app_challenge_meli.model.search

data class AvailableFilter(
    var id: String? = "",
    var name: String? = "",
    var type: String? = "",
    var values: List<Value?>? = listOf()
)