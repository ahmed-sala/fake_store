package com.example.fake_store.data.repo

import com.example.fake_store.data.models.ProductResponse
import com.example.fake_store.networking.ApiResult
import com.example.fake_store.networking.RetrofitClient

class ProductsRepo {
     suspend fun getProducts(): ApiResult<List<ProductResponse>> {
         return try{
                val response = RetrofitClient().apiService.getProducts()
                if (response.isSuccessful && response.body() != null) {
                    ApiResult.Success(response.body()!!)
                } else {
                    ApiResult.Error("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                ApiResult.Error("Exception: ${e.message ?: "Unknown error"}")
         }
     }
}