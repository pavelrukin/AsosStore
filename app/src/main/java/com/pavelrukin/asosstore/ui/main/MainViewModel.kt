package com.pavelrukin.asosstore.ui.main

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pavelrukin.asosstore.AsosStoreApp
import com.pavelrukin.asosstore.model.product.ProductResponse
import com.pavelrukin.asosstore.repository.ProductRepository
import com.pavelrukin.asosstore.utils.Resource
import com.pavelrukin.asosstore.utils.extensions.isConnected
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class MainViewModel(private val repository: ProductRepository, app: AsosStoreApp) : AndroidViewModel(app) {


    val productList: MutableLiveData<Resource<ProductResponse>> = MutableLiveData()
    var productListResponse: ProductResponse? = null
var limit:Int = 100
init {
    getProductList(limit)
}

        fun getProductList(limit: Int)   = viewModelScope.launch{
        productList.postValue(Resource.Loading())
        try {

            if (getApplication<AsosStoreApp>().isConnected) {
                productList.postValue(Resource.Loading())
                val response = repository.getProductList(limit)
                productList.postValue(handledProductList(response))
            } else {

                productList.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> productList.postValue(Resource.Error("Network Failure"))
                else -> productList.postValue(Resource.Error("Conversion Error"))
            }
        }
    }
    private fun handledProductList(response: Response<ProductResponse>): Resource<ProductResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->

                if (productListResponse == null) {
                    productListResponse = resultResponse

                } else {
                    val old = productListResponse?.products
                    val new = resultResponse.products
                    old?.addAll(new)
                }
                return Resource.Success(productListResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}