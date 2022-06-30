package com.example.app_challenge_meli.model.description


import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("date_created")
    var dateCreated: String? = "",
    @SerializedName("last_updated")
    var lastUpdated: String? = "",
    @SerializedName("plain_text")
    var plainText: String? = "",
    @SerializedName("snapshot")
    var snapshot: Snapshot? = Snapshot(),
    @SerializedName("text")
    var text: String? = ""
)