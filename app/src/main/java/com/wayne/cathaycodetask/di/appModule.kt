package com.wayne.cathaycodetask.di

import com.wayne.cathaycodetask.Constant
import com.wayne.cathaycodetask.model.Repository
import com.wayne.cathaycodetask.model.api.TaipeiZooService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single { createOkHttpClient() }
    single { createTaipeiZooService(get()) }
    single { createRepository(get()) }
}

fun createOkHttpClient() : OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()
}

fun createTaipeiZooService(okHttpClient: OkHttpClient): TaipeiZooService {
    val retrofit =  Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constant.DATA_TAIPEI_URL)
        .build()
    return retrofit.create(TaipeiZooService::class.java)
}

fun createRepository(taipeiZooService: TaipeiZooService): Repository {
    return Repository(taipeiZooService)
}