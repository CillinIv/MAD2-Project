package org.wit.mad2_project.ui.buildlist

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.wit.mad2_project.R
import org.wit.mad2_project.adapters.BuildAdapter
import org.wit.mad2_project.adapters.BuildClickListener
import org.wit.mad2_project.databinding.FragmentBuildlistBinding
import org.wit.mad2_project.main.BuildApp
import org.wit.mad2_project.models.BuildModel
import org.wit.mad2_project.utils.createLoader


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

    lateinit var app: BuildApp
    private var _fragBinding: FragmentBuildlistBinding? = null
    private val fragBinding get() = _fragBinding!!
    private lateinit var buildListViewModel: BuildListViewModel
    lateinit var loader : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as BuildApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragBinding = FragmentBuildlistBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        loader = createLoader(requireActivity())

        fragBinding.recyclerView.layoutManager = LinearLayoutManager(activity)


        val fab: FloatingActionButton = fragBinding.fab
        fab.setOnClickListener {
            //val action = BuildListFragmentDirections.actionBuildListFragmentToBuildFragment()
            //findNavController().navigate(action)
        }
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

    private fun render(buildList: List<BuildModel>) {
        fragBinding.recyclerView.adapter = BuildAdapter(buildList,this)
        if (buildList.isEmpty()) {
            fragBinding.recyclerView.visibility = View.GONE
            fragBinding.buildsNotFound.visibility = View.VISIBLE
        } else {
            fragBinding.recyclerView.visibility = View.VISIBLE
            fragBinding.buildsNotFound.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        buildListViewModel.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }

    override fun onBuildClick(build: BuildModel) {
        val action = BuildListFragmentDirections.actionBuildListFragmentToBuildDetailFragment(build.id)
        findNavController().navigate(action)
    }

}