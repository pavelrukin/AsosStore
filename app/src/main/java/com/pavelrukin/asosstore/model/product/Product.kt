package com.pavelrukin.asosstore.model.product


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class Product(
    @SerializedName("brandName")
    val brandName: String, // Under Armour
    @SerializedName("colour")
    val colour: String,
    @SerializedName("colourWayId")
    val colourWayId: Int, // 60077844
    @SerializedName("groupId")
    val groupId: String, // null
    @SerializedName("hasMultiplePrices")
    val hasMultiplePrices: Boolean, // false
    @SerializedName("hasVariantColours")
    val hasVariantColours: Boolean, // false
    @SerializedName("id")
    val id: Int, // 20669475
    @SerializedName("imageUrl")
    val imageUrl: String, // images.asos-media.com/products/under-armour-hovr-start-sneakers-in-black/20669475-1-black
    @SerializedName("isSellingFast")
    val isSellingFast: Boolean, // false
    @SerializedName("name")
    val name: String, // Under Armour HOVR Start sneakers in black
    @SerializedName("price")
    var price:  @RawValue Price?=null,
    @SerializedName("productCode")
    val productCode: Int, // 1739784
    @SerializedName("productType")
    val productType: String, // Product
    @SerializedName("url")
    val url: String, // under-armour/under-armour-hovr-start-sneakers-in-black/prd/20669475?colourwayid=60077844
 /*   @SerializedName("videoUrl")
    val videoUrl:  @RawValue Any?=null // null*/
): Parcelable
//RawValue