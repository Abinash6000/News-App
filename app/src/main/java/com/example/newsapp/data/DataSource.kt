package com.example.newsapp.data

import com.example.newsapp.R
import com.example.newsapp.model.Category

class DataSource {
    fun loadCategory(): List<Category> {
        return listOf(
            Category(R.drawable.sports, "Sports"),
            Category(R.drawable.general, "General"),
            Category(R.drawable.business, "Business"),
            Category(R.drawable.health, "Health"),
            Category(R.drawable.entertainment, "Entertainment"),
            Category(R.drawable.science, "Science"),
            Category(R.drawable.technology, "Technology")
            )
    }
}