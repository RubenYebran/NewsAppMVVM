package com.example.newsappmvvm.data.model

import com.google.gson.annotations.SerializedName

class Article(
    @SerializedName("author")
    val author: Any,
    @SerializedName("content")
    val content: Any,
    @SerializedName("description")
    val description: Any,
    @SerializedName("publishedAt")
    var publishedAt: String = "",
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: Any
)