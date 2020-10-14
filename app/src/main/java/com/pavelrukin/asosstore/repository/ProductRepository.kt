package com.pavelrukin.asosstore.repository

import com.pavelrukin.asosstore.api.ProductApi

class ProductRepository( val api: ProductApi) {


    suspend fun getProductList(limit:Int) = api.getProductList(limit)




}