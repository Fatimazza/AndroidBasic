package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fatimazza.androidbasic.adapter.WeatherAdapter
import io.github.fatimazza.androidbasic.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adapter: WeatherAdapter
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        showListWeather()
        initViewModel()
        btnWeatherSearch.setOnClickListener(this)
        fetchWeatherData()
    }

    private fun showListWeather() {
        adapter = WeatherAdapter()
        adapter.notifyDataSetChanged()

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.adapter = adapter
    }

    private fun initViewModel() {
        weatherViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(WeatherViewModel::class.java)
    }


    override fun onClick(view: View) {
        if (view.id == R.id.btnWeatherSearch) {
            val city = etCityWeather.text.toString()
            if (city.isEmpty()) {
                return
            }

            weatherViewModel.setWeather(city)
            showLoading(true)
        }
    }

    private fun fetchWeatherData() {
        //get value from View Model's Live Data
        weatherViewModel.getWeather().observe(this, Observer { weatherItem ->
            if (weatherItem != null) {
                adapter.setData(weatherItem)
                showLoading(false)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            pbLoadingWeather.visibility = View.VISIBLE
        } else {
            pbLoadingWeather.visibility = View.GONE
        }
    }
}
