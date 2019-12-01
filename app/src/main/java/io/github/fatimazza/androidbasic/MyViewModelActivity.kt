package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.github.fatimazza.androidbasic.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_myview_model.*

class MyViewModelActivity : AppCompatActivity() {

    private val tvResult: TextView
        get() = tv_result

    private val btnCalculate: Button
        get() = btn_calculate

    private val etLength: EditText
        get() = edt_length

    private val etWidth: EditText
        get() = edt_width

    private val etHeight: EditText
        get() = edt_height

    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myview_model)

        initViewModel()
        displayResult()
        setClickListener()
    }

    private fun initViewModel() {
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    }

    private fun displayResult() {
        tvResult.text = myViewModel.result.toString()
    }

    private fun setClickListener() {
        btnCalculate.setOnClickListener {
            val length = etLength.text.toString()
            val width = etWidth.text.toString()
            val height = etHeight.text.toString()

            if (length.isEmpty()) {
                etLength.error = "Empty Field"
            } else if (width.isEmpty()) {
                etWidth.error = "Empty Field"
            } else if (height.isEmpty()) {
                etHeight.error = "Empty Field"
            } else {
                myViewModel.calculate(length, width, height)
                displayResult()
            }
        }
    }
}
