package io.github.fatimazza.androidbasic

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity(), View.OnClickListener {

    private var serviceBound = false
    private lateinit var boundService: MyBoundService

    //Listener to receive callbacks from Service Connection
    private val serviceConnection = object : ServiceConnection {
        //Callback when connected to Service
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        //Callback when disconnected from Service
        override fun onServiceDisconnected(name: ComponentName) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btn_start_service.setOnClickListener(this)
        btn_start_intent_service.setOnClickListener(this)
        btn_start_bound_service.setOnClickListener(this)
        btn_stop_bound_service.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_start_service -> {
                val startServiceIntent = Intent(this, MyService::class.java)
                startService(startServiceIntent)
            }
            R.id.btn_start_intent_service -> {
                val startIntentService = Intent(this, MyIntentService::class.java)
                startIntentService.putExtra(MyIntentService.EXTRA_DURATION, 5000L)
                startService(startIntentService)
            }
            R.id.btn_start_bound_service -> {

            }
            R.id.btn_stop_bound_service -> {
                
            }
        }
    }
}
