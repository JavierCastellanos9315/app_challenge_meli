package com.example.app_challenge_meli.model.search

data class Attribute(
    var attribute_group_id: String? = "",
    var attribute_group_name: String? = "",
    var id: String? = "",
    var name: String? = "",
    var source: Long? = 0,
    var value_id: String? = "",
    var value_name: String? = "",
    var value_struct: ValueStruct? = ValueStruct(),
    var values: List<ValueXX>? = listOf()
)