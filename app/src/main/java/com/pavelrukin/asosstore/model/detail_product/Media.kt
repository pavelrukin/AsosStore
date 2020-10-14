package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("catwalk")
    val catwalk: List<Any>,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("spinset")
    val spinset: List<Any>,
    @SerializedName("swatchSprite")
    val swatchSprite: List<Any>
)