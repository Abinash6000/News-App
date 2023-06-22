package com.example.newsapp.model
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.parcelize.Parcelize


@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class Article(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val content: String?
) : Parcelable
