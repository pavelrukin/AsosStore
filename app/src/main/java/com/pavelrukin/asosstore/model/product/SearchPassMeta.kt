package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class SearchPassMeta(
    @SerializedName("alternateSearchTerms")
    val alternateSearchTerms: List<Any>,
    @SerializedName("isPartial")
    val isPartial: Boolean, // false
    @SerializedName("isSpellcheck")
    val isSpellcheck: Boolean, // false
    @SerializedName("searchPass")
    val searchPass: List<Any>
)