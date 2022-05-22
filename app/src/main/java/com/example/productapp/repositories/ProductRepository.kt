package com.example.productapp.repositories

import com.example.productapp.api.ApiProduct
import com.example.productapp.models.Product
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ActivityScoped
class ProductRepository @Inject constructor(private val apiProduct: ApiProduct) {

    suspend fun getProducts(): Product {
        return apiProduct.getProduct()
    }

}