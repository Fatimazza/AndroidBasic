package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WidgetActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val JOB_ID = 100
        private const val SCHEDULE_OF_PERIOD = 86000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_jobscheduler_widget_start -> {
                startJob()
            }
            R.id.btn_jobscheduler_widget_stop -> {
                cancelJob()
            }
        }
    }

    private fun startJob() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun cancelJob() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
