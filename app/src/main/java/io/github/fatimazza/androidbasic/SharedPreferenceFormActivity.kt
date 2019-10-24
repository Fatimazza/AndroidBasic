package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.fatimazza.androidbasic.model.SPUserModel
import kotlinx.android.synthetic.main.activity_shared_preference_form.*

class SharedPreferenceFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_TYPE_FORM = "extra_type_form"
        const val EXTRA_RESULT = "extra_result"
        const val RESULT_CODE = 101
        const val TYPE_ADD = 1
        const val TYPE_EDIT = 2
    }

    private lateinit var userModel: SPUserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_form)

        btnPrefSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnPrefSave) {

        }
    }
}
