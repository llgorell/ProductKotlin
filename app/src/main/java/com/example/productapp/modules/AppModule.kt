package com.example.productapp.modules

import com.example.productapp.api.ApiProduct
import com.example.productapp.repositories.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductRepo(apiProduct: ApiProduct): ProductRepository =
        ProductRepository(apiProduct = apiProduct)


}