package com.wit.mad2farmerapp.main

import android.app.Application
import com.wit.mad2farmerapp.models.FarmerMemStore
import com.wit.mad2farmerapp.models.FarmerStore
import timber.log.Timber

class FarmerApp : Application() {

    lateinit var farmersStore: FarmerStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        farmersStore = FarmerMemStore()
        Timber.i("Farmer Application Started")
    }
}