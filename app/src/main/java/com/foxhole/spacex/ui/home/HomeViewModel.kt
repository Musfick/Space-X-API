package com.foxhole.spacex.ui.home

import androidx.lifecycle.*
import com.foxhole.spacex.model.rocket.Rocket
import com.foxhole.spacex.utils.Resource
import com.foxhole.spacex.utils.isInternetAvailable
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Musfick Jamil on 4/28/2020$.
 */
class HomeViewModel @Inject constructor(private val mainRepo: HomeRepoImpl) : ViewModel(){

    private val _rockets  = MutableLiveData<Resource<MutableList<Rocket>>>()

    val rockets
        get() = _rockets

    init {
        getAllRockets()
        println("home_debug : HomeViewModel created...")
    }

    private fun getAllRockets() {
        viewModelScope.launch(IO) {

            if (!mainRepo.isAlreadyCached()){
                println("home_debug : is already cached false")
                withContext(Main){
                    _rockets.value = Resource.loading(null)
                }
                _rockets.postValue(mainRepo.getRocketsDataFromNetwork())
            }else{
                println("home_debug : is already cached and refresh data if internet available")
                _rockets.postValue(mainRepo.getRocketsDataFromCached())
                if (isInternetAvailable()){
                    delay(3000)
                    withContext(Main){
                        _rockets.value = Resource.refreshing(null)
                    }
                    delay(3000)
                    _rockets.postValue(mainRepo.getFreshRockets())
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("home_debug : HomeViewModel cleared...")
    }

}