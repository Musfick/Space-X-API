package com.foxhole.spacex.ui.home

import com.foxhole.spacex.dataSource.preference.SharedPrefImpl
import com.foxhole.spacex.di.home.HomeApi
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource
import com.foxhole.spacex.utils.ResponseHandler
import java.lang.Exception

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
class HomeRepoImpl(private val homeApi: HomeApi, private val preferences: SharedPrefImpl) :
    HomeRepo {

    private val responseHandler = ResponseHandler()
    override fun isAlreadyCached(): Boolean = preferences.isAlreadyCached()


    override suspend fun getRocketsDataFromNetwork(): Resource<MutableList<Rocket>> {
        //get data from network
        println("preference : data is not cached...")
        return try {
            println("preference : data is getting from network...")
            val response = homeApi.getAllRocket()
            responseHandler.handleSuccess(response).apply {
                println("preference : save data to cache...")
                preferences.saveToSharedPref(response)
            }

        }catch (e : Exception){
            responseHandler.handleException(e)
        }
    }

    override suspend fun getRocketsDataFromCached(): Resource<MutableList<Rocket>> {
        println("preference : get cached data...")
        val list = preferences.getDataFromSharedPref()
        return responseHandler.handleSuccess(list)
    }

    override suspend fun getFreshRockets(): Resource<MutableList<Rocket>> {
        return try {
            println("preference : refresh data from network...")
            val response = homeApi.getAllRocket()
            responseHandler.handleRefreshed(response).apply {
                preferences.saveToSharedPref(response)
            }

        }catch (e : Exception){
            getRocketsDataFromCached()
        }
    }


}