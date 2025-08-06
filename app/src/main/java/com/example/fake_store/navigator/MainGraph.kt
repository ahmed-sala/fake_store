package com.example.fake_store.navigator

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.fake_store.navigator.AppScreens
import com.example.fake_store.ui.screens.ProductDetailsScreen // Import the details screen
import com.example.fake_store.ui.screens.ProductListScreen
import com.example.fake_store.ui.viewmodel.ProductsViewmodel

fun NavGraphBuilder.mainGraph(
    navController: NavController,
    productsViewModel: ProductsViewmodel
) {
    composable<AppScreens.ProductsListScreen> {
        ProductListScreen(
            productsViewModel = productsViewModel,
            onProductClick = { product ->
                navController.navigate(AppScreens.DetailsScreen(product.id))
            }
        )
    }
    composable<AppScreens.DetailsScreen> { backStackEntry ->
        val detailsScreen = backStackEntry.toRoute<AppScreens.DetailsScreen>()
        val product = productsViewModel.getProductById(detailsScreen.productId)
        if (product != null) {
            ProductDetailsScreen(product = product)
        } else {
            Text("Product not found")
        }
    }
}