package com.example.postsappkotlin.ui.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.postsappkotlin.data.model.PostResponseItem
import com.example.postsappkotlin.data.source.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel:ViewModel() {

    private val _postsLiveData = MutableLiveData<List<PostResponseItem>>()
    val postsLiveData get()= _postsLiveData
    private val _messageLiveData =MutableLiveData<String>()
    val messageLiveData get() = _messageLiveData




    fun getPosts(){
        RetrofitClient.getService()?.getPosts()?.enqueue(object  :Callback<List<PostResponseItem>>{
            override fun onResponse(
                call: Call<List<PostResponseItem>>?,
                response: Response<List<PostResponseItem>>?
            ) {

                response?.let { postsResponse ->
                    if (postsResponse.isSuccessful)
                        _postsLiveData.value=postsResponse.body()
                }
            }

            override fun onFailure(call: Call<List<PostResponseItem>>?, t: Throwable?) {
                t?.let {
                    _messageLiveData.value = t.localizedMessage
                }
            }
        })
    }
}