package com.lvc.lookingup.repository.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//843ff35c323d4878ac20b9e402216a08

/*
GET https://newsapi.org/v2/everything?q=Apple&from=2022-06-05&sortBy=popularity&apiKey=API_KEY

curl https://newsapi.org/v2/everything -G \
    -d q=Apple \
    -d from=2022-06-05 \
    -d sortBy=popularity \
    -d apiKey=843ff35c323d4878ac20b9e402216a08
 */
object APIFactory {

    private const val BASE_URL = "https://newsapi.org/v2/"

    private fun getRetrofit(): Retrofit {
        val interceptor =  HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        val client =  OkHttpClient.Builder().addInterceptor(interceptor).build();

       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val newsAPI: NewsAPI = getRetrofit().create(NewsAPI::class.java)

}