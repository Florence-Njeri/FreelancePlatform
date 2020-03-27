package com.example.freelanceplatform.ui.search

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.FragmentSearchBinding
import com.example.freelanceplatform.databinding.WorkDetailsFragmentBinding

class WorkDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = WorkDetailsFragment()
    }

    private lateinit var viewModel: WorkDetailsViewModel
    private lateinit var binding: WorkDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.work_details_fragment, container, false)
        binding.buttonSendProposal.setOnClickListener {
            findNavController().navigate(R.id.action_workDetailsFragment_to_sendProposalFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WorkDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
