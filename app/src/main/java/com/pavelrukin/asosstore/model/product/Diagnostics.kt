package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class Diagnostics(
    @SerializedName("processingTime")
    val processingTime: Int, // 102
    @SerializedName("queryTime")
    val queryTime: Int, // 44
    @SerializedName("recommendationsAnalytics")
    val recommendationsAnalytics: RecommendationsAnalytics,
    @SerializedName("recommendationsEnabled")
    val recommendationsEnabled: Boolean, // false
    @SerializedName("requestId")
    val requestId: String // 166640
)