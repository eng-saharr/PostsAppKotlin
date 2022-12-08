package com.example.postsappkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postsappkotlin.R
import com.example.postsappkotlin.databinding.FragmentPostsBinding
import com.example.postsappkotlin.ui.posts.PostViewModel
import com.example.postsappkotlin.ui.posts.adapter.PostsAdapter

class PostsFragment : Fragment() {
    lateinit var postViewModel: PostViewModel
    private var _binding : FragmentPostsBinding? =null
    private val binding get() = _binding!!
    private lateinit var postsAdapter: PostsAdapter

    private fun setUpRecycler(){
        postsAdapter= PostsAdapter()

        binding.postsRecycle.apply {
            adapter = postsAdapter
           layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        postViewModel.getPosts()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding=FragmentPostsBinding.bind(view)
        setUpRecycler()
        observe()
    }
    private fun observe(){
        postViewModel.postsLiveData.observe(viewLifecycleOwner){posts ->
            postsAdapter.addPosts(posts)

        }
        postViewModel.messageLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext()," "+it,Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    }
