package com.example.app_challenge_meli.model.search

data class Shipping(
    var free_shipping: Boolean? = false,
    var logistic_type: String? = "",
    var mode: String? = "",
    var store_pick_up: Boolean? = false,
    var tags: List<String?>? = listOf()
)