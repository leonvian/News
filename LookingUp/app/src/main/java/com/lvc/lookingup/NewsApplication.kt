package com.lvc.lookingup

import android.app.Application
import com.lvc.lookingup.di.repositoryModule
import com.lvc.lookingup.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NewsApplication)
            modules(listOf(repositoryModule, viewModelModule))
        }
    }


}