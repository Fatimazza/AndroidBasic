package io.github.fatimazza.androidbasic.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import io.github.fatimazza.androidbasic.BuildConfig
import io.github.fatimazza.androidbasic.model.Weather
import org.json.JSONObject
import java.text.DecimalFormat

class WeatherViewModel : ViewModel() {

    companion object {
        private const val API_KEY = BuildConfig.API_KEY
    }

    private val listWeathers = MutableLiveData<ArrayList<Weather>>()

    internal fun setWeather(city: String) {
        val client = AsyncHttpClient()
        val listItems = ArrayList<Weather>()
        val url =
            "https://api.openweathermap.org/data/2.5/group?id=$city&units=metric&appid=$API_KEY"

        //request API asynchronously
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                try {
                    //get data list JSON Array
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val list = responseObject.getJSONArray("list")

                    //convert JSON Object to readable data
                    //data in JSON Object is read by its KEY, exp. id, name
                    for (i in 0 until list.length()) {
                        val weather = list.getJSONObject(i)
                        val weatherItem = Weather()
                        weatherItem.id = weather.getInt("id")
                        weatherItem.name = weather.getString("name")
                        weatherItem.currentWeather =
                            weather.getJSONArray("weather").getJSONObject(0).getString("main")
                        weatherItem.description =
                            weather.getJSONArray("weather").getJSONObject(0)
                                .getString("description")

                        val tempInKelvin = weather.getJSONObject("main").getDouble("temp")
                        val tempInCelcius = tempInKelvin - 273
                        weatherItem.temperature = DecimalFormat("##.##").format(tempInCelcius)
                        listItems.add(weatherItem)
                    }
                    //post realtime latest value from Background Thread
                    listWeathers.postValue(listItems)

                } catch (e: Exception) {
                    Log.d("Exception", e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                Log.d("onFailure", error.message.toString())
            }
        })
    }

    internal fun getWeather(): LiveData<ArrayList<Weather>> {
        return listWeathers
    }

}
