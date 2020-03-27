package com.example.freelanceplatform.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.freelanceplatform.R
import de.hdodenhof.circleimageview.CircleImageView


class ActiveProjectsAdapter(/*var list: ArrayList<LatestNewsEvents>*/) : RecyclerView.Adapter<ActiveProjectsAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)

    }

    override fun getItemCount()=2

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
//        val news: LatestNewsEvents= list[position]
        //On click navigate
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_projectDetailsFragment)
        )

        holder.bind(/*news*/)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.active_projects_item, parent, false)) {
        private var mName: TextView? = null
        private var mStatus: TextView? = null


        init {
            mName = itemView.findViewById(R.id.name)
            mStatus= itemView.findViewById(R.id.projectStatus)

        }

        fun bind(/*news:LatestNewsEvents*/) {
//            mNewsTitle?.text = news.title
//            mNewsSubTitle?.text = news.subTitle

            mName?.text ="Florence Njeri"
            mStatus?.text ="Active"

        }

    }


}