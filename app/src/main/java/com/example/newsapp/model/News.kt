package com.example.newsapp.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class News(
    val status: String?,
    val articles: List<Article>?,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Article(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val content: String?
)
