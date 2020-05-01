package com.foxhole.spacex.di.rockets

import com.foxhole.spacex.di.ViewModelFactoryModule
import com.foxhole.spacex.ui.rockets.RocketsFragment
import dagger.Subcomponent

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
@RocketsScope
@Subcomponent(
    modules = [
    RocketsModule::class,
    ViewModelFactoryModule::class,
    RocketsViewModelModule::class
    ]
)
interface RocketsSubComponent {
    fun inject(rocketsFragment: RocketsFragment)
}