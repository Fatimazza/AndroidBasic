package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
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
    }

    private fun initViewModel() {
        myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
    }
}
