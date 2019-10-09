package io.github.fatimazza.androidbasic.customview

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet

class CustomButton : AppCompatButton {
    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}
