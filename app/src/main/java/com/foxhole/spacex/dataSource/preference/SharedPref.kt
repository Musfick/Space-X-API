package com.foxhole.spacex.dataSource.preference

import com.foxhole.spacex.model.rocket.Rocket

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */

interface SharedPref {

    fun isAlreadyCached() : Boolean
    fun saveToSharedPref(rocketList: MutableList<Rocket>)
    fun getDataFromSharedPref() : MutableList<Rocket>
}