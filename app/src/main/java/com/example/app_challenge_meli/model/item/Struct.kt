package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class Struct(
    @SerializedName("number")
    var number: Int? = 0,
    @SerializedName("unit")
    var unit: String? = ""
)