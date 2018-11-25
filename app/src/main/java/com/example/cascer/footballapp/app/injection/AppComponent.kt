package com.example.cascer.footballapp.app.injection

import com.example.cascer.footballapp.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, AndroidInjectionModule::class, AppModule::class,
        BuildersModule::class, NetModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}