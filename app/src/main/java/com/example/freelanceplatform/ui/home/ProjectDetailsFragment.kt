package com.example.freelanceplatform.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.ProjectDetailsFragmentBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class ProjectDetailsFragment : Fragment() {
private lateinit var binding:ProjectDetailsFragmentBinding
    companion object {
        fun newInstance() = ProjectDetailsFragment()
    }

    private lateinit var viewModel: ProjectDetailsViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application= requireNotNull(activity).application

        binding=DataBindingUtil.inflate(inflater,R.layout.project_details_fragment, container, false)

        var projectProperty = arguments?.let { ProjectDetailsFragmentArgs.fromBundle(requireArguments()).projectDetails }

        /**
         * Get the ViewModelFactory
         */
        val viewModelFactory = projectProperty?.let { DetailsViewModelFactory(it,application) }
        binding.viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProjectDetailsViewModel::class.java)
        //Current date
        val current = LocalDate.now()

//        val millionSeconds = projectProperty?.timePosted?.toDate() - Calendar.getInstance().timeInMillis

        val timePosted: Date = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(projectProperty?.timePosted?.toDate().toString())
        val today = Date()
        val diff = today.time - timePosted.time
        val numOfDays = (diff / (1000 * 60 * 60 * 24)).toInt()


        binding.name.text=projectProperty?.name
        binding.time.text=  String.format("%s %s %s", "Posted ", numOfDays.toString(), " days ago")
        binding.projectTitle.text= projectProperty?.projectTitle
        binding.projectDetails.text= projectProperty?.projectDescription
        binding.cost.text=  String.format("%s %s", "$", projectProperty?.cost)
        binding.title.text= projectProperty?.projectTitle
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
