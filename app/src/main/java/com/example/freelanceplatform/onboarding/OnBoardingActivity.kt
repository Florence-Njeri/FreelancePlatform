package com.example.freelanceplatform.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.freelanceplatform.R
import com.example.freelanceplatform.adapter.OnBoardingTabsAdapter
import com.example.freelanceplatform.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {
    private var viewPagerAdapter: OnBoardingTabsAdapter? = null
    private lateinit var binding:ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_on_boarding)
        viewPagerAdapter = OnBoardingTabsAdapter(supportFragmentManager,this)

        binding.viewPager.adapter = viewPagerAdapter

        binding.circleIndicator.setViewPager(binding.viewPager)
        viewPagerAdapter!!.registerDataSetObserver( binding.circleIndicator.dataSetObserver)
    }
}
