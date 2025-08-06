package com.example.fake_store.data.models

import java.io.Serializable


@kotlinx.serialization.Serializable
data class Category(
    val id: Int,
    val image: String,
    val name: String,
    val slug: String
): Serializable