package com.foxhole.spacex.di.rocketDetails

import com.foxhole.spacex.model.rocket.Rocket
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
interface RocketDetailsApi {

    @GET("rockets/{rocket_id}")
    suspend fun getOneRocket(@Path("rocket_id") rocketId : String) : Rocket
}