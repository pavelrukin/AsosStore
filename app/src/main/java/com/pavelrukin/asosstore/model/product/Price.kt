package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("currency")
    val currency: String, // USD
    @SerializedName("current")
    val current: Current,
    @SerializedName("isMarkedDown")
    val isMarkedDown: Boolean, // false
    @SerializedName("isOutletPrice")
    val isOutletPrice: Boolean, // false
    @SerializedName("previous")
    val previous: Previous,
    @SerializedName("rrp")
    val rrp: Rrp
)