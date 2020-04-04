package com.example.freelanceplatform.ui.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.freelanceplatform.R
import com.example.freelanceplatform.adapter.MessagesAdapter
import com.example.freelanceplatform.adapter.ReviewsAdapter
import com.example.freelanceplatform.databinding.FragmentMessagesBinding
import com.example.freelanceplatform.databinding.FreelancerRatingFragmentBinding

class MessagesFragment : Fragment() {

    private lateinit var notificationsViewModel: MessagesViewModel
    private lateinit var binding:FragmentMessagesBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(MessagesViewModel::class.java)
        binding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_messages, container, false)
        binding.messagesList.adapter= MessagesAdapter()
        return binding.root
    }
}
