package com.lvc.lookingup.di

import com.lvc.lookingup.repository.NewsRepository
import com.lvc.lookingup.repository.api.APIFactory
import com.lvc.lookingup.ui.listofnews.ListOfNewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    factory { APIFactory.newsAPI }
    factory { NewsRepository(get()) }
}

val viewModelModule = module {
    viewModel { ListOfNewsViewModel(get()) }
}