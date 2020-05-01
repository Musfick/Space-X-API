package com.foxhole.spacex

import android.app.Application
import com.foxhole.spacex.di.*

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger() = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .localModule(LocalModule())
        .networkModule(NetworkModule())
        .build()
}