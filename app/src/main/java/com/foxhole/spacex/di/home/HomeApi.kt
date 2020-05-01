package com.foxhole.spacex.di.home

import com.foxhole.spacex.model.rocket.Rocket
import retrofit2.http.GET

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
interface HomeApi {

    @GET("rockets/")
    suspend fun getAllRocket() : MutableList<Rocket>
}