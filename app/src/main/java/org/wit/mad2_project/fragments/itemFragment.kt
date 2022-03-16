package org.wit.mad2_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.NumberPicker
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import org.wit.mad2_project.R
import org.wit.mad2_project.databinding.FragmentItemBinding
import org.wit.mad2_project.main.BuildApp


class itemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var type: String = ""
    private var slot: String = ""
    lateinit var app: BuildApp
    var totalDonated = 0
    private var _fragBinding: FragmentItemBinding? = null
    private val fragBinding get() = _fragBinding!!

    var spinnerArrayTrait = R.array.traitsWeapon
    var spinnerArrayGlyph = R.array.glpyhsWeapon
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _fragBinding = FragmentItemBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        activity?.title = getString(R.string.build)

        val bundle = arguments
        type = bundle?.getString("type")!!
        slot = bundle?.getString("slot")!!

        //getParcelable("type")

        val traitSpinner: Spinner = fragBinding.trait
        val glyphSpinner: Spinner = fragBinding.glyph
        val weightSpinner: Spinner = fragBinding.weight


        if(type == "armor"){
            spinnerArrayTrait = R.array.traitsArmor
            spinnerArrayGlyph = R.array.glpyhsArmor
        }
        if(type == "jewel"){
            spinnerArrayTrait = R.array.traitsJewel
            spinnerArrayGlyph = R.array.glpyhsJewel
            fragBinding.weight.isEnabled = false
        }
        if(type == "wep"){
            spinnerArrayTrait = R.array.traitsWeapon
            spinnerArrayGlyph = R.array.glpyhsWeapon
            fragBinding.weight.isEnabled = false
        }




        ArrayAdapter.createFromResource(
            requireContext(),
            spinnerArrayTrait,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            traitSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            spinnerArrayGlyph,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            glyphSpinner.adapter = adapter
        }

        if(type == "armor"){
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.weights,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                weightSpinner.adapter = adapter
            }
        }

        val numberPicker: NumberPicker = fragBinding.quality
        numberPicker.minValue = 1
        numberPicker.maxValue = 5
        //val quality = [1,2,3,4,5]
        //numberPicker.setDisplayedValues(quality)

        fragBinding.saveItem.setOnClickListener() {
            val name: String = fragBinding.itemName.toString()
            val trait: String = fragBinding.trait.toString()
            val glyph: String = fragBinding.glyph.toString()
            val quality: Int = fragBinding.quality.value

            if(type == "armor"){
                val weight: String = fragBinding.weight.toString()
                val action = itemFragmentDirections.actionItemFragmentToBuildFragment(name, trait, glyph, quality, weight)
                findNavController().navigate(action)
            }else{
                val action = itemFragmentDirections.actionItemFragmentToBuildFragment(name, trait, glyph, quality, "")
                findNavController().navigate(action)
            }



        }

        return root
    }


    companion object {

    }
}