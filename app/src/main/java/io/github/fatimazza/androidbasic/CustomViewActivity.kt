package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_custom_view.*

class CustomViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        setMyButtonEnable()
        setTextChangeListener()
        setButtonClickListener()
    }

    private fun setMyButtonEnable() {
        val text = et_edit_custom.text
        btn_submit_custom.isEnabled = text != null && text.toString().isNotEmpty()
    }

    private fun setTextChangeListener() {
        et_edit_custom.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setMyButtonEnable()
            }
        })
    }

    private fun setButtonClickListener() {
        btn_submit_custom.setOnClickListener {
            Toast.makeText(
                this,
                et_edit_custom.text,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
