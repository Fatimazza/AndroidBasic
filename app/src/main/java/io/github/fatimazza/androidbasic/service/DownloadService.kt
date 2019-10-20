package io.github.fatimazza.androidbasic.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import io.github.fatimazza.androidbasic.BroadcastReceiverActivity


class DownloadService : IntentService("DownloadService") {

    companion object {
        val TAG = DownloadService::class.java.simpleName
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "Download is running")
        if (intent != null) {
            try {
                Thread.sleep(5000)
                //download progress can be put here
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            //broadcast Event to Activity after download is finished
            //onReceive will be called
            val notifyDownloadFinishIntent =
                Intent(BroadcastReceiverActivity.ACTION_DOWNLOAD_STATUS)
            sendBroadcast(notifyDownloadFinishIntent)
        }
    }
}
