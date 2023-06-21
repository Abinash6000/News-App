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

        viewModel.news.observe(viewLifecycleOwner) { data ->
            // News RecyclerView
            val articles = data.articles
            if (articles != null) {
                for(article in articles) {
                    if (article.urlToImage==null)
                        articles.remove(article)
                }
            }
            val newsAdp = articles?.let { NewsAdapter(it) }
            binding.newsRV.adapter = newsAdp
        }

        viewModel.getNews()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}