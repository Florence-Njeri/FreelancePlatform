package com.example.freelanceplatform

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.freelanceplatform.databinding.ActivityMainBinding
import com.example.freelanceplatform.model.Freelancer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val freelancer = Freelancer()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)        //Find NavController

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_search,
                R.id.navigation_messages,
                R.id.navigation_profile
            )
        )
//        NavigationUI.setupActionBarWithNavController(this,navController)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val isAuthenticated =sharedPreference.getBoolean("isAuthenticated",false)
        val isFirstTime =sharedPreference.getBoolean("isFirstTime",true)
            if (!isAuthenticated || isFirstTime) {
                startActivity(Intent(this, LandingPageActivity::class.java))
            }

    }

    fun showBottomNavigation() {
        binding.navView.visibility = View.VISIBLE
    }

    fun hideBottomNavigation() {
        binding.navView.visibility = View.GONE
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }


}
