package com.pavelrukin.asosstore.model.detail_product


import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class Media(
    @Ignore
    @SerializedName("catwalk")
    val catwalk: List<Any>,
@ColumnInfo(name = "images")
    @SerializedName("images")
    val images: List<Image>,
    @Ignore
    @SerializedName("spinset")
    val spinset: List<Any>,
    @Ignore
    @SerializedName("swatchSprite")
    val swatchSprite: List<Any>
)