package com.example.freelanceplatform.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var dashboardViewModel: SearchViewModel
private lateinit var binding:FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(SearchViewModel::class.java)
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_search, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        binding.workItem.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_workDetailsFragment)
        }
        return binding.root
    }
}
