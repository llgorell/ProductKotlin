package com.example.productapp.models

data class ProductX(
    val brand: String?="",
    val category: String?="",
    val description: String?="",
    val discountPercentage: Double? = null,
    val id: Int? = 0,
    val images: List<String>? = null,
    val price: Int? = 0,
    val rating: Double? = null,
    val stock: Int? = 0,
    val thumbnail: String?="",
    val title: String?=""
)