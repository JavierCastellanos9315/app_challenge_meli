package com.example.app_challenge_meli.model.search

data class ConditionsX(
    var context_restrictions: List<String?>? = listOf(),
    var eligible: Boolean? = false,
    var end_time: Any? = Any(),
    var start_time: Any? = Any()
)