package com.foxhole.spacex.dataSource.room

import android.content.Context
import androidx.room.*
import com.foxhole.spacex.model.rocket.Rocket

/**
 * Created by Musfick Jamil on 4/30/2020$.
 */
@Database(entities = [Rocket::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketDao() : RocketDao

    companion object {
        private var appDatabase : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            if (appDatabase == null){
                appDatabase = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return appDatabase!!
        }
    }
}