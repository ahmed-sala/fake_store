package com.example.fake_store.data.repo

import com.example.fake_store.data.models.ProductResponse
import com.example.fake_store.networking.RetrofitClient

class ProductsRepo {
     suspend fun getProducts(): List<ProductResponse> {
         return RetrofitClient().apiService.getProducts()
     }
}