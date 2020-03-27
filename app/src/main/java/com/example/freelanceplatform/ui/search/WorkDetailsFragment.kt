package com.example.freelanceplatform.ui.search

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.freelanceplatform.R

class WorkDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = WorkDetailsFragment()
    }

    private lateinit var viewModel: WorkDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.work_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WorkDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
