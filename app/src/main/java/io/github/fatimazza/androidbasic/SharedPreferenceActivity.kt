package io.github.fatimazza.androidbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.fatimazza.androidbasic.model.SPUserModel
import io.github.fatimazza.androidbasic.utils.UserPreference
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {

    private lateinit var userPreference: UserPreference

    private var isPreferenceEmpty = false
    private lateinit var userModel: SPUserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        supportActionBar?.title = "My User Preference"

        userPreference = UserPreference(this)
        showExistingPreference()
    }

    private fun showExistingPreference() {
        userModel = userPreference.getUser()
        populateView(userModel)
        checkForm(userModel)
    }

    private fun populateView(userModel: SPUserModel) {
        tv_sp_name.text = if (userModel.name.toString().isEmpty())
            "Tidak Ada" else userModel.name
        tv_sp_age.text = if (userModel.age.toString().isEmpty())
            "Tidak Ada" else userModel.age.toString()
        tv_sp_email.text = if (userModel.email.toString().isEmpty())
            "Tidak Ada" else userModel.email
        tv_sp_handphone.text = if (userModel.handphone.toString().isEmpty())
            "Tidak Ada" else userModel.handphone
        tv_sp_hobby.text = if (!userModel.hasReadingHobby)
            "Tidak" else "Ya"
    }

    private fun checkForm(userModel: SPUserModel) {
        when {
            userModel.name.toString().isNotEmpty() -> {
                btn_sp_save.text = resources.getText(R.string.sp_change)
                isPreferenceEmpty = false
            }
            else -> {
                btn_sp_save.text = resources.getString(R.string.sp_save)
                isPreferenceEmpty = true
            }
        }
    }
}
