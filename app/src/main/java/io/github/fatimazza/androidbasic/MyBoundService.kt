package io.github.fatimazza.androidbasic

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log

class MyBoundService : Service() {

    companion object {
        private val TAG = MyBoundService::class.java.simpleName
    }

    private var myBinder = MyBinder()
    private val startTime = System.currentTimeMillis()

    private var timer: CountDownTimer = object : CountDownTimer(100000, 1000) {
        //countdown run till 100.000ms or 100 second, interval 1000ms or 1 second
        //used to count bound process of Bound Services to Activity
        override fun onTick(l: Long) {
            val elapsedTime = System.currentTimeMillis() - startTime
            Log.d(TAG, "onTick: $elapsedTime")
        }

        override fun onFinish() {

        }
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    internal inner class MyBinder : Binder() {
        val getService: MyBoundService = this@MyBoundService
    }

}
