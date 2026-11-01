package com.civicpulse.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.civicpulse.app.databinding.ActivitySplashScreenBinding

// Modul 6: splash menunggu sebentar, kemudian memeriksa sesi login.
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Coroutine dan delay mengikuti contoh splash di modul 6.
        lifecycleScope.launch {
            delay(2000)
            val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)
            val target = if (isLogin) BaseActivity::class.java else OnboardingActivity::class.java
            startActivity(Intent(this@SplashScreenActivity, target))
            finish()
        }
    }
}
