package com.example.fake_store.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fake_store.data.models.ProductResponse
import com.example.fake_store.data.repo.ProductsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewmodel : ViewModel() {
    private val _productsState=MutableStateFlow<List<ProductResponse>>(emptyList())
    val productsState: StateFlow<List<ProductResponse>> = _productsState

    init {
        getProducts()
    }

    fun getProducts() {

         viewModelScope.launch {
             _productsState.value = ProductsRepo().getProducts()
         }
    }
}