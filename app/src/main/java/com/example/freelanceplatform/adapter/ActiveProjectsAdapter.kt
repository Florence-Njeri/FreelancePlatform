package com.example.freelanceplatform.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.freelanceplatform.R
import com.example.freelanceplatform.model.ActiveProjects


class ActiveProjectsAdapter(var list: ArrayList<ActiveProjects>) : RecyclerView.Adapter<ActiveProjectsAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)

    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
        val activeProjects: ActiveProjects= list[position]
        //On click navigate
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_projectDetailsFragment)
        )

        holder.bind(activeProjects)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.active_projects_item, parent, false)) {
        private var mName: TextView? = null
        private var mStatus: TextView? = null


        init {
            mName = itemView.findViewById(R.id.name)
            mStatus= itemView.findViewById(R.id.projectStatus)

        }

        fun bind(activeProjects:ActiveProjects) {

            mName?.text =activeProjects.name
            mStatus?.text =activeProjects.status

        }

    }


}