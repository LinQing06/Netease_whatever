package com.example.linqing.netease_whatever.Sevice


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetModel {

   private const val BASE_URL = "http://172.23.117.230:3000/"
    private val client = OkHttpClient
            .Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()


    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    inline operator fun <reified T> invoke(): T = retrofit.create(T::class.java)


}