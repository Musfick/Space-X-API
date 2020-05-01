package com.foxhole.spacex.di.rocketDetails

import com.foxhole.spacex.dataSource.room.RocketDao
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.ui.rocketDetails.RocketDetailsRepoImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
@Module
class RocketDetailsModule {

    @Provides
    @RocketDetailsScope
    fun providesRocketDetailsApi(retrofit: Retrofit) : RocketDetailsApi = retrofit.create(RocketDetailsApi::class.java)

    @Provides
    @RocketDetailsScope
    fun providesRocketDetailsRepo(rocketDetailsApi: RocketDetailsApi, rocketDao: RocketDao)
            : RocketDetailsRepoImpl = RocketDetailsRepoImpl(rocketDetailsApi, rocketDao)
}