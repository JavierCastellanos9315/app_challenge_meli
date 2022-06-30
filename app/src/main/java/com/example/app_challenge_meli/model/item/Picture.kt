package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("max_size")
    var maxSize: String? = "",
    @SerializedName("quality")
    var quality: String? = "",
    @SerializedName("secure_url")
    var secureUrl: String? = "",
    @SerializedName("size")
    var size: String? = "",
    @SerializedName("url")
    var url: String? = ""
)