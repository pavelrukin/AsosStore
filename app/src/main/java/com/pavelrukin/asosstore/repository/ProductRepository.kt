package com.pavelrukin.asosstore.repository

import com.pavelrukin.asosstore.api.ProductApi
import com.pavelrukin.asosstore.db.ProductDatabase
import com.pavelrukin.asosstore.model.detail_product.DetailResponse

class ProductRepository(val api: ProductApi, val db: ProductDatabase) : IProductRepository {


    override suspend fun getProductList(limit: Int) = api.getProductList(limit)

    override suspend fun getDetailProduct(id: Int) = api.getDetailProduct(id)


    override suspend fun insert(product: DetailResponse) = db.getProductDao().insert(product)

    override fun getSavedProduct() = db.getProductDao().getAllProducts()


    override suspend fun deleteProduct(product: DetailResponse) = db.getProductDao().deleteProduct(product)

    override suspend fun getProduct(id: Int) = db.getProductDao().getProduct(id)
    override suspend fun updateCount(product: DetailResponse) =db.getProductDao().updateCount(product)


    // override suspend fun updateCount(count: Int, id: Int) : Int? = db.getProductDao().updateCount(count, id)
}