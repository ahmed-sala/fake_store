package com.example.fake_store.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fake_store.data.models.ProductResponse
import com.example.fake_store.networking.ApiResult
import com.example.fake_store.ui.viewmodel.ProductsViewmodel

@Composable
fun ProductListScreen(
    productsViewModel: ProductsViewmodel,
    onProductClick: (ProductResponse) -> Unit // Added navigation callback
) {
    val productState by productsViewModel.productsState.collectAsState()

    when (productState) {
        is ApiResult.Error -> {
            val errorMessage = (productState as ApiResult.Error).message
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error: $errorMessage",
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        ApiResult.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is ApiResult.Success -> {
            val productList = (productState as ApiResult.Success<List<ProductResponse>>).data
            if (productList.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No products available",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = 16.dp,
                            end = 24.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(productList) { product ->
                        ProductItem(
                            product = product,
                            onClick = onProductClick // Pass the callback to ProductItem
                        )
                    }
                }
            }
        }
    }
}