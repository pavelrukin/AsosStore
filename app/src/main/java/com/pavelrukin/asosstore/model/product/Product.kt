package com.pavelrukin.asosstore.model.product


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class Product(
    @SerializedName("id")
    val id: Int, // 20669475
    @SerializedName("imageUrl")
    val imageUrl: String, // images.asos-media.com/products/under-armour-hovr-start-sneakers-in-black/20669475-1-black
    @SerializedName("name")
    val name: String, // Under Armour HOVR Start sneakers in black
    @SerializedName("price")
    var price: @RawValue Price? = null
) : Parcelable
//RawValue