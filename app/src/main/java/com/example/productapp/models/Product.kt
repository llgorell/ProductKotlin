package com.example.productapp.models

data class Product(
    val products: List<ProductX>,
    val total: Int,
    val skip: Int,
    val limit: Int
)