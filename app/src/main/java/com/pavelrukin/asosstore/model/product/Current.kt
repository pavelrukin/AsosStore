package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("text")
    val text: String, // $101.65
    @SerializedName("value")
    val value: Double // 101.65
)