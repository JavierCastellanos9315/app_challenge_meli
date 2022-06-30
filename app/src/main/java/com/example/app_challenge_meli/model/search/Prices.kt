package com.example.app_challenge_meli.model.search

data class Prices(
    var id: String? = "",
    var payment_method_prices: List<Any>? = listOf(),
    var presentation: Presentation? = Presentation(),
    var prices: List<Price>? = listOf(),
    var purchase_discounts: List<Any>? = listOf(),
    var reference_prices: List<ReferencePrice>? = listOf()
)