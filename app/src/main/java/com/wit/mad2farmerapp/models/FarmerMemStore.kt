package com.wit.mad2farmerapp.models

import timber.log.Timber

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class FarmerMemStore : FarmerStore {
    val farmers = ArrayList<FarmerModel>()

    override fun findAll(): List<FarmerModel> {
        return farmers
    }

    override fun findById(id:Long) : FarmerModel? {
        val foundFarmer: FarmerModel? = farmers.find { it.id == id }
        return foundFarmer
    }

    override fun create(farmer: FarmerModel) {
        farmer.id = getId()
        farmers.add(farmer)
        logAll()
    }

    fun logAll() {
        Timber.v("** Farmer List **")
        farmers.forEach { Timber.v("farmer ${it}") }
    }
}