package com.example.app_challenge_meli.model.item


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("accepts_mercadopago")
    var acceptsMercadopago: Boolean? = false,
    @SerializedName("attributes")
    var attributes: List<Attribute>? = listOf(),
    @SerializedName("automatic_relist")
    var automaticRelist: Boolean? = false,
    @SerializedName("available_quantity")
    var availableQuantity: Int? = 0,
    @SerializedName("base_price")
    var basePrice: Int? = 0,
    @SerializedName("buying_mode")
    var buyingMode: String? = "",
    @SerializedName("catalog_listing")
    var catalogListing: Boolean? = false,
    @SerializedName("catalog_product_id")
    var catalogProductId: String? = "",
    @SerializedName("category_id")
    var categoryId: String? = "",
    @SerializedName("channels")
    var channels: List<String>? = listOf(),
    @SerializedName("condition")
    var condition: String? = "",
    @SerializedName("coverage_areas")
    var coverageAreas: List<Any>? = listOf(),
    @SerializedName("currency_id")
    var currencyId: String? = "",
    @SerializedName("date_created")
    var dateCreated: String? = "",
    @SerializedName("deal_ids")
    var dealIds: List<Any>? = listOf(),
    @SerializedName("descriptions")
    var descriptions: List<Any>? = listOf(),
    @SerializedName("differential_pricing")
    var differentialPricing: Any? = Any(),
    @SerializedName("domain_id")
    var domainId: String? = "",
    @SerializedName("health")
    var health: Double? = 0.0,
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("initial_quantity")
    var initialQuantity: Int? = 0,
    @SerializedName("international_delivery_mode")
    var internationalDeliveryMode: String? = "",
    @SerializedName("last_updated")
    var lastUpdated: String? = "",
    @SerializedName("listing_source")
    var listingSource: String? = "",
    @SerializedName("listing_type_id")
    var listingTypeId: String? = "",
    @SerializedName("location")
    var location: Location? = Location(),
    @SerializedName("non_mercado_pago_payment_methods")
    var nonMercadoPagoPaymentMethods: List<Any>? = listOf(),
    @SerializedName("official_store_id")
    var officialStoreId: Any? = Any(),
    @SerializedName("original_price")
    var originalPrice: Any? = Any(),
    @SerializedName("parent_item_id")
    var parentItemId: Any? = Any(),
    @SerializedName("permalink")
    var permalink: String? = "",
    @SerializedName("pictures")
    var pictures: List<Picture>? = listOf(),
    @SerializedName("price")
    var price: Double? = 0.0,
    @SerializedName("sale_terms")
    var saleTerms: List<SaleTerm>? = listOf(),
    @SerializedName("secure_thumbnail")
    var secureThumbnail: String? = "",
    @SerializedName("seller_address")
    var sellerAddress: SellerAddress? = SellerAddress(),
    @SerializedName("seller_contact")
    var sellerContact: Any? = Any(),
    @SerializedName("seller_id")
    var sellerId: Int? = 0,
    @SerializedName("shipping")
    var shipping: Shipping? = Shipping(),
    @SerializedName("site_id")
    var siteId: String? = "",
    @SerializedName("sold_quantity")
    var soldQuantity: Int? = 0,
    @SerializedName("start_time")
    var startTime: String? = "",
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("stop_time")
    var stopTime: String? = "",
    @SerializedName("sub_status")
    var subStatus: List<Any>? = listOf(),
    @SerializedName("subtitle")
    var subtitle: Any? = Any(),
    @SerializedName("tags")
    var tags: List<String>? = listOf(),
    @SerializedName("thumbnail")
    var thumbnail: String? = "",
    @SerializedName("thumbnail_id")
    var thumbnailId: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("variations")
    var variations: List<Any>? = listOf(),
    @SerializedName("video_id")
    var videoId: Any? = Any(),
    @SerializedName("warnings")
    var warnings: List<Any>? = listOf(),
    @SerializedName("warranty")
    var warranty: String? = ""
)