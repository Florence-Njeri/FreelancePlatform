package com.example.freelanceplatform.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.ActiveProjectsItemBinding
import com.example.freelanceplatform.model.ActiveProjects


class ActiveProjectsAdapter(val clickListener: ClickListener) :
    ListAdapter<ActiveProjects, RecyclerView.ViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(ActiveProjectsItemBinding.inflate(inflater))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LatestEventsViewHolder -> {
                val activeProjects: ActiveProjects = getItem(position)
                //On click navigate

                holder.itemView.setOnClickListener {
                    clickListener.onClick(activeProjects)
                }
                holder.bind(activeProjects, clickListener)
            }
        }
    }


    class LatestEventsViewHolder(private var binding: ActiveProjectsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var mName: TextView? = null
        private var mStatus: TextView? = null


        init {
            mName = itemView.findViewById(R.id.name)
            mStatus = itemView.findViewById(R.id.projectStatus)

        }

        fun bind(activeProjects: ActiveProjects, clickListener: ClickListener) {
            binding.activeProjectItem = activeProjects
            binding.clickListener=clickListener
            mName?.text = activeProjects.name
            mStatus?.text = activeProjects.status

        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<ActiveProjects>() {

        override fun areItemsTheSame(oldItem: ActiveProjects, newItem: ActiveProjects): Boolean {
            return oldItem.timePosted == newItem.timePosted
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: ActiveProjects, newItem: ActiveProjects): Boolean {
            return oldItem == newItem
        }
    }

}

class ClickListener(val clickListener: (projects: ActiveProjects) -> Unit) {
    fun onClick(projects: ActiveProjects) = clickListener(projects)

}