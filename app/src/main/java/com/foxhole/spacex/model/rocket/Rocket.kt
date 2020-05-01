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
    val firstFlight: String? = null
    @Ignore
    val active : Boolean? = null
    @Ignore
    val stage : Int? = null
    @Ignore
    val boosters: Int? = null
    @SerializedName("success_rate_pct")
    @Ignore
    val successRate : Int? = null
    @Ignore
    val country : String? = null
    @Ignore
    val company : String? = null
    @Ignore
    val wikipedia : String? = null
    @Ignore
    val description : String? = null
}