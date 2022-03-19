package com.android.starwarscatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.starwarscatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        StarWarsApp.starWarsComponent.inject(this)

        val bottomNavigation = binding.startWarsNavigationBar

        val navController = findNavController(R.id.nav_container)
        val toolBarNav = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, toolBarNav)
        bottomNavigation.setupWithNavController(navController)
    }
}