package io.github.fatimazza.androidbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import io.github.fatimazza.androidbasic.viewmodel.MyViewModel

class MyViewModelActivity : AppCompatActivity() {

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
