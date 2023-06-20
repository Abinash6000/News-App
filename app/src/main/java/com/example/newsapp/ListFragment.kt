package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.adapter.CategoryAdapter
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.DataSource
import com.example.newsapp.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private val viewModel: NewsViewModel by viewModels()
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // Category RecyclerView
        val dataSource = DataSource()
        val categoryAdp = CategoryAdapter(dataSource.loadCategory())
        binding.categoryRV.adapter = categoryAdp

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            viewModel.news.observe(viewLifecycleOwner) { data ->
                // News RecyclerView
                val articles = data.articles
                val newsAdp = articles?.let { NewsAdapter(it) }
                binding.newsRV.adapter = newsAdp
            }
        } catch (e: Exception) {
            Log.d("adflljksfd", e.toString())
        }

        viewModel.getNews()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}