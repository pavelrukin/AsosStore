package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("campaigns")
    val campaigns: Campaigns,
    @SerializedName("categoryName")
    val categoryName: String, // Shoes, Boots & Sneakers
    @SerializedName("diagnostics")
    val diagnostics: Diagnostics,
    @SerializedName("discoverSearchProductTypes")
    val discoverSearchProductTypes: List<Any>,
    @SerializedName("facets")
    val facets: List<Facet>,
    @SerializedName("itemCount")
    val itemCount: Int, // 1426
    @SerializedName("products")
    val products: MutableList<Product>,
    @SerializedName("queryId")
    val queryId: Any, // null
    @SerializedName("redirectUrl")
    val redirectUrl: String,
    @SerializedName("searchPassMeta")
    val searchPassMeta: SearchPassMeta,
    @SerializedName("searchTerm")
    val searchTerm: String
)