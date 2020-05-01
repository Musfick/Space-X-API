package com.foxhole.spacex.dataSource.preference

import android.content.SharedPreferences
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.ALREADY_CACHED
import com.foxhole.spacex.utils.FIRST_TIME_CACHED
import com.foxhole.spacex.utils.ROCKET_LIST
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.InetAddress
import java.net.UnknownHostException

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */

class SharedPrefImpl(private val pref: SharedPreferences) : SharedPref {

    override fun isAlreadyCached(): Boolean = pref.getBoolean(ALREADY_CACHED, false)


    override fun saveToSharedPref(rocketList: MutableList<Rocket>) {
        pref.edit().remove(ROCKET_LIST).apply().apply {
            val rawString = Gson().toJson(rocketList)
            rawString?.let {
                pref.edit().putString(ROCKET_LIST, it).apply()
                pref.edit().putBoolean(ALREADY_CACHED, true).apply()
                println("preference : Data is saved..")
            }
        }
    }

    override fun getDataFromSharedPref(): MutableList<Rocket> {
        val rawString = pref.getString(ROCKET_LIST, null)
        val type = object: TypeToken<MutableList<Rocket>>() {}.type
        println("preference : Getting data from sharedPref..")
        return Gson().fromJson(rawString, type)

    }




}