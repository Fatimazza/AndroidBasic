package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

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
}

internal interface MyAsyncCallback {
    fun onPreExecute()
    fun onPostExecute(text: String)
}
