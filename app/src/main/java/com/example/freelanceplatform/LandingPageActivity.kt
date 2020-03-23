package com.example.freelanceplatform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.freelanceplatform.databinding.ActivityLandingPageBinding
import com.example.freelanceplatform.onboarding.OnBoardingActivity

class LandingPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing_page)

        //Navigate to OnBoardingScreens
        binding.discoverButton.setOnClickListener {
            startActivity(Intent(this, OnBoardingActivity::class.java))
        }
    }
}
