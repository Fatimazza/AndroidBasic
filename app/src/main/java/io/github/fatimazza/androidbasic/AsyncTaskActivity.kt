package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_async_task.*
import kotlinx.coroutines.*

class AsyncTaskActivity : AppCompatActivity() {

    companion object {
        private val LOG_ASYNC = "Demo Async Main"
        private const val INPUT_STRING = "Halo, this is AsyncTask demo!"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        Log.d(LOG_ASYNC, "status: onPreExecute - Main")
        tv_async_status.text = resources.getString(R.string.async_status_pre)
        tv_async_desc.text = INPUT_STRING

        GlobalScope.launch(Dispatchers.IO) {
            //background thread
            Log.d(LOG_ASYNC, "status: doInBackground")
            val input = INPUT_STRING
            var output: String? = null
            try {
                output = "$input ... Done! Selamat Belajar!"
                delay(2000)

                //move to Main Thread to update UI
                withContext(Dispatchers.Main) {
                    Log.d(LOG_ASYNC, "status: onPostExecute - Main")
                    tv_async_status.text = resources.getString(R.string.async_status_post)
                    tv_async_desc.text = output
                }
            } catch (e: Exception) {
                Log.d(LOG_ASYNC, e.message)
            }
        }
    }
}

