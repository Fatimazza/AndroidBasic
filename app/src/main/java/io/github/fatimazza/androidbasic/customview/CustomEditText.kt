package io.github.fatimazza.androidbasic.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import android.view.View
import io.github.fatimazza.androidbasic.R

class CustomEditText : AppCompatEditText {

    internal lateinit var imgClearButton: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        imgClearButton =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_close_black_24dp, null) as Drawable
    }

    private fun hideClearButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
    }

    private fun showClearButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, imgClearButton, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        hint = "Masukkan nama Anda"
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }
}
