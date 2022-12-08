package com.example.postsappkotlin.data.source.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL =  "https://jsonplaceholder.typicode.com/"
object RetrofitClient {
    private var retrofit :Retrofit?=null

    fun getService(): WebService? {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit?.create(WebService::class.java)
    }


}