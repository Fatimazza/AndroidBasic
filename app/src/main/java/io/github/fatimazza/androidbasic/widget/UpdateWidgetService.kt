package io.github.fatimazza.androidbasic.widget

import android.app.job.JobParameters
import android.app.job.JobService

//JobScheduler only works in API >21
class UpdateWidgetService : JobService() {

    override fun onStartJob(jobParameters: JobParameters): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStopJob(jobParameters: JobParameters): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
