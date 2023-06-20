package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.adapter.CategoryAdapter
import com.example.newsapp.data.DataSource
import com.example.newsapp.databinding.FragmentListBinding
import com.example.newsapp.network.NewsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

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
        val categoryRV = binding.categoryRV
        val dataSource = DataSource()
        val categoryAdp = CategoryAdapter(dataSource.loadCategory())
        categoryAdp.setHasStableIds(true)
        categoryRV.adapter = categoryAdp

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}