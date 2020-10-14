package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("aboutMe")
    val aboutMe: String, // Suede and leather upper<br><br>Sole: 100% Rubber, Upper: 100% Real Leather.
    @SerializedName("careInfo")
    val careInfo: String, // Wipe clean with a soft dry cloth
    @SerializedName("sizeAndFit")
    val sizeAndFit: Any // null
)