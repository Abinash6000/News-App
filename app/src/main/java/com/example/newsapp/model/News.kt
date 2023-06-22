package com.example.newsapp.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class News(
    val status: String?,
    val articles: List<Article>?,
)


