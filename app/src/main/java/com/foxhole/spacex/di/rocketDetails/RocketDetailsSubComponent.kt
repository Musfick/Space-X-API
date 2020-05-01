package com.foxhole.spacex.di.rocketDetails

import com.foxhole.spacex.di.ViewModelFactoryModule
import com.foxhole.spacex.ui.rocketDetails.RocketDetailsFragment
import dagger.Subcomponent

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
@RocketDetailsScope
@Subcomponent(
    modules = [
        RocketDetailsModule::class,
        ViewModelFactoryModule::class,
        RocketDetailsViewModelModule::class
    ]
)
interface RocketDetailsSubComponent {
    fun inject(rocketDetailsFragment: RocketDetailsFragment)
}