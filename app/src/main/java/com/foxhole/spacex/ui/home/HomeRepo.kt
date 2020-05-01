package com.foxhole.spacex.ui.home

import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
interface HomeRepo {

    fun isAlreadyCached() : Boolean
    suspend fun getRocketsDataFromNetwork() : Resource<MutableList<Rocket>>
    suspend fun getRocketsDataFromCached() : Resource<MutableList<Rocket>>
    suspend fun getFreshRockets() : Resource<MutableList<Rocket>>
}