package com.example.freelanceplatform.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.freelanceplatform.R
import com.example.freelanceplatform.adapter.ActiveProjectsAdapter
import com.example.freelanceplatform.adapter.ClickListener
import com.example.freelanceplatform.databinding.FragmentHomeBinding
import com.example.freelanceplatform.model.ActiveProjects

class HomeFragment : Fragment(), FirestoreListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        homeViewModel.firestoreListener = this
        binding.viewAllButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_activeProjetsDetailsFragment)
        }
        var adapter = ActiveProjectsAdapter(ClickListener { projects: ActiveProjects ->
            homeViewModel.onProjectItemClicked(projects)

        })

        binding.activeProjectsList.adapter = adapter

        homeViewModel.getActiveProjects()
        homeViewModel.activeProjectsList.observe(viewLifecycleOwner, Observer { projectList ->
            projectList.let {
                if (it != null) {
                    /**                   Use submitList() to keep the list updated**/
                    adapter.submitList(projectList)
                } else {
                    Toast.makeText(activity, "Empty active projects list !!!", Toast.LENGTH_LONG)
                        .show()
                }
            }


        })

        homeViewModel.navigateToProjectDetails.observe(viewLifecycleOwner, Observer { projects ->
            projects.let {
                if (null != it) {
                    if (findNavController().currentDestination?.id == R.id.navigation_home) {

                        this.findNavController().navigate(
                            HomeFragmentDirections.actionNavigationHomeToProjectDetailsFragment(it)
                        )

                    }
                }
            }

        })
        return binding.root
    }

    override fun onStarted() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressBar.visibility = View.GONE

    }

    override fun onFailure(message: String) {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    }
}
