package com.foxhole.spacex.di

import com.foxhole.spacex.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
@Module
class NetworkModule {

    @Provides
    @AppScope
    fun providesLoggingInterceptor() = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @AppScope
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().also {
        it.addInterceptor(interceptor)
    }.build()

    @Provides
    @AppScope
    fun providesRetrofitClient(client: OkHttpClient) : Retrofit = Retrofit.Builder().also {
        it.baseUrl(BASE_URL)
        it.client(client)
        it.addConverterFactory(GsonConverterFactory.create())
    }.build()
}