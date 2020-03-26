package com.example.freelanceplatform.ui.home

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.freelanceplatform.MainActivity

import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.ActiveProjetsDetailsFragmentBinding

class ActiveProjetsDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ActiveProjetsDetailsFragment()
    }

    private lateinit var viewModel: ActiveProjetsDetailsViewModel
    private lateinit var binding:ActiveProjetsDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.active_projets_details_fragment, container, false)

        binding.dropDownProjects.setOnClickListener {
            binding.imageViewChart.visibility=View.VISIBLE
            binding.dropDownProjects.setImageResource(R.drawable.dropdown_icon_up)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ActiveProjetsDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).hideBottomNavigation()
    }

    override fun onDetach() {
        (activity as MainActivity).showBottomNavigation()
        super.onDetach()
    }

}
