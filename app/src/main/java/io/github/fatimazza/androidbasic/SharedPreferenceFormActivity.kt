package io.github.fatimazza.androidbasic

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import io.github.fatimazza.androidbasic.model.SPUserModel
import io.github.fatimazza.androidbasic.utils.UserPreference
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
    private var formType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_form)

        btnPrefSave.setOnClickListener(this)
        getIntentExtra()
        setupFormType()
        setupForm("", "")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getIntentExtra() {
        userModel = intent.getParcelableExtra("USER") as SPUserModel
        formType = intent.getIntExtra(EXTRA_TYPE_FORM, 0)
    }

    private fun setupFormType() {
        when (formType) {
            TYPE_ADD -> {
                setupForm("Tambah Baru", "Simpan")
            }
            TYPE_EDIT -> {
                setupForm("Ubah", "Update")
                showPreferenceInForm()
            }
        }
    }

    private fun setupForm(actionBarTitle: String, btnTitle: String) {
        supportActionBar?.title = actionBarTitle
        btnPrefSave.text = btnTitle
    }

    private fun showPreferenceInForm() {
        etPrefName.setText(userModel.name)
        etPrefEmail.setText(userModel.email)
        etPrefAge.setText(userModel.age)
        etPrefHp.setText(userModel.handphone)
        rbPrefReading.isChecked = userModel.hasReadingHobby
        rbPrefNotReading.isChecked = !userModel.hasReadingHobby
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

            saveUser(name, email, age, handphone, hasReadingHobby)
            val resultIntent = Intent().putExtra(EXTRA_RESULT, userModel)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }

    private fun saveUser(
        name: String, email: String, age: String, handphone: String, hasReadingHobby: Boolean
    ) {
        val userPreference = UserPreference(this)
        userModel.name = name
        userModel.email = email
        userModel.age = Integer.parseInt(age)
        userModel.handphone = handphone
        userModel.hasReadingHobby = hasReadingHobby
        userPreference.setUser(userModel)
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
