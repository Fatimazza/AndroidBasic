package io.github.fatimazza.androidbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fatimazza.androidbasic.adapter.WeatherAdapter
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {

    private lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        showListWeather()
    }

    private fun showListWeather() {
        adapter = WeatherAdapter()
        adapter.notifyDataSetChanged()

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.adapter = adapter
    }
}
