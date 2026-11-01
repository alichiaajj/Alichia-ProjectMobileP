package com.civicpulse.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.civicpulse.app.databinding.ActivityLoginBinding

// Modul 6: login latihan dengan username dan password yang sama.
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Binding menghubungkan layout XML dengan kode Kotlin.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            // Membaca teks yang diisi pada kedua EditText.
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                // Dialog memberi tahu bahwa kolom wajib diisi.
                AlertDialog.Builder(this).setTitle("Login Gagal")
                    .setMessage("Username dan password wajib diisi.")
                    .setPositiveButton("OK", null).show()
            } else if (username == password) {
                // SharedPreferences hanya menyimpan status login dan username.
                val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()
                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            } else {
                AlertDialog.Builder(this).setTitle("Login Gagal")
                    .setMessage("Username dan password harus sama. Contoh: chia / chia.")
                    .setPositiveButton("OK", null).show()
            }
        }
    }
}
