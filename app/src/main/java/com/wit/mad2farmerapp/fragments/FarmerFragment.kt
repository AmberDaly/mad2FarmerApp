package com.wit.mad2farmerapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.wit.mad2farmerapp.R
import com.wit.mad2farmerapp.databinding.FragmentFarmerBinding
import com.wit.mad2farmerapp.main.FarmerApp
import com.wit.mad2farmerapp.models.FarmerModel


class FarmerFragment : Fragment() {
    lateinit var app: FarmerApp

    private var _fragBinding: FragmentFarmerBinding? = null
    private val fragBinding get() = _fragBinding!!
    //lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as FarmerApp
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _fragBinding = FragmentFarmerBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        activity?.title = getString(R.string.action_farmer)



        setButtonListener(fragBinding)
        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FarmerFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    fun setButtonListener(layout: FragmentFarmerBinding) {
        layout.farmerButton.setOnClickListener {
            val enter =
                layout.paymentAmount.text.toString().toInt()



                val produceType = if(layout.produceType.checkedRadioButtonId == R.id.Vegetable) "Vegetable" else "fruit"



                app.farmersStore.create(FarmerModel(produceType = produceType,enter = enter))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_farmer, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }


}