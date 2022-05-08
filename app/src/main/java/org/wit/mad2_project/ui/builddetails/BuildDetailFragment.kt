package org.wit.mad2_project.ui.builddetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.wit.mad2_project.R
import org.wit.mad2_project.databinding.FragmentBuildDetailBinding
import org.wit.mad2_project.ui.auth.LoggedInViewModel
import org.wit.mad2_project.ui.build.BuildFragmentDirections
import org.wit.mad2_project.ui.buildlist.BuildListViewModel
import timber.log.Timber

class BuildDetailFragment : Fragment() {

    private lateinit var detailViewModel: BuildDetailViewModel
    private val args by navArgs<BuildDetailFragmentArgs>()
    private var _fragBinding: FragmentBuildDetailBinding? = null
    private val fragBinding get() = _fragBinding!!
    private val loggedInViewModel : LoggedInViewModel by activityViewModels()
    private val buildListViewModel : BuildListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        _fragBinding = FragmentBuildDetailBinding.inflate(inflater, container, false)
        val root = fragBinding.root

        detailViewModel = ViewModelProvider(this).get(BuildDetailViewModel::class.java)
        detailViewModel.observableBuild.observe(viewLifecycleOwner, Observer { render() })


        fragBinding.deleteBuildButton.setOnClickListener {
            Timber.i("build id == + $detailViewModel.observableBuild.value?.uid!!")
            buildListViewModel.delete(loggedInViewModel.liveFirebaseUser.value?.uid!!,
                detailViewModel.observableBuild.value!!.uid)

            val action = BuildDetailFragmentDirections.actionBuildDetailFragmentToBuildListFragment()
            findNavController().navigate(action)
        }

        return root
    }

    private fun render() {
        fragBinding.buildvm = detailViewModel
        Timber.i("Retrofit fragBinding.buildmv == $fragBinding.buildmv")
    }

    override fun onResume() {
        super.onResume()
        detailViewModel.getBuild(loggedInViewModel.liveFirebaseUser.value?.uid!!,
            args.id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }
}

