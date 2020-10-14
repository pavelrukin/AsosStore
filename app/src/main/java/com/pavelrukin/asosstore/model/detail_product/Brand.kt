package com.pavelrukin.asosstore.model.detail_product


import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("brandId")
    val brandId: Int, // 202
    @SerializedName("description")
    val description: String, // Founded in 1911 by the Fila brothers in Biella, Italy, <strong>Fila </strong>packs more than 100 years of heritage into its streetwear designs. After starting life producing undergarments, its iconic designs were adopted by the Casuals movement of the '80s, and the rest is streetwear history. <a href="/Men/A-To-Z-Of-Brands/Fila/Cat/pgecategory.aspx?cid=4670"><strong>Fila Vintage</strong></a> celebrates the brand’s legacy with a collection of polo shirts, track tops, T-shirts and sweatpants straight from their archives.
    @SerializedName("name")
    val name: String // Fila
)