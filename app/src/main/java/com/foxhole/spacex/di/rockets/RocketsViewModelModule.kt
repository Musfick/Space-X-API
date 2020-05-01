package com.foxhole.spacex.di.rockets

import androidx.lifecycle.ViewModel
import com.foxhole.spacex.factory.ViewModelKey
import com.foxhole.spacex.ui.rockets.RocketsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
@Module
abstract class RocketsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RocketsViewModel::class)
    @RocketsScope
    internal abstract fun bindRocketsViewModel(rocketsViewModel: RocketsViewModel) : ViewModel
}