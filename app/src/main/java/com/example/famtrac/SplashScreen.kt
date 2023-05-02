package com.example.famtrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.d4d5.myfamily.PrefConstants
import com.d4d5.myfamily.SharedPref


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isUserLoggedIn = SharedPref.getBoolean(PrefConstants.IS_USER_LOGGED_IN)

        if (isUserLoggedIn) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}