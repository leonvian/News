package com.lvc.lookingup.ui.listofnews

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lvc.lookingup.model.News
import com.lvc.lookingup.model.Source
import com.lvc.lookingup.repository.NewsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListOfNewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _newsLiveData = MutableLiveData<List<News>>(emptyList())
    val newsLiveData: LiveData<List<News>> = _newsLiveData

    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getNews() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = newsRepository.getNews()
            if (response.isSuccessful) {
                response.body()?.also {
                    Log.i("NEWS_EVENT", "Articles Status ${it.status}  results ${it.totalResults}  Articles -> ${it.articles}")
                    _newsLiveData.postValue(it.articles)
                }
            } else {
                //val errorBody = response.errorBody()?.string().orEmpty()
                onError("Error : ${response.message()} ")
            }
        }
    }

    private fun onError(message: String) {
        Log.i("NEWS_EVENT", "Error message: $message")
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}