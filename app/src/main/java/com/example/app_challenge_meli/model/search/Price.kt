package com.example.app_challenge_meli.model.search

data class Price(
    var amount: Int? = 0,
    var conditions: Conditions? = Conditions(),
    var currency_id: String? = "",
    var exchange_rate_context: String? = "",
    var id: String? = "",
    var last_updated: String? = "",
    var metadata: Metadata? = Metadata(),
    var regular_amount: Int? = 0,
    var type: String? = ""
)