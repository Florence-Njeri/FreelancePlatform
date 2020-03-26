package com.example.freelanceplatform.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.freelanceplatform.R

class ProjectDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ProjectDetailsFragment()
    }

    private lateinit var viewModel: ProjectDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.project_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProjectDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
