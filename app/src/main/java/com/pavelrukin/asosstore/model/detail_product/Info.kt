package com.pavelrukin.asosstore.model.detail_product


import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class Info(
    @ColumnInfo(name = "aboutMe")
    @SerializedName("aboutMe")
    val aboutMe: String, // Suede and leather upper<br><br>Sole: 100% Rubber, Upper: 100% Real Leather.
    @ColumnInfo(name = "careInfo")
    @SerializedName("careInfo")
    val careInfo: String, // Wipe clean with a soft dry cloth
    @Ignore
    @SerializedName("sizeAndFit")
    val sizeAndFit: Any // null
)