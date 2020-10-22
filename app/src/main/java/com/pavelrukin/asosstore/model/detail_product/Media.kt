package com.pavelrukin.asosstore.model.detail_product


import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Media(
    @ColumnInfo(name = "images")
    @SerializedName("images")
    val images: List<Image>,
)