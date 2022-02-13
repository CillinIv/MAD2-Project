package org.wit.mad2_project.fragments

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
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.wit.mad2_project.models.BuildModel

val newBuildTitle: String = "N/A"

val newHeadSlot: String = "N/A"
val newHeadWeight: String = "N/A"
val newHeadEnch: String = "N/A"
val newHeadTrait: String = "N/A"
val newHeadQuality: Int = 3


val newShoulderSlot: String = "N/A"
val newShoulderWeight: String = "N/A"
val newShoulderEnch: String = "N/A"
val newShoulderTrait: String = "N/A"
val newShoulderQuality: Int = 3

val newChestSlot: String = "N/A"
val newChestWeight: String = "N/A"
val newChestEnch: String = "N/A"
val newChestTrait: String = "N/A"
val newChestQuality: Int = 3

val newHandSlot: String = "N/A"
val newHandWeight: String = "N/A"
val newHandEnch: String = "N/A"
val newHandTrait: String = "N/A"
val newHandQuality: Int = 3

val newGloveSlot: String = "N/A"
val newGloveWeight: String = "N/A"
val newGloveEnch: String = "N/A"
val newGloveTrait: String = "N/A"
val newGloveQuality: Int = 3

val newWaistSlot: String = "N/A"
val newWaistWeight: String = "N/A"
val newWaistEnch: String = "N/A"
val newWaistTrait: String = "N/A"
val newWaistQuality: Int = 3

val newBootSlot: String = "N/A"
val newBootWeight: String = "N/A"
val newBootEnch: String = "N/A"
val newBootTrait: String = "N/A"
val newBootQuality: Int = 3

val newNeckSlot: String = "N/A"
val newNeckEnch: String = "N/A"
val newNeckTrait: String = "N/A"
val newNeckQuality: Int = 3

val newRing1Slot: String = "N/A"
val newRing1Ench: String = "N/A"
val newRing1Trait: String = "N/A"
val newRing1Quality: Int = 3

val newRing2Slot: String = "N/A"
val newRing2Ench: String = "N/A"
val newRing2Trait: String = "N/A"
val newRing2Quality: Int = 3

val newFrontSlot: String = "N/A"
val newFrontType: String = "N/A"
val newFrontEnch: String = "N/A"
val newFrontTrait: String = "N/A"
val newFrontQuality: Int = 3

val newBackSlot: String = "N/A"
val newBackType: String = "N/A"
val newBackEnch: String = "N/A"
val newBackTrait: String = "N/A"
val newBackQuality: Int = 3




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
        activity?.title = getString(R.string.buildTitle)
        setButtonListener(fragBinding)
        return root;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }

    override fun onResume() {
        super.onResume()
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

            app.buildStore.create(BuildModel(buildTitle = fragBinding.buildTitle.toString(),
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

        /*

        layout.headOpt.setOnClickListener {
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment()
            findNavController().navigate(R.id.action_buildFragment_to_itemFragment)

        }

        layout.saveButton.setOnClickListener {
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment()
            findNavController().navigate(action)
        }

        layout.saveButton.setOnClickListener {
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment()
            findNavController().navigate(action)
        }

        layout.saveButton.setOnClickListener {
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment()
            findNavController().navigate(action)
        }

        layout.saveButton.setOnClickListener {
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment()
            findNavController().navigate(action)
        }

        layout.saveButton.setOnClickListener {
            val action = BuildFragmentDirections.actionBuildFragmentToItemFragment()
            findNavController().navigate(action)
        }
         */
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_build, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}