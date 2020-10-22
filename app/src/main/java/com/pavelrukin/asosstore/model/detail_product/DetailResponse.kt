package com.pavelrukin.asosstore.model.detail_product


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "product")
data class DetailResponse(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    @SerializedName("id") var id: Int, // 14963477

    @ColumnInfo(name = "info")
    @SerializedName("info") var info: Info?,

    @ColumnInfo(name = "media")
    @SerializedName("media") var media: Media?,

    @ColumnInfo(name = "name")
    @SerializedName("name") var name: String, // Fila ray tracer sneakers in black and gold

    @ColumnInfo(name = "priceDetail")
    @SerializedName("price") var priceDetail: PriceDetail?,

    @ColumnInfo(name = "productCount")
    var productCount: Int = 1,

    @ColumnInfo(name = "productPrice")
    var productPrice: Double?,

    @ColumnInfo(name = "priceCounting")
    var priceCounting: Double?
)
