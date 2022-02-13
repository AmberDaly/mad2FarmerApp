package com.wit.mad2farmerapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FarmerModel (var id: Long = 0,
                        val produceType: String = "N/A",
                        val enter: Int = 0) : Parcelable