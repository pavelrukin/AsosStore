package com.pavelrukin.asosstore.repository

import androidx.lifecycle.LiveData
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.model.product.ProductResponse
import retrofit2.Response

interface IProductRepository {
    suspend fun getProductList(limit: Int): Response<ProductResponse>
    suspend fun getDetailProduct(id: Int): Response<DetailResponse>
    suspend fun upsert(product: DetailResponse)
    fun getSavedProduct(): LiveData<List<DetailResponse>>
    suspend fun deleteProduct(product: DetailResponse)
    suspend fun getProduct(id: Int): DetailResponse?
}
