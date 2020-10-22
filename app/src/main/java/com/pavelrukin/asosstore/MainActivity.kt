package com.pavelrukin.asosstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navController = findNavController(R.id.nav_host_fragment)
        actionBarController()

    }
    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            menu.clear()
            when(destination.id){
                R.id.mainFragment -> menuInflater.inflate(R.menu.menu_item, menu)
                R.id.detailFragment -> menuInflater.inflate(R.menu.menu_item,menu)
                else -> menuInflater.inflate(R.menu.menu_item,menu)
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
    private fun actionBarController() {

            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.basketFragment -> supportActionBar?.hide()
                    else -> supportActionBar?.show()
                }
            }

    }
}