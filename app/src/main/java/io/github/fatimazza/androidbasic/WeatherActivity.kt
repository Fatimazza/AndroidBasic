package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fatimazza.androidbasic.adapter.WeatherAdapter
import io.github.fatimazza.androidbasic.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {

    private lateinit var adapter: WeatherAdapter
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        showListWeather()
        initViewModel()
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

    private fun showLoading(state: Boolean) {
        if (state) {
            pbLoadingWeather.visibility = View.VISIBLE
        } else {
            pbLoadingWeather.visibility = View.GONE
        }
    }
}
