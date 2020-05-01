package com.foxhole.spacex.di.rocketDetails

import androidx.lifecycle.ViewModel
import com.foxhole.spacex.factory.ViewModelKey
import com.foxhole.spacex.ui.rocketDetails.RocketDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
@Module
abstract class RocketDetailsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RocketDetailsViewModel::class)
    @RocketDetailsScope
    internal abstract fun bindRocketDetailsViewModel(rocketDetailsViewModel: RocketDetailsViewModel) : ViewModel
}