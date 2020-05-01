package com.foxhole.spacex.dataSource.room

import androidx.room.TypeConverter
import com.foxhole.spacex.model.rocket.Height
import com.foxhole.spacex.model.rocket.Mass
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken




/**
 * Created by Musfick Jamil on 4/30/2020$.
 */
class Converters {

    @TypeConverter
    fun restoreList(listOfString: String?): List<String?>? {
        return Gson().fromJson(
            listOfString,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun saveList(listOfString: List<String?>?): String? {
        return Gson().toJson(listOfString)
    }

    @TypeConverter
    fun fromHeight(height: Height) : Double {
        return height.meters
    }

    @TypeConverter
    fun toHeight(height : Double) : Height {
        return Height(height)
    }

    @TypeConverter
    fun fromMass(mass : Mass) : Int {
        return mass.kg
    }

    @TypeConverter
    fun toMass(mass : Int) : Mass {
        return Mass(mass)
    }
}