package com.example.famtrac
import android.app.Application

class FamTracApplication:Application() {

    override fun onCreate() {
        
        super.onCreate()

        SharedPref.init(this)
    }
}
