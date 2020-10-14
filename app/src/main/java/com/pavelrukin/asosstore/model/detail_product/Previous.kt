package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Previous(
    @SerializedName("conversionId")
    val conversionId: Any, // null
    @SerializedName("text")
    val text: String, // $60.00
    @SerializedName("value")
    val value: Double, // 60.0
    @SerializedName("versionId")
    val versionId: String // REGP000002000900098566690000166980
)