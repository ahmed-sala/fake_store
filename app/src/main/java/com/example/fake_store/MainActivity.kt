package com.example.fake_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.fake_store.navigator.MainNavigation
import com.example.fake_store.ui.theme.Fake_storeTheme
import com.example.fake_store.ui.viewmodel.ProductsViewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: ProductsViewmodel by viewModels()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Fake_storeTheme {
                MainNavigation(productsViewModel = viewModel)
            }
        }
    }
}