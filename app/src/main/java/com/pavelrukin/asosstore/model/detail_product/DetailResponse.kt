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
//  @Ignore
//    @SerializedName("alternateNames") var alternateNames: List<AlternateName>?=null,
//
//    @Ignore
//    @SerializedName("badges") var badges: List<Any>?=null,
//
//    @Ignore
//    @SerializedName("baseUrl") var baseUrl: String?="", // https://www.asos.com
//
//    @Ignore
//    @SerializedName("brand") var brand: Brand?=null,
//
//    @Ignore
//    @SerializedName("countryOfManufacture") var countryOfManufacture: Any?=null, // null
//
//    @Ignore
//    @SerializedName("description") var description: String?="", // <a href="/men/shoes-boots-trainers/trainers/cat/?cid=5775"><strong>Sneakers</strong></a> by <a href="/Men/A-To-Z-Of-Brands/Fila/Cat/pgecategory.aspx?cid=4670"><strong>Fila</strong></a><ul>    <li>Switch up your rotation</li>    <li>Low-profile design</li>    <li>Pull tab for easy entry </li>    <li>Lace-up fastening </li>    <li>Padded tongue and cuff</li>    <li>Signature Fila branding </li>    <li>Contrast panels</li>    <li>Chunky rubber outsole</li>    <li>Textured grip tread</li></ul>
//
//    @Ignore
//    @SerializedName("gender") var gender: String?="", // Men
//    @Ignore
//    @SerializedName("isDeadProduct") var isDeadProduct: Boolean, // false
//    @Ignore
//    @SerializedName("isInStock") var isInStock: Boolean, // true
//    @Ignore
//    @SerializedName("isNoSize") var isNoSize: Boolean, // false
//    @Ignore
//    @SerializedName("isOneSize") var isOneSize: Boolean, // false
//    @Ignore
//    @SerializedName("localisedData") var localisedData: Any?, // null
//    @Ignore
//    @SerializedName("pdpLayout") var pdpLayout: String, // Footwear
//
//    @Ignore
//    @SerializedName("productCode") var productCode: String, // 1682690
//    @Ignore
//    @SerializedName("rating") var rating: Any?, // null
//    @Ignore
//    @SerializedName("shippingRestriction") var shippingRestriction: Any?, // null
//    @Ignore
//    @SerializedName("sizeGuide") var sizeGuide: String, // assets.asosservices.com/asos-ui/SizeGuides/2.0/size-guide.html?productType=1608&brand=202&store=US&division=5&sizeSchema=US
//    @Ignore
//    @SerializedName("sizeGuideApiUrl") var sizeGuideApiUrl: Any?, // null
//    @Ignore
//    @SerializedName("variants") var variants: List<Variant>?,
//    @Ignore
//    @SerializedName("webCategories") var webCategories: List<WebCategory>?,