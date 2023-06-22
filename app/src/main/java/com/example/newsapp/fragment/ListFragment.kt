package com.example.newsapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.viewmodel.NewsViewModel
import com.example.newsapp.adapter.CategoryAdapter
import com.example.newsapp.adapter.MyCategoryItemClickListener
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.DataSource
import com.example.newsapp.databinding.FragmentListBinding
import com.example.newsapp.model.Article
import java.util.Locale

class ListFragment : Fragment(), MyCategoryItemClickListener {
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
        val categoryAdp = CategoryAdapter(dataSource.loadCategory(), this)
        binding.categoryRV.adapter = categoryAdp

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.news.observe(viewLifecycleOwner) { data ->
            Log.d("adfasl", "Data Changed $data")
            // News RecyclerView
            data.articles?.let {
//                The error is while iterating through the data.articles

//                val articles = mutableListOf<Article>()
//                articles.addAll(data.articles) // error right here
//                for(article in articles) {  // and here
//                    if (article.urlToImage==null)
//                        articles.remove(article)
//                }
                val newsAdp = NewsAdapter(data.articles)
                binding.newsRV.adapter = newsAdp
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCategoryItemClicked(category: String) {
        Log.d("adfasl", "$category ${category.lowercase()}")
        viewModel.getNewsByCategory(category.lowercase())
//        pass the new data to the adapter again but you shouldn't need to because you are observing it
    }
}