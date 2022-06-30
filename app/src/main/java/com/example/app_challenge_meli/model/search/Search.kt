package com.example.app_challenge_meli.model.search

data class Search(
    var available_filters: List<AvailableFilter>? = listOf(),
    var available_sorts: List<AvailableSort>? = listOf(),
    var country_default_time_zone: String? = "",
    var filters: List<Filter>? = listOf(),
    var paging: Paging? = Paging(),
    var query: String? = "",
    var results: ArrayList<Producto>? = arrayListOf(),
    var site_id: String? = "",
    var sort: Sort? = Sort()
)