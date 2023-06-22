package com.example.newsapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.model.Article

class NewsAdapter(private val myDataset: List<Article>, private val listener: MyNewsItemClickListener) : Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(private val binding: NewsItemBinding) : ViewHolder(binding.root) {
        fun bind(article: Article, listener: MyNewsItemClickListener) {
            binding.titleTV.text = article.title
            binding.descriptionTV.text = article.description
            binding.article = article

            binding.root.setOnClickListener {
                listener.onNewsItemClicked(article)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
//        val data = myDataset[position]
//        val urlToImage = data.urlToImage
//        if(urlToImage!=null)
        holder.bind(myDataset[position], listener)
//        else Log.d("adfasl", "Url of image was null here")
    }
}

interface MyNewsItemClickListener {
    fun onNewsItemClicked(article: Article)
}