package com.foxhole.spacex.di.home

import com.foxhole.spacex.adapter.RocketRecyclerAdapter
import com.foxhole.spacex.dataSource.preference.SharedPrefImpl
import com.foxhole.spacex.ui.home.HomeRepoImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
@Module
class HomeModule {

    @Provides
    @HomeScope
    fun providesHomeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @Provides
    @HomeScope
    fun providesHomeRepo(homeApi: HomeApi, pref: SharedPrefImpl) : HomeRepoImpl =
        HomeRepoImpl(homeApi, pref)

    @Provides
    @HomeScope
    fun providesRocketRecyclerAdapter() : RocketRecyclerAdapter = RocketRecyclerAdapter()
}