package com.pavelrukin.asosstore.model.product


import com.google.gson.annotations.SerializedName

data class Facet(
    @SerializedName("displayStyle")
    val displayStyle: String, // Single-Column
    @SerializedName("facetType")
    val facetType: String, // TextMultiSelect
    @SerializedName("facetValues")
    val facetValues: List<FacetValue>,
    @SerializedName("hasSelectedValues")
    val hasSelectedValues: Boolean, // false
    @SerializedName("id")
    val id: String, // range
    @SerializedName("name")
    val name: String // Sale/New Season
)