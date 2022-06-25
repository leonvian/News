package com.lvc.lookingup.repository.api

import com.lvc.lookingup.model.News
import com.lvc.lookingup.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

private const val API_KEY = "843ff35c323d4878ac20b9e402216a08"

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("q") query: String,
        @Header("X-Api-Key") apikey: String = API_KEY
    ): Response<NewsResponse>

}