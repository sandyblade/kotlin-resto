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

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_home -> {
                    val fragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment, "Home")
                        .commit()
                    fragment.loadData() // ✅ Call function after switching
                    true
                }

                R.id.nav_history -> {
                    val fragment = HistoryFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment, "History")
                        .commit()
                    fragment.loadData()
                    true
                }

                R.id.nav_menu -> {
                    val fragment = MenuFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment, "Menu")
                        .commit()
                    fragment.loadData()
                    true
                }

                R.id.nav_order -> {
                    val fragment = OrderFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment, "Order")
                        .commit()
                    fragment.loadData()
                    true
                }

                R.id.nav_profile -> {
                    val fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment, "Profile")
                        .commit()
                    true
                }

                else -> false
            }
        }

        bottomNav.selectedItemId = R.id.nav_home

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}