package io.github.fatimazza.androidbasic.utils

import android.content.Context
import io.github.fatimazza.androidbasic.model.SPUserModel

internal class UserPreference(context: Context) {

    companion object {
        private const val PREFS_USER = "user_prefs"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val HANDPHONE = "handphone"
        private const val HAS_READING_HOBBY = "hasReadingHobby"
    }

    private val preferences = context.getSharedPreferences(PREFS_USER, Context.MODE_PRIVATE)

    fun setUser(value: SPUserModel) {
        val editor = preferences.edit()
        editor.putString(NAME, value.name)
        editor.putString(EMAIL, value.email)
        editor.putInt(AGE, value.age)
        editor.putString(HANDPHONE, value.handphone)
        editor.putBoolean(HAS_READING_HOBBY, value.hasReadingHobby)
        editor.apply()
    }

    fun getUser(): SPUserModel {
        val model = SPUserModel()
        model.name = preferences.getString(NAME, "")
        model.email = preferences.getString(EMAIL, "")
        model.age = preferences.getInt(AGE, 0)
        model.handphone = preferences.getString(HANDPHONE, "")
        model.hasReadingHobby = preferences.getBoolean(HAS_READING_HOBBY, false)
        return model
    }
    
}
