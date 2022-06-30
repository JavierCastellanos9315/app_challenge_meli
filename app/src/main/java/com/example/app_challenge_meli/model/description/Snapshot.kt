package com.example.app_challenge_meli.model.description


import com.google.gson.annotations.SerializedName

data class Snapshot(
    @SerializedName("height")
    var height: Int? = 0,
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("url")
    var url: String? = "",
    @SerializedName("width")
    var width: Int? = 0
)