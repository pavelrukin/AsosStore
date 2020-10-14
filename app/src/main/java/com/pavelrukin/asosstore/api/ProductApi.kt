package com.pavelrukin.asosstore.api

import com.pavelrukin.asosstore.utils.Constants
import com.pavelrukin.asosstore.model.product.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET("products/v2/list")
    suspend fun getProductList(
        @Query("limit")
        limit:Int = 20,
        @Query("categoryId")
        categoryId: Int = 4209,
        @Query("sort")
        sort: String = "freshness",
        @Query("country")
        country: String = "US",
        @Query("currency")
        currency: String = "USD",
        @Query("lang")
        lang: String = "en-US",
        @Query("sizeSchema")
        sizeSchema: String = "US",
        @Query("offset")
        offset: Int = 0,
        @Query("store")
        store:String = "US",
        @Query("rapidapi-key")
        rapidapi_key:String = Constants.API_KEY
    ): Response<ProductResponse>


}