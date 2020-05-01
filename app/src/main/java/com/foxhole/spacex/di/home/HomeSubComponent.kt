package com.foxhole.spacex.di.home

import com.foxhole.spacex.di.ViewModelFactoryModule
import com.foxhole.spacex.ui.home.HomeFragment
import dagger.Subcomponent

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */

@HomeScope
@Subcomponent(
    modules = [
    HomeModule::class,
    ViewModelFactoryModule::class,
    HomeViewModelModule::class
    ]
)
interface HomeSubComponent {

    fun inject(homeFragment: HomeFragment)
}