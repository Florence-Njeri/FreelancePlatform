package com.example.freelanceplatform.ui.search

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.freelanceplatform.R

class MakeProposalFragment : Fragment() {

    companion object {
        fun newInstance() = MakeProposalFragment()
    }

    private lateinit var viewModel: SendProposalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.make_proposal_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SendProposalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
