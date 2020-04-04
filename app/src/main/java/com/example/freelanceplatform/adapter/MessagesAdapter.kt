package com.example.freelanceplatform.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.freelanceplatform.R
import de.hdodenhof.circleimageview.CircleImageView


class MessagesAdapter(/*var list: ArrayList<LatestNewsEvents>*/) : RecyclerView.Adapter<MessagesAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)

    }

    override fun getItemCount()=7

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
//        val news: LatestNewsEvents= list[position]
        //On click navigate
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_navigation_messages_to_navigation_profile)
        )

        holder.bind(/*news*/)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.message_item, parent, false)) {
        private var mName: TextView? = null
        private var mDescription: TextView? = null


        init {
            mName = itemView.findViewById(R.id.name)
            mDescription= itemView.findViewById(R.id.description)

        }

        fun bind(/*news:LatestNewsEvents*/) {


            mName?.text ="Florence Njeri"
            mDescription?.text ="Working with Alex is always a pleasure!\n" +
                    "He has limitless capabilities!"

        }

    }


}