package com.example.freelanceplatform.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.freelanceplatform.R

class FreelancerRatingFragment : Fragment() {

    companion object {
        fun newInstance() = FreelancerRatingFragment()
    }

    private lateinit var viewModel: FreelancerRatingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freelancer_rating_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FreelancerRatingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
