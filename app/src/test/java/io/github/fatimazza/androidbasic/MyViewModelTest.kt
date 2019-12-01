package io.github.fatimazza.androidbasic

import io.github.fatimazza.androidbasic.viewmodel.MyViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyViewModelTest {

    private lateinit var myViewModel: MyViewModel

    @Before
    fun init() {
        myViewModel = MyViewModel()
    }

    @Test
    fun calculate() {
        val length: String = "2"
        val width: String = "3"
        val height: String = "4"
        myViewModel.calculate(length, width, height)
        assertEquals(24, myViewModel.result)
    }
}
