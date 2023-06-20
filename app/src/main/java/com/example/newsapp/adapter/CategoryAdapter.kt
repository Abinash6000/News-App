package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.R
import com.example.newsapp.model.Category

class CategoryAdapter(private val myDataset: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {
        private val catIV: ImageView = itemView.findViewById(R.id.catIV)
        private val catTV: TextView = itemView.findViewById(R.id.catTV)
        fun bind(category: Category) {
            catIV.setImageResource(category.image)
            catTV.text = category.categoryTxt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = myDataset[position]
        holder.bind(item)
    }
}