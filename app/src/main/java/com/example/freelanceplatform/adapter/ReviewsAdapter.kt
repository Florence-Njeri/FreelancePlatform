package com.example.freelanceplatform.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.freelanceplatform.R
import de.hdodenhof.circleimageview.CircleImageView


class ReviewsAdapter(/*var list: ArrayList<LatestNewsEvents>*/) : RecyclerView.Adapter<ReviewsAdapter.LatestEventsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestEventsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return LatestEventsViewHolder(inflater,parent)

    }

    override fun getItemCount()=5

    override fun onBindViewHolder(holder: LatestEventsViewHolder, position: Int) {
//        val news: LatestNewsEvents= list[position]
        //On click navigate
//        holder.itemView.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.action_friendsFragment_to_unfollowFriendFragment)
//        )

        holder.bind(/*news*/)
    }



    class LatestEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.rating_item, parent, false)) {
        private var mName: TextView? = null
        private var mReview: TextView? = null
        private var mDate: TextView? = null


        init {
            mName = itemView.findViewById(R.id.reviewerName)
            mReview= itemView.findViewById(R.id.review)
            mDate= itemView.findViewById(R.id.dateOfReview)

        }

        fun bind(/*news:LatestNewsEvents*/) {
//            mNewsTitle?.text = news.title
//            mNewsSubTitle?.text = news.subTitle

            mName?.text ="Florence Njeri"
            mReview?.text ="Working with Alex is always a pleasure!\n" +
                    "He has limitless capabilities!"
            mDate?.text="17/03/2020"

        }

    }


}