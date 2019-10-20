package io.github.fatimazza.androidbasic.service

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

    //called first
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    //called after onCreate
    override fun onBind(intent: Intent): IBinder {
        //run in UI Thread
        Log.d(TAG, "onBind: ")
        //countdown timer is starting
        timer.start()
        //the Service is running, bound to Activity which call it
        return myBinder
    }

    //called after onUnbind
    override fun onDestroy() {
        super.onDestroy()
        //deleting Bound Service class from memory
        Log.d(TAG, "onDestroy: ")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        timer.cancel()
        //unbind Service from its Activity
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind: ")
    }

    internal inner class MyBinder : Binder() {
        //call and bind Service class
        val getService: MyBoundService = this@MyBoundService
    }

}
