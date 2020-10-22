package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("url")
    val url: String // images.asos-media.com/products/fila-ray-tracer-sneakers-in-black-and-gold/14963477-1-black
)