package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Variant(
    @SerializedName("brandSize")
    val brandSize: String, // US 7
    @SerializedName("colour")
    val colour: String, // Black
    @SerializedName("colourCode")
    val colourCode: String, // BK1
    @SerializedName("colourWayId")
    val colourWayId: Int, // 16660788
    @SerializedName("id")
    val id: Int, // 14963710
    @SerializedName("isAvailable")
    val isAvailable: Boolean, // false
    @SerializedName("isInStock")
    val isInStock: Boolean, // true
    @SerializedName("isLowInStock")
    val isLowInStock: Boolean, // true
    @SerializedName("isPrimary")
    val isPrimary: Boolean, // true
    @SerializedName("name")
    val name: String, // Fila ray tracer sneakers in black and gold
    @SerializedName("price")
    val price: PriceX,
    @SerializedName("sizeDescription")
    val sizeDescription: String,
    @SerializedName("sizeId")
    val sizeId: Int, // 15478
    @SerializedName("sizeOrder")
    val sizeOrder: Int, // 173
    @SerializedName("sku")
    val sku: String // 9856666
)