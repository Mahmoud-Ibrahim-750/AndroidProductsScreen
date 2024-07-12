package com.mis.route.androidproductsscreen.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiManager {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getProductsApiService(): ProductsApiService {
        return retrofit.create(ProductsApiService::class.java)
    }
}