package com.example.cascer.footballapp.app

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.example.cascer.footballapp.app.injection.AppComponent
import com.example.cascer.footballapp.app.injection.DaggerAppComponent
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class App : Application(), HasActivityInjector, HasSupportFragmentInjector {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().app(this).build()
        appComponent.inject(this)

        Timber.plant(Timber.DebugTree())
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}