package com.pavelrukin.asosstore.repository

import com.pavelrukin.asosstore.api.ProductApi
import com.pavelrukin.asosstore.db.ProductDatabase
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.model.product.ProductResponse

class ProductRepository(val api: ProductApi,val db:ProductDatabase):IProductRepository {


    override suspend fun getProductList(limit: Int) = api.getProductList(limit)

    override suspend fun getDetailProduct(id: Int) = api.getDetailProduct(id)


    override suspend fun upsert(product: DetailResponse) = db.getProductDao().upsert(product)
    override fun getSavedProduct() = db.getProductDao().getAllProducts()

    override suspend fun deleteProduct(product: DetailResponse) = db.getProductDao().deleteProduct(product)
    override suspend fun getProduct(id: Int) = db.getProductDao().getProduct(id)

}