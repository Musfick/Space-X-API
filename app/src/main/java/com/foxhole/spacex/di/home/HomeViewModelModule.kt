package com.foxhole.spacex.di.home

import androidx.lifecycle.ViewModel
import com.foxhole.spacex.factory.ViewModelKey
import com.foxhole.spacex.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    @HomeScope
    internal abstract fun providesHomeViewModel(homeViewModel: HomeViewModel) : ViewModel
}