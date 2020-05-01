package com.foxhole.spacex.model.rocket


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "rocket_table")
data class Rocket(
    //properties need for save to room
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int,
    val id: Int,
    @SerializedName("flickr_images")
    val flickrImages: List<String>,
    val height: Height,
    val mass: Mass


){
    //primary key
    @PrimaryKey(autoGenerate = true)
    var uid : Int? = 0

    //properties need for details section not for room
    @SerializedName("rocket_id")
    @Ignore
    val rocketId: String = ""
    @SerializedName("first_flight")
    @Ignore
    val firstFlight: String = ""
    @Ignore
    val active : Boolean = true
    @Ignore
    val stage : Int = 0
    @Ignore
    val boosters: Int = 0
    @SerializedName("success_rate_pct")
    @Ignore
    val successRate : Int = 0
    @Ignore
    val country : String = ""
    @Ignore
    val company : String = ""
    @Ignore
    val wikipedia : String = ""
    @Ignore
    val description : String = ""
}