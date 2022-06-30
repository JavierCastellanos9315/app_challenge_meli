package com.example.app_challenge_meli.model.item


import com.example.app_challenge_meli.model.search.State
import com.google.gson.annotations.SerializedName

data class SearchLocation(
    @SerializedName("city")
    var city: City? = City(),
    @SerializedName("neighborhood")
    var neighborhood: Neighborhood? = Neighborhood(),
    @SerializedName("state")
    var state: State? = State()
)