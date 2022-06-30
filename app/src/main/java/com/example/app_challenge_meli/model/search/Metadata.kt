package com.example.app_challenge_meli.model.search

data class Metadata(
    var campaign_discount_percentage: Double? = 0.0,
    var campaign_end_date: String? = "",
    var campaign_id: String? = "",
    var discount_meli_amount: Int? = 0,
    var funding_mode: String? = "",
    var order_item_price: Int? = 0,
    var promotion_id: String? = "",
    var promotion_type: String? = ""
)