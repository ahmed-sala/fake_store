package com.example.fake_store.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val category: Category,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val slug: String,
    val title: String
)