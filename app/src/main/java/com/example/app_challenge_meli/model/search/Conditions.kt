package com.example.app_challenge_meli.model.search

data class Conditions(
    var context_restrictions: List<String?>? = listOf(),
    var eligible: Boolean? = false,
    var end_time: String? = "",
    var start_time: String? = ""
)