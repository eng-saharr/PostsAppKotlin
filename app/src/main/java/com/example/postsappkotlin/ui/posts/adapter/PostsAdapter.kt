package com.example.postsappkotlin.ui.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postsappkotlin.data.model.PostResponseItem
import com.example.postsappkotlin.databinding.FragmentPostsBinding
import com.example.postsappkotlin.databinding.ItemPostsLayoutBinding

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostHolder>() {

    private var posts:List<PostResponseItem>?=null
    fun addPosts(posts:List<PostResponseItem>){
        this.posts=posts
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = ItemPostsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)
    }


    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        with(holder){
            binding.apply {
               tx1.text = posts?.get(position)?.title
                tx2.text=posts?.get(position)?.id.toString()
            }
        }
    }

    override fun getItemCount(): Int = posts?.size ?:0
    class PostHolder( val binding: ItemPostsLayoutBinding) :RecyclerView.ViewHolder(binding.root)




}