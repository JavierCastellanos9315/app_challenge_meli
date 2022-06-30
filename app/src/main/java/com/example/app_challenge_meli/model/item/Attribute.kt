package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("attribute_group_id")
    var attributeGroupId: String? = "",
    @SerializedName("attribute_group_name")
    var attributeGroupName: String? = "",
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("value_id")
    var valueId: String? = "",
    @SerializedName("value_name")
    var valueName: String? = "",
    @SerializedName("value_struct")
    var valueStruct: Any? = Any(),
    @SerializedName("values")
    var values: List<Value?>? = listOf()
)