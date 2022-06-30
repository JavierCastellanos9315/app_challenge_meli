package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class ValueX(
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("struct")
    var struct: Struct? = Struct()
)