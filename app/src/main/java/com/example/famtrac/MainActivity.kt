package com.example.famtrac

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    val permissionCode = 69

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        askForPermission()

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
                    inflatefragment(MapsFragment())
                }
            }
            

            true

        }

    }

    private fun askForPermission() {
        ActivityCompat.requestPermissions(this, permissions, permissionCode)
    }


    private fun inflatefragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()
    }

    private fun allPermissionGranted(): Boolean {
          for(item in permissions){
              if(ContextCompat.checkSelfPermission(this,item) != PackageManager.PERMISSION_GRANTED){
                  return false
              }

          }
          return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == permissionCode) {

            if (allPermissionGranted()) {
                //openCamera()

                setUpLocationListener()
            } else {

            }

        }
    }

    private fun setUpLocationListener() {

    }

}