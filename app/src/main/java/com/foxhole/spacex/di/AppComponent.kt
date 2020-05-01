package com.foxhole.spacex.di

import com.foxhole.spacex.di.home.HomeSubComponent
import com.foxhole.spacex.di.rocketDetails.RocketDetailsSubComponent
import com.foxhole.spacex.di.rockets.RocketsSubComponent
import dagger.Component

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
@AppScope
@Component(
    modules = [
    AppModule::class,
    LocalModule::class,
    NetworkModule::class
    ]
)
interface AppComponent {

    fun newHomeSubComponent() : HomeSubComponent
    fun newRocketDetailsSubComponent() : RocketDetailsSubComponent
    fun newRocketsSubComponent() : RocketsSubComponent
}