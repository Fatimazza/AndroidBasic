package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
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
            val name = etPrefName.text.toString().trim()
            val email = etPrefEmail.text.toString().trim()
            val age = etPrefAge.text.toString().trim()
            val handphone = etPrefHp.text.toString().trim()
            val hasReadingHobby = rgPrefHobby.checkedRadioButtonId == R.id.rbPrefReading

            if (name.isEmpty()) {
                etPrefName.error = resources.getString(R.string.sp_field_required)
                return
            }

            if (email.isEmpty()) {
                etPrefEmail.error = resources.getString(R.string.sp_field_required)
                return
            }

            if (!isValidEmail(email)) {
                etPrefEmail.error = resources.getString(R.string.sp_field_email_not_valid)
                return
            }

            if (age.isEmpty()) {
                etPrefAge.error = resources.getString(R.string.sp_field_required)
                return
            }

            if (handphone.isEmpty()) {
                etPrefHp.error = resources.getString(R.string.sp_field_required)
                return
            }

            if (!handphone.isDigitsOnly()) {
                etPrefHp.error = resources.getString(R.string.sp_field_digit_only)
                return
            }
            

        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
