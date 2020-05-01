package com.foxhole.spacex.ui.rocketDetails

import androidx.lifecycle.*
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
class RocketDetailsViewModel @Inject constructor(private val rocketDetailsRepoImpl: RocketDetailsRepoImpl) : ViewModel() {

    private val _oneRocket = MutableLiveData<String>()

    fun setRocketId(value : String){
        if (_oneRocket.value == null){
            _oneRocket.value = value
        }
    }

    init {
        println("details_debug : RocketDetailsViewModel created...")
    }

    override fun onCleared() {
        super.onCleared()
        println("details_debug : RocketDetailsViewModel destroy...")
    }

    val oneRocket = _oneRocket.switchMap {rocketId ->
        liveData {
            emit(Resource.loading(null))
            emit(rocketDetailsRepoImpl.getOneRocket(rocketId))
        }
    }

    fun saveRocket(rocket: Rocket){
        viewModelScope.launch(Dispatchers.IO) {
            rocketDetailsRepoImpl.saveRocket(rocket)
        }
    }
}