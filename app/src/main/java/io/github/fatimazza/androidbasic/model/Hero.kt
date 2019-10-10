package io.github.fatimazza.androidbasic.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var name: String = "",
    var origin: String = "",
    var photo: String = ""
) : Parcelable
