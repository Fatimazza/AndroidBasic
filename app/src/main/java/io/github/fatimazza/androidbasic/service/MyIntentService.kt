package io.github.fatimazza.androidbasic.service

import android.app.IntentService
import android.content.Intent
import android.util.Log


class MyIntentService : IntentService("MyIntentService") {

    companion object {
        internal const val EXTRA_DURATION = "extra_duration"
        private val TAG = MyIntentService::class.java.simpleName
    }

    override fun onHandleIntent(intent: Intent?) {
        //run in separated Thread asynchronously, no need to create Background Thread
        Log.d(TAG, "onHandle Intent: Service is started")
        val duration = intent?.getLongExtra(EXTRA_DURATION, 0) as Long
        try {
            Thread.sleep(duration)
            //Intent Service is stopped by itself when the process is done
            Log.d(TAG, "onHandle Intent: Service is stopped")
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "on Destroy")
    }
}
