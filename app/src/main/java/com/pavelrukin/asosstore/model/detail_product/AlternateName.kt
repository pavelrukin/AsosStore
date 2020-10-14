package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class AlternateName(
    @SerializedName("locale")
    val locale: String, // en-GB
    @SerializedName("title")
    val title: String // Fila ray tracer sneakers in black and gold
)