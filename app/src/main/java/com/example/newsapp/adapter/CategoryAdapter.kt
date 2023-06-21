package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.databinding.CategoryItemBinding
import com.example.newsapp.model.Category

class CategoryAdapter(private val myDataset: List<Category>, private val listener: MyCategoryItemClickListener) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(private val binding: CategoryItemBinding) : ViewHolder(binding.root) {
        fun bind(category: Category, listener: MyCategoryItemClickListener) {
            binding.catIV.setImageResource(category.image)
            binding.catTV.text = category.categoryTxt

            binding.root.setOnClickListener {
                listener.onCategoryItemClicked(category.categoryTxt)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryViewHolder {
        return CategoryViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = myDataset[position]
        holder.bind(item, listener)
    }
}

// Interface -- For defining a `Click Action Event` on our Category Item
interface MyCategoryItemClickListener {
    fun onCategoryItemClicked(category: String)
}