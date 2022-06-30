package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class SellerAddress(
    @SerializedName("city")
    var city: City? = City(),
    @SerializedName("country")
    var country: Country? = Country(),
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("search_location")
    var searchLocation: SearchLocation? = SearchLocation(),
    @SerializedName("state")
    var state: StateX? = StateX()
)