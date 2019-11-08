package io.github.fatimazza.androidbasic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
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

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
    }

    private fun getPendingSelfIntent() {
        
    }

    companion object {

        private const val WIDGET_CLICK = "widgetsclick"
        private const val WIDGET_ID_EXTRA = "widget_id_extra"

        internal fun updateAppWidget(
            context: Context, appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {

            val lastUpdate = "Random: " + NumberGenerator.generate(100)
            // Construct the RemoteViews object
            val views = RemoteViews(context.packageName, R.layout.random_number_widget)
            views.setTextViewText(R.id.appwidget_text, lastUpdate)
            
            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

