package com.lvc.lookingup.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<News>
)