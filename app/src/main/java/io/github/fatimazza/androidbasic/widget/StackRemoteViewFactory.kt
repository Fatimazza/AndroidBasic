package io.github.fatimazza.androidbasic.widget

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.core.os.bundleOf
import io.github.fatimazza.androidbasic.R

internal class StackRemoteViewFactory(private val mContext: Context) :
    RemoteViewsService.RemoteViewsFactory {

    private val mWidgetItems = ArrayList<Bitmap>()

    override fun onCreate() {

    }

    override fun hasStableIds(): Boolean = false

    override fun getLoadingView(): RemoteViews? = null

    override fun getItemId(i: Int): Long = 0

    override fun getViewTypeCount(): Int = 1

    override fun getViewAt(position: Int): RemoteViews {
        val rv = RemoteViews(mContext.packageName, R.layout.item_image_widget)
        rv.setImageViewBitmap(R.id.ivImageWidget, mWidgetItems[position])

        val extras = bundleOf(ImageStackWidget.EXTRA_ITEM to position)
        val fillInIntent = Intent()
        fillInIntent.putExtras(extras)

        rv.setOnClickFillInIntent(R.id.imageView, fillInIntent)
        return rv
    }

    override fun getCount(): Int = mWidgetItems.size

    override fun onDataSetChanged() {
        mWidgetItems.add(
            BitmapFactory.decodeResource(mContext.resources, R.drawable.starwars_darth_vader)
        )
        mWidgetItems.add(
            BitmapFactory.decodeResource(mContext.resources, R.drawable.starwars_logo)
        )
        mWidgetItems.add(
            BitmapFactory.decodeResource(mContext.resources, R.drawable.starwars_storm_trooper)
        )
        mWidgetItems.add(
            BitmapFactory.decodeResource(mContext.resources, R.drawable.starwars)
        )
        mWidgetItems.add(
            BitmapFactory.decodeResource(mContext.resources, R.drawable.starwars_falcon)
        )
    }

    override fun onDestroy() {

    }

}
