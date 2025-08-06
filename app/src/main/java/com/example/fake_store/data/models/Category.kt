package com.example.fake_store.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int,
    val image: String,
    val name: String,
    val slug: String
)