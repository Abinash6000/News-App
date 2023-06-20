package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.R
import com.example.newsapp.model.Article

class NewsAdapter(private val myDataset: List<Article>) : Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView: View) : ViewHolder(itemView) {
        val newsIV: ImageView = itemView.findViewById(R.id.newsIV)
        private val titleTV: TextView = itemView.findViewById(R.id.titleTV)
        private val descriptionTV: TextView = itemView.findViewById(R.id.descriptionTV)
        fun bind(article: Article) {
            if(article.title!=null)
                titleTV.text = article.title
            if(article.description!=null)
                descriptionTV.text = article.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(adapterLayout)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = myDataset[position]
        holder.bind(item)
    }
}