package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class PriceX(
    @SerializedName("currency")
    val currency: String, // USD
    @SerializedName("current")
    val current: CurrentX,
    @SerializedName("isMarkedDown")
    val isMarkedDown: Boolean, // false
    @SerializedName("isOutletPrice")
    val isOutletPrice: Boolean, // false
    @SerializedName("previous")
    val previous: PreviousX,
    @SerializedName("rrp")
    val rrp: RrpX,
    @SerializedName("startDateTime")
    val startDateTime: String, // 2020-09-18T07:00:00Z
    @SerializedName("xrp")
    val xrp: XrpX
)