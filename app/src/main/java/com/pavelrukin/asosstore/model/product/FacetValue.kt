package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class FacetValue(
    @SerializedName("count")
    val count: Int, // 193
    @SerializedName("id")
    val id: String, // sale
    @SerializedName("isSelected")
    val isSelected: Boolean, // false
    @SerializedName("name")
    val name: String // Sale
)