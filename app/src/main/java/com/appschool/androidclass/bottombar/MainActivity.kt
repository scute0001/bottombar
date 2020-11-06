package com.appschool.androidclass.bottombar

import android.app.Fragment
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        Log.i("check", "M onCreate")
        Log.i("ABC", "M onCreate")
        Log.i("OrderList", "M onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.i("check", "M onStart")
        Log.i("emil", "M onStart")
    }



    override fun onResume() {
        super.onResume()
        Log.i("check", "M onResume")
        Log.i("emil3", "M onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("check", "M onStop")
        Log.i("check", "M onStop")
    }



    override fun onPause() {
        super.onPause()
        Log.i("check", "M onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("check", "M onDestroy")
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        Log.i("check", "M onAttachFragment")
    }
}