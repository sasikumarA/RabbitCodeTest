package com.labtask.rabbitcodetest.network

import com.labtask.rabbitcodetest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkConfig {

    private lateinit var retrofit: Retrofit
    private const val TIMEOUT_CONNECTION = 60000L

    fun init() {
        val client = OkHttpClient().newBuilder()
            .addInterceptor(getLoggingInterceptor())
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .build()
        retrofit = Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.mocky.io/")
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }

    val employeeAPI by lazy {
        retrofit.create(
            EmployeeAPI::class.java
        )
    }
}