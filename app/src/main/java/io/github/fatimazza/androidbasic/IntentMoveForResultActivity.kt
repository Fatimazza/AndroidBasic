package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_intent_move_result.*

class IntentMoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private val rgNumber: RadioGroup
        get() = rg_number

    private val btnChoose: Button
        get() = btn_choose

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_result)

        rgNumber.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_choose) {
            if (rgNumber.checkedRadioButtonId != 0) {
                var value = 0
                when (rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
            }
        }
    }
}