package com.pavelrukin.asosstore.model.detail_product


import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class PriceDetail(
    @SerializedName("currency")
    val currency: String, // USD
    @SerializedName("current")
    val current: Current,
  /*  @Ignore
    @SerializedName("isMarkedDown")
    val isMarkedDown: Boolean, // false
    @Ignore
    @SerializedName("isOutletPrice")
    val isOutletPrice: Boolean, // false
    @Ignore
    @SerializedName("previous")
    val previous: Previous,
    @Ignore
    @SerializedName("rrp")
    val rrp: Rrp,
    @SerializedName("startDateTime")
    val startDateTime: String, // 2020-09-18T07:00:00Z
    @Ignore
    @SerializedName("xrp")
    val xrp: Xrp*/
 
)