package io.github.fatimazza.androidbasic

import io.github.fatimazza.androidbasic.viewmodel.MyViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class MyViewModelTest {

    private lateinit var myViewModel: MyViewModel

    @Rule
    @JvmField // fix rule must be public
    public var thrown = ExpectedException.none()

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

    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun doubleInputCalculateTest() {
        val length: String = "2.5" //java.lang.NumberFormatException: For input string: "2.5"
        val width: String = "3"
        val height: String = "4"

        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.5\"")

        myViewModel.calculate(length, width, height)
    }
}
