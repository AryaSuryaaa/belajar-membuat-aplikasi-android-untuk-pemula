package com.aryasurya.sushifushion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sushis(
    val nam: String,
    val price: String,
    val photo: Int
) : Parcelable
