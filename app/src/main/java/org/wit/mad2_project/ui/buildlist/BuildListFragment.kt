package org.wit.mad2_project.ui.buildlist

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.wit.mad2_project.R
import org.wit.mad2_project.adapters.BuildAdapter
import org.wit.mad2_project.adapters.BuildClickListener
import org.wit.mad2_project.databinding.FragmentBuildlistBinding
import org.wit.mad2_project.main.BuildApp
import org.wit.mad2_project.models.BuildModel
import org.wit.mad2_project.ui.auth.LoggedInViewModel
import org.wit.mad2_project.utils.*
import timber.log.Timber


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BuildListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BuildListFragment : Fragment(), BuildClickListener {

    private val loggedInViewModel : LoggedInViewModel by activityViewModels()
    private var _fragBinding: FragmentBuildlistBinding? = null
    private val fragBinding get() = _fragBinding!!
    private val buildListViewModel: BuildListViewModel by activityViewModels()
    lateinit var loader : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragBinding = FragmentBuildlistBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        loader = createLoader(requireActivity())

        fragBinding.recyclerView.layoutManager = LinearLayoutManager(activity)
        fragBinding.fab.setOnClickListener {
            val action = BuildListFragmentDirections.actionBuildListFragmentToBuildFragment(null)
            findNavController().navigate(action)
        }
        showLoader(loader,"Downloading Builds")
        buildListViewModel.observableBuildList.observe(viewLifecycleOwner, Observer {
                builds ->
            builds?.let {
                render(builds as ArrayList<BuildModel>)
                hideLoader(loader)
                checkSwipeRefresh()
            }
        })

        setSwipeRefresh()

        val swipeDeleteHandler = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                showLoader(loader,"Deleting Build")
                val adapter = fragBinding.recyclerView.adapter as BuildAdapter
                adapter.removeAt(viewHolder.adapterPosition)
                buildListViewModel.delete(buildListViewModel.liveFirebaseUser.value?.uid!!,
                    (viewHolder.itemView.tag as BuildModel).uid!!)
                hideLoader(loader)
            }
        }
        val itemTouchDeleteHelper = ItemTouchHelper(swipeDeleteHandler)
        itemTouchDeleteHelper.attachToRecyclerView(fragBinding.recyclerView)

        /*
        val swipeEditHandler = object : SwipeToEditCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                onBuildClick(viewHolder.itemView.tag as BuildModel)
            }
        }

        val itemTouchEditHelper = ItemTouchHelper(swipeEditHandler)
        itemTouchEditHelper.attachToRecyclerView(fragBinding.recyclerView)
        */

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_buildlist, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun render(buildList: ArrayList<BuildModel>) {
        fragBinding.recyclerView.adapter = BuildAdapter(buildList,this)
        if (buildList.isEmpty()) {
            fragBinding.recyclerView.visibility = View.GONE
            fragBinding.buildsNotFound.visibility = View.VISIBLE
            Timber.i("No builds found")
        } else {
            fragBinding.recyclerView.visibility = View.VISIBLE
            fragBinding.buildsNotFound.visibility = View.GONE
            Timber.i("Builds found")
        }
    }

    private fun setSwipeRefresh() {
        fragBinding.swiperefresh.setOnRefreshListener {
            fragBinding.swiperefresh.isRefreshing = true
            showLoader(loader,"Downloading Builds")
            buildListViewModel.load()
        }
    }

    private fun checkSwipeRefresh() {
        if (fragBinding.swiperefresh.isRefreshing)
            fragBinding.swiperefresh.isRefreshing = false
    }

    override fun onResume() {
        super.onResume()
        showLoader(loader,"Downloading Builds")
        loggedInViewModel.liveFirebaseUser.observe(viewLifecycleOwner, Observer { firebaseUser ->
            if (firebaseUser != null) {
                buildListViewModel.liveFirebaseUser.value = firebaseUser
                buildListViewModel.load()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }

    override fun onBuildClick(build: BuildModel) {
        val action = BuildListFragmentDirections.actionBuildListFragmentToBuildDetailFragment(build.uid)
        findNavController().navigate(action)
    }

}