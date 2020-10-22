package com.pavelrukin.asosstore.model.detail_product


import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class Current(

    @SerializedName("text")
    val text: String?, // $60.00
    @SerializedName("value")
    var value: Double?, // 60.0

)