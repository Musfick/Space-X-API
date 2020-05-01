package com.foxhole.spacex.ui.rocketDetails

import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
class RocketDetailsViewModel @Inject constructor() : ViewModel() {

    init {
        println("viewModel : RocketDetailsViewModel created...")
    }

    override fun onCleared() {
        super.onCleared()
        println("viewModel : RocketDetailsViewModel destroy...")
    }
}