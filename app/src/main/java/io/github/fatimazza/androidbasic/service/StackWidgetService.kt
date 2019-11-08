package io.github.fatimazza.androidbasic.service

import android.content.Intent
import android.widget.RemoteViewsService
import io.github.fatimazza.androidbasic.widget.StackRemoteViewFactory

class StackWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory =
        StackRemoteViewFactory(this.applicationContext)
}
