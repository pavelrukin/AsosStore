package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class RecommendationsAnalytics(
    @SerializedName("items")
    val items: List<Any>,
    @SerializedName("numberOfItems")
    val numberOfItems: Int, // 0
    @SerializedName("numberOfRecs")
    val numberOfRecs: Int, // 0
    @SerializedName("personalisationStatus")
    val personalisationStatus: Int, // 4
    @SerializedName("personalisationType")
    val personalisationType: String
)