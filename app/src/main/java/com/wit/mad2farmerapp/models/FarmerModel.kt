package com.wit.mad2farmerapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FarmerModel (var id: Long = 0,
                        val paymentmethod: String = "N/A",
                        val amount: Int = 0) : Parcelable