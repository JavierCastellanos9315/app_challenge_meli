package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class Neighborhood(
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("name")
    var name: String? = ""
)