package io.github.fatimazza.androidbasic

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.fatimazza.androidbasic.widget.UpdateWidgetService

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
        val serviceComponent = ComponentName(this, UpdateWidgetService::class.java)

        val builder = JobInfo.Builder(JOB_ID, serviceComponent)
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //in Nougat, Job schedule is limited to 15 min
            builder.setPeriodic(90000) //90000L = 15min
        } else {
            builder.setPeriodic(SCHEDULE_OF_PERIOD) //86000L = 3min
        }

        // updatePeriodMillis in appwidget-provider should set to 0
        // to avoid conflict between:
        // scheduled update from Widget (0) and scheduled update from JobScheduler

        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(builder.build())

        Toast.makeText(this, getString(R.string.widget_job_started), Toast.LENGTH_SHORT).show()
    }

    private fun cancelJob() {
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.cancel(JOB_ID)
        Toast.makeText(this, getString(R.string.widget_job_cancelled), Toast.LENGTH_SHORT).show()
    }
}
