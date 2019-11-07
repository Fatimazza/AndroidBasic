package io.github.fatimazza.androidbasic.widget

import android.app.job.JobParameters
import android.app.job.JobService
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.widget.RemoteViews
import io.github.fatimazza.androidbasic.R

//JobScheduler only works in API >21
class UpdateWidgetService : JobService() {

    override fun onStartJob(jobParameters: JobParameters): Boolean {
        //get random number
        //logic same as updateAppWidget() inside RandomNumber Widget

        val manager = AppWidgetManager.getInstance(this)
        val randomNumberWidget = ComponentName(this, RandomNumberWidget::class.java)

        val lastUpdate = "Random: " + NumberGenerator.generate(100)
        val views = RemoteViews(packageName, R.layout.random_number_widget)
        views.setTextViewText(R.id.appwidget_text, lastUpdate)

        //update from Service will update all Widgets
        manager.updateAppWidget(randomNumberWidget, views)
        jobFinished(jobParameters, false)
        return true
    }

    override fun onStopJob(jobParameters: JobParameters): Boolean = false

}
