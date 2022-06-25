package com.lvc.lookingup.repository

import com.lvc.lookingup.repository.api.NewsAPI

class NewsRepository(
    private val newsAPI: NewsAPI
) {

    suspend fun getNews() =  newsAPI.getNews("sports")

}