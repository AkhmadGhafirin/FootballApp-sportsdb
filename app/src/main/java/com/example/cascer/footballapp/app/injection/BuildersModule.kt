package com.example.cascer.footballapp.app.injection

import com.example.cascer.footballapp.ui.detail.DetailMatchActivity
import com.example.cascer.footballapp.ui.match.last.LastMatchFragment
import com.example.cascer.footballapp.ui.match.next.NextMatchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    internal abstract fun lastMatchFragment(): LastMatchFragment

    @ContributesAndroidInjector
    internal abstract fun nextMatchFragment(): NextMatchFragment

    @ContributesAndroidInjector
    internal abstract fun detailMatchActivity(): DetailMatchActivity
}