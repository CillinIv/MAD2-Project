package org.wit.mad2_project.ui.builddetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.wit.mad2_project.R
import org.wit.mad2_project.databinding.FragmentBuildDetailBinding
import org.wit.mad2_project.ui.auth.LoggedInViewModel
import org.wit.mad2_project.ui.buildlist.BuildListViewModel
import timber.log.Timber

class BuildDetailFragment : Fragment() {

    private lateinit var detailViewModel: BuildDetailViewModel
    private val args by navArgs<BuildDetailFragmentArgs>()
    private var _fragBinding: FragmentBuildDetailBinding? = null
    private val fragBinding get() = _fragBinding!!
    private val loggedInViewModel : LoggedInViewModel by activityViewModels()
    private val reportViewModel : BuildListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_build_detail, container, false)
        Toast.makeText(context,"Build ID Selected : ${args.id}",Toast.LENGTH_LONG).show()

        fragBinding.deleteBuildButton.setOnClickListener {
            reportViewModel.delete(loggedInViewModel.liveFirebaseUser.value?.email!!,
                detailViewModel.observableBuild.value?.id!!)

            findNavController().navigateUp()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }
}

