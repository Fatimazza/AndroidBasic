package io.github.fatimazza.androidbasic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.fatimazza.androidbasic.R
import io.github.fatimazza.androidbasic.model.Weather
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private val weatherData = ArrayList<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(mView)
    }

    override fun getItemCount(): Int = weatherData.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherData[position])
    }

    fun setData(weatherItems: ArrayList<Weather>) {
        weatherData.clear()
        weatherData.addAll(weatherItems)
        notifyDataSetChanged()
    }

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weatherItem: Weather) {
            with(itemView) {
                tvWeatherCity.text = weatherItem.name
                tvWeatherTemp.text = weatherItem.temperature
                tvWeatherDesc.text = weatherItem.description
            }
        }
    }
}
