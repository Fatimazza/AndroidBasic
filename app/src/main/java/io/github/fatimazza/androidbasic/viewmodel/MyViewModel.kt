package io.github.fatimazza.androidbasic.viewmodel

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var result = 0;

    fun calculate(length: String, width: String, height: String) {
        result = Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height)
    }
}
