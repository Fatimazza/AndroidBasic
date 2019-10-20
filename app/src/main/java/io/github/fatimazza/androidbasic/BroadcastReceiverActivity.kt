package io.github.fatimazza.androidbasic

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import io.github.fatimazza.androidbasic.service.DownloadService
import io.github.fatimazza.androidbasic.utils.PermisionManager
import kotlinx.android.synthetic.main.activity_broadcast_receiver.*

class BroadcastReceiverActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val ACTION_DOWNLOAD_STATUS = "download_status"
        private const val SMS_REQUEST_CODE = 101
    }

    private lateinit var downloadReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        btn_br_sms_permission.setOnClickListener(this)
        btn_br_download_file.setOnClickListener(this)

        createDownloadReceiver()
    }

    private fun createDownloadReceiver() {
        downloadReceiver = object : BroadcastReceiver() {
            //onReceive called when Download Service broadcast Event to Activity
            override fun onReceive(context: Context, intent: Intent) {
                Log.d(DownloadService.TAG, "Download is finished")
                Toast.makeText(context, "Download is finished", Toast.LENGTH_SHORT).show()
            }
        }
        val downloadIntentFilter = IntentFilter(ACTION_DOWNLOAD_STATUS)
        registerReceiver(downloadReceiver, downloadIntentFilter)
    }

    override fun onClick(view: View) {
        when {
            view.id == R.id.btn_br_sms_permission -> {
                PermisionManager.check(this, Manifest.permission.RECEIVE_SMS, SMS_REQUEST_CODE)
            }
            view.id == R.id.btn_br_download_file -> {
                val downloadServiceIntent = Intent(this, DownloadService::class.java)
                startService(downloadServiceIntent)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == SMS_REQUEST_CODE) {
            when {
                grantResults[0] == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "SMS Permission Granted", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "SMS Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(downloadReceiver)
    }
}
