package io.github.fatimazza.androidbasic

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import io.github.fatimazza.androidbasic.utils.PermisionManager
import kotlinx.android.synthetic.main.activity_broadcast_receiver.*

class BroadcastReceiverActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val SMS_REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        btn_br_sms_permission.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when {
            view.id == R.id.btn_br_sms_permission -> {
                PermisionManager.check(this, Manifest.permission.RECEIVE_SMS, SMS_REQUEST_CODE)
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
}
