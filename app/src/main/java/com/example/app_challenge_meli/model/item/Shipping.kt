package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class Shipping(
    @SerializedName("dimensions")
    var dimensions: Any? = Any(),
    @SerializedName("free_shipping")
    var freeShipping: Boolean? = false,
    @SerializedName("local_pick_up")
    var localPickUp: Boolean? = false,
    @SerializedName("logistic_type")
    var logisticType: String? = "",
    @SerializedName("methods")
    var methods: List<Any?>? = listOf(),
    @SerializedName("mode")
    var mode: String? = "",
    @SerializedName("store_pick_up")
    var storePickUp: Boolean? = false,
    @SerializedName("tags")
    var tags: List<String?>? = listOf()
)