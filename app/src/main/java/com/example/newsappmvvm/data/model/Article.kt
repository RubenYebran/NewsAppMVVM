package com.example.newsappmvvm.data.model

data class Article(
    val author: Any,
    val content: Any,
    val description: Any,
    val publishedAt: String = "",
    val source: Source,
    val title: String = "",
    val url: String = "",
    val urlToImage: Any
)

data class NewsList(val articles: List<Article> = listOf())