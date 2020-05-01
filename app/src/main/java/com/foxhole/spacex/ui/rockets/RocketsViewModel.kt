package com.foxhole.spacex.ui.rockets

import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Musfick Jamil on 4/29/2020$.
 */
class RocketsViewModel @Inject constructor() : ViewModel() {

    init {
        println("viewModel : RocketsViewModel created...")
    }

    override fun onCleared() {
        super.onCleared()
        println("viewModel : RocketsViewModel destroy...")
    }
}