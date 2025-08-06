package com.example.fake_store.navigator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.fake_store.navigator.AppScreens
import com.example.fake_store.ui.viewmodel.ProductsViewmodel

@Composable
fun MainNavigation(
    productsViewModel: ProductsViewmodel
) { // Added viewmodel parameter
    val navController = rememberNavController()

    Scaffold { padding ->
        Box(modifier = Modifier.padding(padding)) {
            NavHost(
                navController = navController,
                startDestination = AppScreens.ProductsListScreen
            ) {
                mainGraph(navController, productsViewModel) // Pass navController and viewmodel
            }
        }
    }
}