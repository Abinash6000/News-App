package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.R
import com.example.newsapp.databinding.CategoryItemBinding
import com.example.newsapp.model.Category

class CategoryAdapter(private val myDataset: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(private val binding: CategoryItemBinding) : ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.catIV.setImageResource(category.image)
            binding.catTV.text = category.categoryTxt
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = myDataset[position]
        holder.bind(item)
    }
}