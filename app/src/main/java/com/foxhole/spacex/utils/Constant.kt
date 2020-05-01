package com.foxhole.spacex.utils

import java.net.InetAddress
import java.net.UnknownHostException

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */

const val PREF_NAME = "my_pref"
const val BASE_URL = "https://api.spacexdata.com/v3/"

const val ALREADY_CACHED = "already_cached"
const val ROCKET_LIST = "rocket_list_string"
const val FIRST_TIME_CACHED = "first_time_cached"

fun isInternetAvailable(): Boolean {
    return try {
        val address = InetAddress.getByName("www.google.com")
        !address.equals("")
    } catch (e: UnknownHostException) {
        // Log error
        false
    }
}
