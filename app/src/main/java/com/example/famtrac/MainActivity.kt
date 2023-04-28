package com.example.famtrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)

        bottomBar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.nav_guard -> {
                    inflatefragment(GuardFragment.newInstance())
                }
                R.id.nav_home -> {
                    inflatefragment(HomeFragment.newInstance())
                }
                R.id.nav_profile -> {
                    inflatefragment(ProfileFragment.newInstance())
                }
                R.id.nav_dashboard -> {
                    inflatefragment(DashboardFragment.newInstance())
                }
            }
            

            true

        }

    }


    private fun inflatefragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()
    }

}