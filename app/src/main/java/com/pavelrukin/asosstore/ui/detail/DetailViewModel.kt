package com.pavelrukin.asosstore.ui.detail

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pavelrukin.asosstore.AsosStoreApp
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.repository.ProductRepository
import com.pavelrukin.asosstore.utils.Resource
import com.pavelrukin.asosstore.utils.extensions.isConnected
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException


class DetailViewModel(private val repository: ProductRepository, app: AsosStoreApp) :
    AndroidViewModel(app) {


    val detailProduct: MutableLiveData<Resource<DetailResponse>> = MutableLiveData()
    var detailProductResponse: DetailResponse? = null


    fun saveProduct(product: DetailResponse) = viewModelScope.launch {
        product.productCount = 1
        product.productPrice = product.priceDetail?.current?.value
        product.priceCounting = product.priceDetail?.current?.value
        repository.insert(product)
    }

    fun getProductList(id: Int) = viewModelScope.launch {
        detailProduct.postValue(Resource.Loading())
        try {

            if (getApplication<AsosStoreApp>().isConnected) {
                detailProduct.postValue(Resource.Loading())
                val response = repository.getDetailProduct(id)
                detailProduct.postValue(handledProductList(response))
            } else {

                detailProduct.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> detailProduct.postValue(Resource.Error("Network Failure"))
                else -> detailProduct.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private fun handledProductList(response: Response<DetailResponse>): Resource<DetailResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->

                if (detailProductResponse == null) {
                    detailProductResponse = resultResponse
                }
                return Resource.Success(detailProductResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}

