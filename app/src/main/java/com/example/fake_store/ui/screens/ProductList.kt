package com.example.fake_store.ui.screens

import ProductItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fake_store.ui.viewmodel.ProductsViewmodel

@Composable
fun ProductListScreen(productsViewModel: ProductsViewmodel) {
    val productsList by productsViewModel.productsState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(productsList) { product ->
            ProductItem(product = product)
        }
    }
}
