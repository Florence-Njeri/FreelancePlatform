package com.example.freelanceplatform

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.freelanceplatform.auth.LogInActivity
import com.example.freelanceplatform.auth.LogInFragment
import com.example.freelanceplatform.databinding.ActivityLandingPageBinding
import com.example.freelanceplatform.onboarding.OnBoardingActivity


class LandingPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,  com.example.freelanceplatform.R.layout.activity_landing_page)

        //Navigate to OnBoardingScreens
        binding.discoverButton.setOnClickListener {
            startActivity(Intent(this, OnBoardingActivity::class.java))

        }

        setSpannableText()

    }

    private fun setSpannableText() {
        val spannableText = SpannableString("You have an account ? Log-in")
        val clickableSpan = object : ClickableSpan() {

            override fun onClick(widget: View) {
                startActivity(Intent(this@LandingPageActivity,LogInActivity::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color =
                    ContextCompat.getColor(applicationContext,  com.example.freelanceplatform.R.color.purpleColor)
                ds.isUnderlineText = false

            }
        }

        spannableText.setSpan(clickableSpan, 22, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textViewLogIn.text = spannableText
        binding.textViewLogIn.movementMethod = LinkMovementMethod.getInstance()

    }
}
