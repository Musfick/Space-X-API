package com.foxhole.spacex.di

import androidx.lifecycle.ViewModelProvider
import com.foxhole.spacex.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}