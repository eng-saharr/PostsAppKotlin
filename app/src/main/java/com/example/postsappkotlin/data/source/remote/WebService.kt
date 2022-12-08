package com.example.postsappkotlin.data.source.remote

import com.example.postsappkotlin.data.model.PostResponseItem
import retrofit2.http.GET
import retrofit2.Call

interface WebService {
    @GET("posts")
    fun getPosts(): Call<List<PostResponseItem>>
}