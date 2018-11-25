package com.example.cascer.footballapp.app.injection

import com.example.cascer.footballapp.ui.main.match.detail.DetailMatchActivity
import com.example.cascer.footballapp.ui.main.favorite.FavoriteFragment
import com.example.cascer.footballapp.ui.main.match.last.LastMatchFragment
import com.example.cascer.footballapp.ui.main.match.next.NextMatchFragment
import com.example.cascer.footballapp.ui.main.team.TeamFragment
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
    internal abstract fun favoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    internal abstract fun teamFragment(): TeamFragment

    @ContributesAndroidInjector
    internal abstract fun detailMatchActivity(): DetailMatchActivity
}