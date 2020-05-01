package com.foxhole.spacex.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    @AppScope
    fun providesApplication(): Application = application

    @Provides
    @AppScope
    fun providesApplicationContext(): Context = application
}