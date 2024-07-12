package com.mis.route.androidproductsscreen.data.api

import com.mis.route.androidproductsscreen.domain.models.product.ProductsResponse
import retrofit2.http.GET


interface ProductsApiService {

    @GET("products")
    suspend fun getProducts(): ProductsResponse
}