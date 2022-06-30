package com.example.app_challenge_meli.model.search

data class Installments(
    var amount: Double? = 0.0,
    var currency_id: String? = "",
    var quantity: Int? = 0,
    var rate: Int? = 0
)