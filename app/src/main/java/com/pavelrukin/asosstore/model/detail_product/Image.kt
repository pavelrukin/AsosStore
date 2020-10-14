package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("colour")
    val colour: String, // Black
    @SerializedName("colourCode")
    val colourCode: String, // BK1
    @SerializedName("colourWayId")
    val colourWayId: Int, // 16660788
    @SerializedName("isPrimary")
    val isPrimary: Boolean, // true
    @SerializedName("type")
    val type: String, // Standard1
    @SerializedName("url")
    val url: String // images.asos-media.com/products/fila-ray-tracer-sneakers-in-black-and-gold/14963477-1-black
)