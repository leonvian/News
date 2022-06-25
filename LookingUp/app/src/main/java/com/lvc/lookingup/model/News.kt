package com.lvc.lookingup.model

data class News(
    val source: Source,
    val title: String,
    val author: String,
    val description: String,
    val url: String = "",
    val urlToImage: String = "",
    val publishedAt: String = "",
    val content: String = ""
)