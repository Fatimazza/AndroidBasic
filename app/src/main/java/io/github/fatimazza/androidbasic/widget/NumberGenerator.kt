package io.github.fatimazza.androidbasic.widget

import java.util.*

internal object NumberGenerator {
    fun generate(max: Int): Int {
        val random = Random()
        return random.nextInt(max)
    }
}
