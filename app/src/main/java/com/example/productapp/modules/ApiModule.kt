package com.example.productapp.modules

import com.example.productapp.api.ApiProduct
import com.example.productapp.api.NetworkUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideApi() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(NetworkUtil.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideProduct() : ApiProduct{
        return provideApi().create(ApiProduct::class.java)
    }
}