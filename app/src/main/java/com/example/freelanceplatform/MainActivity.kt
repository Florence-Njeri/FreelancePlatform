package com.example.freelanceplatform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.freelanceplatform.adapter.OnBoardingTabsAdapter
import com.example.freelanceplatform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager? = null
    private var viewPagerAdapter: OnBoardingTabsAdapter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }
}
