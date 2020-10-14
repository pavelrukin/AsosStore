package com.pavelrukin.asosstore.model.detail_product


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("alternateNames") val alternateNames: List<AlternateName>,
    @SerializedName("badges") val badges: List<Any>,
    @SerializedName("baseUrl") val baseUrl: String, // https://www.asos.com
    @SerializedName("brand") val brand: Brand,
    @SerializedName("countryOfManufacture") val countryOfManufacture: Any, // null
    @SerializedName("description") val description: String, // <a href="/men/shoes-boots-trainers/trainers/cat/?cid=5775"><strong>Sneakers</strong></a> by <a href="/Men/A-To-Z-Of-Brands/Fila/Cat/pgecategory.aspx?cid=4670"><strong>Fila</strong></a><ul>    <li>Switch up your rotation</li>    <li>Low-profile design</li>    <li>Pull tab for easy entry </li>    <li>Lace-up fastening </li>    <li>Padded tongue and cuff</li>    <li>Signature Fila branding </li>    <li>Contrast panels</li>    <li>Chunky rubber outsole</li>    <li>Textured grip tread</li></ul>
    @SerializedName("gender") val gender: String, // Men
    @SerializedName("id") val id: Int, // 14963477
    @SerializedName("info") val info: Info,
    @SerializedName("isDeadProduct") val isDeadProduct: Boolean, // false
    @SerializedName("isInStock") val isInStock: Boolean, // true
    @SerializedName("isNoSize") val isNoSize: Boolean, // false
    @SerializedName("isOneSize") val isOneSize: Boolean, // false
    @SerializedName("localisedData") val localisedData: Any, // null
    @SerializedName("media") val media: Media,
    @SerializedName("name") val name: String, // Fila ray tracer sneakers in black and gold
    @SerializedName("pdpLayout") val pdpLayout: String, // Footwear
    @SerializedName("price") val price: Price,
    @SerializedName("productCode") val productCode: String, // 1682690
    @SerializedName("rating") val rating: Any, // null
    @SerializedName("shippingRestriction") val shippingRestriction: Any, // null
    @SerializedName("sizeGuide") val sizeGuide: String, // assets.asosservices.com/asos-ui/SizeGuides/2.0/size-guide.html?productType=1608&brand=202&store=US&division=5&sizeSchema=US
    @SerializedName("sizeGuideApiUrl") val sizeGuideApiUrl: Any, // null
    @SerializedName("variants") val variants: List<Variant>,
    @SerializedName("webCategories") val webCategories: List<WebCategory>
)