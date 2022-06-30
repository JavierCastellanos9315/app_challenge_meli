package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class SaleTerm(
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("value_id")
    var valueId: String? = "",
    @SerializedName("value_name")
    var valueName: String? = "",
    @SerializedName("value_struct")
    var valueStruct: ValueStruct? = ValueStruct(),
    @SerializedName("values")
    var values: List<ValueX>? = listOf()
)