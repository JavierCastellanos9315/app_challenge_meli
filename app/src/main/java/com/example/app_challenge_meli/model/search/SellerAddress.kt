package com.example.app_challenge_meli.model.search

data class SellerAddress(
    var address_line: String? = "",
    var city: City? = City(),
    var comment: String? = "",
    var country: Country? = Country(),
    var id: String? = "",
    var latitude: String? = "",
    var longitude: String? = "",
    var state: State? = State(),
    var zip_code: String? = ""
)