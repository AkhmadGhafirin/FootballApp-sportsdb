package com.example.cascer.footballapp.app.injection

import android.content.Context
import com.example.cascer.footballapp.app.App
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Context = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}