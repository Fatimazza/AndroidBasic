package io.github.fatimazza.androidbasic.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews

import io.github.fatimazza.androidbasic.R

/**
 * Implementation of App Widget functionality.
 */
class RandomNumberWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    // Receive Broadcast Intent
    // Logic same as updateAppWidget()
    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        Log.d("Izza", "onReceive ${intent.action}")

        if (ACTION_CLICK == intent.action) {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetId = intent.getIntExtra(WIDGET_ID_EXTRA, 0)

            val lastUpdate = "Random: " + NumberGenerator.generate(100)
            val views = RemoteViews(context.packageName, R.layout.random_number_widget)
            views.setTextViewText(R.id.appwidget_text, lastUpdate)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    companion object {
        private const val ACTION_CLICK = "APPWIDGET_ACTION_CLICK"
        private const val WIDGET_ID_EXTRA = "widget_id_extra"
    }

    private fun updateAppWidget(
        context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int
    ) {
        
        Log.d("Izza", "updateAppWidget")

        val lastUpdate = "Random: " + NumberGenerator.generate(100)
        // Construct the RemoteViews object
        val views = RemoteViews(context.packageName, R.layout.random_number_widget)
        views.setTextViewText(R.id.appwidget_text, lastUpdate)

        // When view btn_click is Clicked, function to get Pending Intent is running
        views.setOnClickPendingIntent(
            R.id.btn_click,
            getPendingSelfIntent(context, appWidgetId, ACTION_CLICK)
        )

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    private fun getPendingSelfIntent(context: Context, appWidgetId: Int, action: String)
            : PendingIntent {

        Log.d("Izza", "create - getPendingIntent")

        // Broadcast Intent with Widget_ID as identifier
        val intent = Intent(context, javaClass)
        intent.action = action
        intent.putExtra(WIDGET_ID_EXTRA, appWidgetId)
        return PendingIntent.getBroadcast(context, appWidgetId, intent, 0)
    }
}

