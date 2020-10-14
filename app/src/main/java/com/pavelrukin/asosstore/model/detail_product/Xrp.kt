package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Xrp(
    @SerializedName("conversionId")
    val conversionId: String, // 0
    @SerializedName("text")
    val text: String, // $38.00
    @SerializedName("value")
    val value: Double, // 38.00
    @SerializedName("versionId")
    val versionId: String // REGP000002000900098566690000166980
)