package io.github.fatimazza.androidbasic.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SPUserModel(
    var name: String? = null,
    var email: String? = null,
    var age: Int = 0,
    var handphone: String? = null,
    var hasReadingHobby: Boolean = false
) : Parcelable
