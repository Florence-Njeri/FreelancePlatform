package com.example.freelanceplatform.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.freelanceplatform.R
import com.example.freelanceplatform.adapter.ReviewsAdapter
import com.example.freelanceplatform.databinding.FreelancerRatingFragmentBinding

class FreelancerRatingFragment : Fragment() {

    companion object {
        fun newInstance() = FreelancerRatingFragment()
    }

    private lateinit var viewModel: FreelancerRatingViewModel
    private lateinit var binding:FreelancerRatingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.freelancer_rating_fragment, container, false)
        binding.listReviews.adapter=ReviewsAdapter()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FreelancerRatingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
