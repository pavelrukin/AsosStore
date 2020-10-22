package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class PriceDetail(
    @SerializedName("currency")
    val currency: String, // USD
    @SerializedName("current")
    val current: Current,
)