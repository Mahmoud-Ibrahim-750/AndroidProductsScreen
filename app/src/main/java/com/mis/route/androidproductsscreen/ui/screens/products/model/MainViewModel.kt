package com.mis.route.androidproductsscreen.ui.screens.products.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.androidproductsscreen.data.api.ApiManager
import com.mis.route.androidproductsscreen.domain.models.product.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val productsList = MutableLiveData<List<Product?>?>()

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ApiManager.getProductsApiService().getProducts()
            productsList.postValue(response.products)
        }
    }
}