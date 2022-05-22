package com.example.productapp.api

import com.example.productapp.models.Product
import com.example.productapp.models.ServiceResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiProduct {

    @GET("/products")
   suspend fun getProduct() : Product
}