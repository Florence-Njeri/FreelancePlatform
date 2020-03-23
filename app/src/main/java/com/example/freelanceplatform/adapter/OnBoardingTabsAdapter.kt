package com.example.freelanceplatform.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.freelanceplatform.auth.SignUpFragment
import com.example.freelanceplatform.onboarding.*


class OnBoardingTabsAdapter(fm: FragmentManager, private val context: FragmentActivity?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
      return when (position) {
            0 -> SlideOneFragment()
            1 -> SlideTwoFragment()
            2 -> SlideThreeFragment()
            3 -> SlideFourFragment()
            4 -> SlideFiveFragment()

            else -> SignUpFragment()
        }
//


    }
    /*
    Returns the number of pages the adapter will create
     */

    override fun getCount(): Int {
        return 6
    }


}
