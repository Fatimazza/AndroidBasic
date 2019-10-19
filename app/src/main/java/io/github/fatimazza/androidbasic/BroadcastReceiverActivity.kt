package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_broadcast_receiver.*

class BroadcastReceiverActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        btn_br_sms_permission.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when {
            view.id == R.id.btn_br_sms_permission -> {
                
            }
        }
    }
}
