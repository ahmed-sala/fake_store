package com.example.fake_store.navigator

import kotlinx.serialization.Serializable

sealed class AppScreens {
@Serializable
data class DetailsScreen(val productId: Int) : AppScreens()
@Serializable
data object ProductsListScreen:AppScreens()

}