package com.pavelrukin.asosstore.ui.basket

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavelrukin.asosstore.AsosStoreApp
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.repository.ProductRepository
import kotlinx.coroutines.launch

class BasketViewModel(private val repository: ProductRepository, app: AsosStoreApp) : AndroidViewModel(app) {

    fun getSavedProduct() = repository.getSavedProduct()


    fun deleteProduct(product: DetailResponse) = viewModelScope.launch {
        repository.deleteProduct(product)
    }
    suspend fun update(product: DetailResponse) = viewModelScope.launch {
        repository.updateCount(product)
    }

    fun btnPlus(product: DetailResponse) = viewModelScope.launch {
        product.productCount++
        product.priceCounting = product.priceCounting?.plus(product.productPrice!!)
        update(product)
    }

    fun btnMinus(product: DetailResponse) = viewModelScope.launch {
        product.productCount--
        product.priceCounting = product.priceCounting?.minus(product.productPrice!!)
        update(product)
    }
    fun saveProduct(product: DetailResponse) = viewModelScope.launch {
        product.productCount = 1
        product.productPrice = product.priceDetail?.current?.value
        product.priceCounting = product.priceDetail?.current?.value
        repository.insert(product)
    }
}