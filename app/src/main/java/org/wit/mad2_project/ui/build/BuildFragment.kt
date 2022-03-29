package org.wit.mad2_project.ui.build

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.wit.mad2_project.R
import org.wit.mad2_project.databinding.FragmentBuildBinding
import org.wit.mad2_project.main.BuildApp
import timber.log.Timber
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.wit.mad2_project.models.BuildModel

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

var newGloveSlot: String = "N/A"
var newGloveWeight: String = "N/A"
var newGloveEnch: String = "N/A"
var newGloveTrait: String = "N/A"
var newGloveQuality: Int = 3

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




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BuildFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BuildFragment : Fragment() {

    lateinit var app: BuildApp
    private var _fragBinding: FragmentBuildBinding? = null
    private val fragBinding get() = _fragBinding!!

    private lateinit var buildViewModel: BuildViewModel

    private var currentBuild = BuildModel(-1, newBuildTitle,
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

    gloveSlot = newGloveSlot,
    gloveWeight = newGloveWeight,
    gloveEnch = newGloveEnch,
    gloveTrait = newGloveTrait,
    gloveQuality = newGloveQuality,

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as BuildApp
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _fragBinding = FragmentBuildBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        activity?.title = newBuildTitle

        buildViewModel = ViewModelProvider(this).get(BuildViewModel::class.java)
        buildViewModel.observableBuild.observe(viewLifecycleOwner, Observer {
                render()
        })

        fragBinding.headOpt.setOnClickListener(){
            var type: String = "armor"
            var slot : String = "head"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.shoulderOpt.setOnClickListener(){
            var type: String = "armor"
            var slot : String = "shoulder"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.chestOpt.setOnClickListener(){
            var type: String = "armor"
            var slot : String = "chest"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.handOpt.setOnClickListener(){
            var type: String = "armor"
            var slot : String = "hand"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.waistOpt.setOnClickListener(){
            var type: String = "armor"
            var slot : String = "waist"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.legOpt.setOnClickListener(){
            var type: String = "armor"
            var slot : String = "leg"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.bootsOpt.setOnClickListener(){
            var type: String = "armor"
            var slot : String = "boots"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.neckOpt.setOnClickListener(){
            var type: String = "jewel"
            var slot : String = "neck"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.ring1Opt.setOnClickListener(){
            var type: String = "jewel"
            var slot : String = "ring1"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.ring2Opt.setOnClickListener(){
            var type: String = "jewel"
            var slot : String = "ring2"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.wep1Opt.setOnClickListener(){
            var type: String = "wep"
            var slot : String = "wep1"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type,slot,currentBuild)
            findNavController().navigate(action)
        }

        fragBinding.wep2Opt.setOnClickListener(){
            var type: String = "wep"
            var slot : String = "wep2"
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment(type, slot,currentBuild)
            findNavController().navigate(action)
        }

        return root;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }
    var one = 0
    override fun onResume() {
        super.onResume()
        val bundle = arguments ?: return

        if(one == 0){
            one++
            return
        }

        currentBuild = bundle?.getParcelable("build")!!

        if(bundle?.getString("slot") == "head"){
            currentBuild.headSlot = bundle?.getString("name").toString()
            currentBuild.headWeight = bundle?.getString("weight").toString()
            currentBuild.headEnch = bundle?.getString("glyph").toString()
            currentBuild.headTrait = bundle?.getString("trait").toString()
            currentBuild.headQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "shoulder"){
            currentBuild.shoulderSlot = bundle?.getString("name").toString()
            currentBuild.shoulderWeight = bundle?.getString("weight").toString()
            currentBuild.shoulderEnch = bundle?.getString("glyph").toString()
            currentBuild.shoulderTrait = bundle?.getString("trait").toString()
            currentBuild.shoulderQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "chest"){
            currentBuild.chestSlot = bundle?.getString("name").toString()
            currentBuild.chestWeight = bundle?.getString("weight").toString()
            currentBuild.chestEnch = bundle?.getString("glyph").toString()
            currentBuild.chestTrait = bundle?.getString("trait").toString()
            currentBuild.chestQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "hand"){
            currentBuild.handSlot = bundle?.getString("name").toString()
            currentBuild.handWeight = bundle?.getString("weight").toString()
            currentBuild.handEnch = bundle?.getString("glyph").toString()
            currentBuild.handTrait = bundle?.getString("trait").toString()
            currentBuild.handQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "waist"){
            currentBuild.waistSlot = bundle?.getString("name").toString()
            currentBuild.waistWeight = bundle?.getString("weight").toString()
            currentBuild.waistEnch = bundle?.getString("glyph").toString()
            currentBuild.waistTrait = bundle?.getString("trait").toString()
            currentBuild.waistQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "leg"){
            currentBuild.legSlot = bundle?.getString("name").toString()
            currentBuild.legWeight = bundle?.getString("weight").toString()
            currentBuild.legEnch = bundle?.getString("glyph").toString()
            currentBuild.legTrait = bundle?.getString("trait").toString()
            currentBuild.legQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "boots"){
            currentBuild.bootSlot = bundle?.getString("name").toString()
            currentBuild.bootWeight = bundle?.getString("weight").toString()
            currentBuild.bootEnch = bundle?.getString("glyph").toString()
            currentBuild.bootTrait = bundle?.getString("trait").toString()
            currentBuild.bootQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "neck"){
            currentBuild.neckSlot = bundle?.getString("name").toString()
            //currentBuild.bootWeight = bundle?.getString("weight").toString()
            currentBuild.neckEnch = bundle?.getString("glyph").toString()
            currentBuild.neckTrait = bundle?.getString("trait").toString()
            currentBuild.neckQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "ring1"){
            currentBuild.ring1Slot = bundle?.getString("name").toString()
            //currentBuild.bootWeight = bundle?.getString("weight").toString()
            currentBuild.ring1Ench = bundle?.getString("glyph").toString()
            currentBuild.ring1Trait = bundle?.getString("trait").toString()
            currentBuild.ring1Quality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "ring2"){
            currentBuild.ring2Slot = bundle?.getString("name").toString()
            //currentBuild.bootWeight = bundle?.getString("weight").toString()
            currentBuild.ring2Ench = bundle?.getString("glyph").toString()
            currentBuild.ring2Trait = bundle?.getString("trait").toString()
            currentBuild.ring2Quality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "wep1"){
            currentBuild.frontSlot = bundle?.getString("name").toString()
            currentBuild.frontType = bundle?.getString("weight").toString()
            currentBuild.frontEnch = bundle?.getString("glyph").toString()
            currentBuild.frontTrait = bundle?.getString("trait").toString()
            currentBuild.frontQuality = bundle?.getInt("quality")!!
        }else if(bundle?.getString("slot") == "wep2"){
            currentBuild.backSlot = bundle?.getString("name").toString()
            currentBuild.backType = bundle?.getString("weight").toString()
            currentBuild.backEnch = bundle?.getString("glyph").toString()
            currentBuild.backTrait = bundle?.getString("trait").toString()
            currentBuild.backQuality = bundle?.getInt("quality")!!
        }



        fragBinding.itemHeadView.text = currentBuild.headSlot
        fragBinding.itemShoulderView.text = currentBuild.shoulderSlot
        fragBinding.itemChestView.text = currentBuild.chestSlot
        fragBinding.itemWaistView.text = currentBuild.waistSlot
        fragBinding.itemHandsView.text = currentBuild.handSlot
        fragBinding.itemLegView.text = currentBuild.legSlot
        fragBinding.itemBootsView.text = currentBuild.bootSlot
        //fragBinding.item.text = currentBuild.headSlot
        //fragBinding.itemHeadView.text = currentBuild.headSlot
        //fragBinding.itemHeadView.text = currentBuild.headSlot
        fragBinding.itemFrontWepView.text = currentBuild.frontSlot
        fragBinding.itemBackWepView.text = currentBuild.backSlot






        // TODO add in build fields
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BuildFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    fun setButtonListener(layout: FragmentBuildBinding) {
        layout.saveButton.setOnClickListener {

            app.buildStore.create(BuildModel(buildTitle = newBuildTitle,
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

                gloveSlot = newGloveSlot,
                gloveWeight = newGloveWeight,
                gloveEnch = newGloveEnch,
                gloveTrait = newGloveTrait,
                gloveQuality = newGloveQuality,

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
                backQuality = newBackQuality,))
            //TODO Save build
            Timber.i("Saving build!")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_build, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun render() {

        view?.let {

        }
    }



}