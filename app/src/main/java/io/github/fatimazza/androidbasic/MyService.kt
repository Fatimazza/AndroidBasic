package io.github.fatimazza.androidbasic

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    companion object {
        //internal means that it'll be available in the SAME MODULE only
        internal val TAG = MyService::class.java.simpleName
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }

    //onStartCommand() used to start the Started Service
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "on Start Command: ")
        // START_STICKY tells the system to recreate the service after it has enough memory
        // and call onStartCommand() again with a null intent
        return START_STICKY
    }
}
