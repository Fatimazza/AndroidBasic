package io.github.fatimazza.androidbasic

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.lang.ref.WeakReference

class AsyncTaskActivity : AppCompatActivity(), MyAsyncCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
    }

    override fun onPreExecute() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPostExecute(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private class DemoAsync(val listener: MyAsyncCallback) : AsyncTask<String, Void, String>() {

        companion object {
            private val LOG_ASYNC = "Demo Async"
        }

        //using WeakReference to avoid Memory Leak in AsyncTask
        private val myListener: WeakReference<MyAsyncCallback> = WeakReference(listener)

        override fun onPreExecute() {
            super.onPreExecute()
            Log.d(LOG_ASYNC, "status: onPreExecute")

            val myListener = myListener.get()
            myListener?.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String {
            Log.d(LOG_ASYNC, "status: doInBackground")

            var output: String? = null
            try {
                val input = params[0]
                output = "$input progress Belajar"
                Thread.sleep(2000)
            } catch (e: Exception) {
                Log.d(LOG_ASYNC, e.message)
            }
            return output.toString()
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            Log.d(LOG_ASYNC, "status: onPostExecute")

            val myListener = myListener.get()
            myListener?.onPostExecute(result)
        }
    }
}

internal interface MyAsyncCallback {
    fun onPreExecute()
    fun onPostExecute(text: String)
}
