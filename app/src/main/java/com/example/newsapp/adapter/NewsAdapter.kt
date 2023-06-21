package com.example.newsapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.model.Article

class NewsAdapter(private val myDataset: List<Article>) : Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(private val binding: NewsItemBinding) : ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.titleTV.text = article.title
            binding.descriptionTV.text = article.description
            binding.article = article
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val data = myDataset[position]
        val urlToImage = data.urlToImage
        if(urlToImage!=null)
        holder.bind(myDataset[position])
        else Log.d("adfasl", "Url of image was null here")
    }
}