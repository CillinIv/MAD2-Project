package org.wit.mad2_project.ui.item

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
import org.wit.mad2_project.models.BuildModel


class itemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var newBuildTitle: String = "N/A"

    var newHeadSlot: String = "N/A"
    var newHeadWeight: String = "N/A"
    var newHeadEnch: String = "N/A"
    var newHeadTrait: String = "N/A"
    var newHeadQuality: Int = 3

    var newShoulderSlot: String = "N/A"
    var newShoulderWeight: String = "N/A"
    var newShoulderEnch: String = "N/A"
    var newShoulderTrait: String = "N/A"
    var newShoulderQuality: Int = 3

    var newChestSlot: String = "N/A"
    var newChestWeight: String = "N/A"
    var newChestEnch: String = "N/A"
    var newChestTrait: String = "N/A"
    var newChestQuality: Int = 3

    var newHandSlot: String = "N/A"
    var newHandWeight: String = "N/A"
    var newHandEnch: String = "N/A"
    var newHandTrait: String = "N/A"
    var newHandQuality: Int = 3

    var newWaistSlot: String = "N/A"
    var newWaistWeight: String = "N/A"
    var newWaistEnch: String = "N/A"
    var newWaistTrait: String = "N/A"
    var newWaistQuality: Int = 3

    var newBootSlot: String = "N/A"
    var newBootWeight: String = "N/A"
    var newBootEnch: String = "N/A"
    var newBootTrait: String = "N/A"
    var newBootQuality: Int = 3

    var newNeckSlot: String = "N/A"
    var newNeckEnch: String = "N/A"
    var newNeckTrait: String = "N/A"
    var newNeckQuality: Int = 3

    val newRing1Slot: String = "N/A"
    val newRing1Ench: String = "N/A"
    val newRing1Trait: String = "N/A"
    val newRing1Quality: Int = 3

    var newRing2Slot: String = "N/A"
    var newRing2Ench: String = "N/A"
    var newRing2Trait: String = "N/A"
    var newRing2Quality: Int = 3

    var newFrontSlot: String = "N/A"
    var newFrontType: String = "N/A"
    var newFrontEnch: String = "N/A"
    var newFrontTrait: String = "N/A"
    var newFrontQuality: Int = 3

    var newBackSlot: String = "N/A"
    var newBackType: String = "N/A"
    var newBackEnch: String = "N/A"
    var newBackTrait: String = "N/A"
    var newBackQuality: Int = 3

    private var currentBuild = BuildModel("1", newBuildTitle,
        headSlot = newHeadSlot,
        headWeight = newHeadWeight,
        headEnch = newHeadEnch,
        headTrait = newHeadTrait,
        headQuality = newHeadQuality,


        shoulderSlot = newShoulderSlot,
        shoulderWeight = newShoulderWeight,
        shoulderEnch = newShoulderEnch,
        shoulderTrait = newShoulderTrait,
        shoulderQuality = newShoulderQuality,

        chestSlot = newChestSlot,
        chestWeight = newChestWeight,
        chestEnch = newChestEnch,
        chestTrait = newChestTrait,
        chestQuality = newChestQuality,

        handSlot = newHandSlot,
        handWeight = newHandWeight,
        handEnch = newHandEnch,
        handTrait = newHandTrait,
        handQuality = newHandQuality,

        waistSlot = newWaistSlot,
        waistWeight = newWaistWeight,
        waistEnch = newWaistEnch,
        waistTrait = newWaistTrait,
        waistQuality = newWaistQuality,

        bootSlot = newBootSlot,
        bootWeight = newBootWeight,
        bootEnch = newBootEnch,
        bootTrait = newBootTrait,
        bootQuality = newBootQuality,

        neckSlot = newNeckSlot,
        neckEnch = newNeckEnch,
        neckTrait = newNeckTrait,
        neckQuality = newNeckQuality,

        ring1Slot = newRing1Slot,
        ring1Ench = newRing1Ench,
        ring1Trait = newRing1Trait,
        ring1Quality = newRing1Quality,

        ring2Slot = newRing2Slot,
        ring2Ench = newRing2Ench,
        ring2Trait = newRing2Trait,
        ring2Quality = newRing2Quality,

        frontSlot = newFrontSlot,
        frontType = newFrontType,
        frontEnch = newFrontEnch,
        frontTrait = newFrontTrait,
        frontQuality = newFrontQuality,

        backSlot = newBackSlot,
        backType = newBackType,
        backEnch = newBackEnch,
        backTrait = newBackTrait,
        backQuality = newBackQuality,)


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
        currentBuild = bundle?.getParcelable("build")!!


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
                val action = itemFragmentDirections.actionItemFragmentToBuildFragment(name, trait, glyph, quality.toString(), weight, currentBuild)
                findNavController().navigate(action)
            }else{
                val action = itemFragmentDirections.actionItemFragmentToBuildFragment(name, trait, glyph, quality.toString(), "", currentBuild)
                findNavController().navigate(action)
            }



        }

        return root
    }


    companion object {

    }
}