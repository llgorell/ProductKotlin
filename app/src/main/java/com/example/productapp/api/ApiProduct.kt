package com.example.productapp.api

import com.example.productapp.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiProduct {

    @GET("/products")
    fun getProduct() : Response<Product>
}