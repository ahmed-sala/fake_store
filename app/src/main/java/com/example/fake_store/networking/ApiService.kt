package com.example.fake_store.networking

import com.example.fake_store.AppConstants
import com.example.fake_store.data.models.ProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET(AppConstants.PRODUCTS_ENDPOINT)
    suspend fun getProducts(): List<ProductResponse>
}