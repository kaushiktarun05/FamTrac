package com.example.famtrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)

        bottomBar.setOnItemSelectedListener {

            if(it.itemId==R.id.nav_guard){
                inflatefragment()
            }

            true

        }

    }

    private fun inflatefragment() {
       val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, GuardFragment.newInstance())
        transaction.commit()
    }
}