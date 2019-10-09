package io.github.fatimazza.androidbasic.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.Gravity.CENTER
import io.github.fatimazza.androidbasic.R

class CustomButton : AppCompatButton {

    private var enableBackground: Drawable? = null
    private var disableBackground: Drawable? = null
    private var txtColor: Int = 0

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
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enableBackground = ResourcesCompat.getDrawable(resources, R.drawable.bg_button, null)
        disableBackground =
            ResourcesCompat.getDrawable(resources, R.drawable.bg_button_disable, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = when {
            isEnabled -> enableBackground
            else -> disableBackground
        }
        setTextColor(txtColor)
        textSize = 12f
        gravity = CENTER
        text = when {
            isEnabled -> "Submit"
            else -> "Submit"
        }
    }
}
