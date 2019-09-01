package io.github.fatimazza.androidbasic.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    var name: String = "",
    var age: Int = 0,
    var email: String = "",
    var city: String = ""
) : Parcelable
