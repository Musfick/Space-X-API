package com.foxhole.spacex.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.foxhole.spacex.R
import com.foxhole.spacex.base.BaseActivity
import com.foxhole.spacex.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun onViewReady(savedInstanceState: Bundle?) {
        super.onViewReady(savedInstanceState)
        //init bottom navigation
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupBottomNavMenu(navController)
        setupActionBarWithNavController(navController)
    }

    private fun setupActionBarWithNavController(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
        return navigationController.navigateUp()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java
}
