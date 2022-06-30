package com.example.app_challenge_meli.model.search

data class ReferencePrice(
    var amount: Int? = 0,
    var conditions: ConditionsX? = ConditionsX(),
    var currency_id: String? = "",
    var exchange_rate_context: String? = "",
    var id: String? = "",
    var last_updated: String? = "",
    var tags: List<Any>? = listOf(),
    var type: String? = ""
)