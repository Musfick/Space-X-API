package com.foxhole.spacex.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.foxhole.spacex.dataSource.preference.SharedPrefImpl
import com.foxhole.spacex.dataSource.room.AppDatabase
import com.foxhole.spacex.dataSource.room.RocketDao
import com.foxhole.spacex.utils.PREF_NAME
import dagger.Module
import dagger.Provides

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */

@Module
class LocalModule() {


    @Provides
    @AppScope
    fun providesSharedPref(context: Context) : SharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    @Provides
    @AppScope
    fun providesAppSharedPref(preferences: SharedPreferences) : SharedPrefImpl =
        SharedPrefImpl(preferences)

    @Provides
    @AppScope
    fun providesAppDatabase(context: Context) : AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @AppScope
    fun provideRocketDao(appDatabase: AppDatabase) : RocketDao = appDatabase.rocketDao()
}