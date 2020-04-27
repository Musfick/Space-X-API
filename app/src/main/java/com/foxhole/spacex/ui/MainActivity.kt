package com.foxhole.spacex.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.foxhole.spacex.R
import com.foxhole.spacex.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(R.layout.activity_main) {


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
        bottomNav_view.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
        return navigationController.navigateUp()
    }
}
