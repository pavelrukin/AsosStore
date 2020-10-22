package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("products")
    val products: MutableList<Product>,
)