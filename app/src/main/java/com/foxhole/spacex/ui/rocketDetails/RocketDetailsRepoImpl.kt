package com.foxhole.spacex.ui.rocketDetails

import com.foxhole.spacex.dataSource.room.RocketDao
import com.foxhole.spacex.di.rocketDetails.RocketDetailsApi
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource
import com.foxhole.spacex.utils.ResponseHandler
import java.lang.Exception

/**
 * Created by Musfick Jamil on 5/1/2020$.
 */
class RocketDetailsRepoImpl(private val rocketDetailsApi: RocketDetailsApi, private val rocketDao: RocketDao) : RocketDetailsRepo {
    private val responseHandler = ResponseHandler()
    override suspend fun getOneRocket(rocketId: String): Resource<Rocket> {
        return try {
            responseHandler.handleSuccess(rocketDetailsApi.getOneRocket(rocketId))
        }catch (e : Exception){
            responseHandler.handleException(e)
        }
    }

    override suspend fun saveRocket(rocket: Rocket) {
        rocketDao.insert(rocket)
    }


}