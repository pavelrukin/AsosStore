package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class Previous(
    @SerializedName("text")
    val text: String,
    @SerializedName("value")
    val value: Any // null
)