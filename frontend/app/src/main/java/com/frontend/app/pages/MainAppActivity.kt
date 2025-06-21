  package com.frontend.app.pages

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.frontend.app.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.frontend.app.fragments.HistoryFragment
import com.frontend.app.fragments.HomeFragment
import com.frontend.app.fragments.MenuFragment
import com.frontend.app.fragments.ProfileFragment
import com.frontend.app.fragments.OrderFragment

  class MainAppActivity : AppCompatActivity() {

      private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        setContentView(R.layout.activity_main_app)

        bottomNav = findViewById(R.id.bottomNavigationView)

        bottomNav.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_history -> HistoryFragment()
                R.id.nav_order -> OrderFragment()
                R.id.nav_menu -> MenuFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> HomeFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()

            true
        }

        bottomNav.selectedItemId = R.id.nav_home

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}