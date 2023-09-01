package com.aryasurya.sushifushion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sushis(
    val name: String,
    val price: String,
    val photo: Int,
    val deskripsi: String
) : Parcelable
