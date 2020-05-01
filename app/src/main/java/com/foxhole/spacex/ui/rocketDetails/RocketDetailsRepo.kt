package com.foxhole.spacex.ui.rocketDetails

import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource

/**
 * Created by Musfick Jamil on 5/1/2020$.
 */
interface RocketDetailsRepo {
    suspend fun getOneRocket(rocketId : String) : Resource<Rocket>
    suspend fun saveRocket(rocket: Rocket)
}