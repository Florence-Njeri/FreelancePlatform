package com.example.freelanceplatform.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.ProjectDetailsFragmentBinding

class ProjectDetailsFragment : Fragment() {
private lateinit var binding:ProjectDetailsFragmentBinding
    companion object {
        fun newInstance() = ProjectDetailsFragment()
    }

    private lateinit var viewModel: ProjectDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.project_details_fragment, container, false)
        binding.buttonSendWork.setOnClickListener {
            //navigate
            findNavController().navigate(R.id.action_projectDetailsFragment_to_sendWorkFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProjectDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
