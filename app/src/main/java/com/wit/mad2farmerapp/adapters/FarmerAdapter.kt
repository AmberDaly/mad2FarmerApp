package com.wit.mad2farmerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wit.mad2farmerapp.R
import com.wit.mad2farmerapp.databinding.CardFarmerBinding
import com.wit.mad2farmerapp.models.FarmerModel

class FarmerAdapter constructor(private var farmers: List<FarmerModel>)
    : RecyclerView.Adapter<FarmerAdapter.MainHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardFarmerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val farmer = farmers[holder.adapterPosition]
        holder.bind(farmer)
    }

    override fun getItemCount(): Int = farmers.size

    inner class MainHolder(val binding : CardFarmerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(farmer: FarmerModel) {
            binding.paymentamount.text = farmer.amount.toString()
            binding.paymentmethod.text = farmer.paymentmethod
            binding.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }

}