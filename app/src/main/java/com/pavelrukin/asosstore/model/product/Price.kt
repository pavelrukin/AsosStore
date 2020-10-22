package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("current")
    val current: Current,
)