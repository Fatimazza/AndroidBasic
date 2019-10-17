package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    private class DemoAsync(val listener: MyAsyncCallback) {
        companion object {
            private val LOG_ASYNC = "Demo Async"
        }

        //using WeakReference to avoid Memory Leak in AsyncTask
        private val myListener: WeakReference<MyAsyncCallback> = WeakReference(listener)
    }
}

internal interface MyAsyncCallback {
    fun onPreExecute()
    fun onPostExecute(text: String)
}
