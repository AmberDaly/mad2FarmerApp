package com.wit.mad2farmerapp.models

interface FarmerStore {
    fun findAll() : List<FarmerModel>
    fun findById(id: Long) : FarmerModel?
    fun create(donation: FarmerModel)
}