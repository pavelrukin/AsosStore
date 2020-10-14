package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class Campaigns(
    @SerializedName("promoBanners")
    val promoBanners: List<Any>
)