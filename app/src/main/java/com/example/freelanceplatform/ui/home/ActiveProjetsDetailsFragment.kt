package com.example.freelanceplatform.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.freelanceplatform.R

class ActiveProjetsDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ActiveProjetsDetailsFragment()
    }

    private lateinit var viewModel: ActiveProjetsDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.active_projets_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ActiveProjetsDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
