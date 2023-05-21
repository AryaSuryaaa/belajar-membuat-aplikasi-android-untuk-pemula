package com.surya.projectakhir

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val description: String,
    val photo: String,
    val status: String,
    val season: String,
    val studios: String,
    val namec1: String,
    val imgc1: String,
    val namec2: String,
    val imgc2: String,
    val namec3: String,
    val imgc3: String,
    val namec4: String,
    val imgc4: String,
    val namec5: String,
    val imgc5: String,
    val genre: String,

) : Parcelable
