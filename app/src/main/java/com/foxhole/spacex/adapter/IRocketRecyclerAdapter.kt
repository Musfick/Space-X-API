package com.foxhole.spacex.adapter

import com.foxhole.spacex.model.rocket.Rocket

/**
 * Created by Musfick Jamil on 4/30/2020$.
 */
interface IRocketRecyclerAdapter {
    fun onItemClick(rocket : Rocket)
}