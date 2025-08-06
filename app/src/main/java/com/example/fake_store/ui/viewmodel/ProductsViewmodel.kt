package com.example.fake_store.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fake_store.data.models.ProductResponse
import com.example.fake_store.data.repo.ProductsRepo
import com.example.fake_store.networking.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewmodel : ViewModel() {
    private val _productsState = MutableStateFlow<ApiResult<List<ProductResponse>>>(ApiResult.Loading)
    val productsState: StateFlow<ApiResult<List<ProductResponse>>> = _productsState

    init {
        getProducts()
    }

    fun getProducts() {

         viewModelScope.launch {
             _productsState.value = ApiResult.Loading
             _productsState.value = ProductsRepo().getProducts()         }
    }
}