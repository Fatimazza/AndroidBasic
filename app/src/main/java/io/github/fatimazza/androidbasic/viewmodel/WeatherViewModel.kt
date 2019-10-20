package io.github.fatimazza.androidbasic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.fatimazza.androidbasic.model.Weather

class WeatherViewModel : ViewModel() {

    private val listWeathers = MutableLiveData<ArrayList<Weather>>()

    internal fun setWeather(city: String) {

    }

    internal fun getWeather(): LiveData<ArrayList<Weather>> {
        return listWeathers
    }

}
