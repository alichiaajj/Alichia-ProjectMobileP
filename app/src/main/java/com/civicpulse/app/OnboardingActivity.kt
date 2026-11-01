package com.civicpulse.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.civicpulse.app.databinding.ActivityOnboardingBinding

// Halaman pengenalan dari desain, memakai variabel, if/when, dan klik tombol.
class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    private var step = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Tombol lanjut menambah nomor halaman sampai halaman ketiga.
        binding.next.setOnClickListener {
            if (step < 2) {
                step = step + 1
                showPage()
            } else {
                openLogin()
            }
        }
        binding.skip.setOnClickListener { openLogin() }
        showPage()
    }

    // Mengisi halaman berdasarkan nomor; semua gambar dan teks bersifat tetap.
    private fun showPage() {
        when (step) {
            0 -> {
                binding.onboardTitle.text = "Kita Lebih Kuat\nBersama"
                binding.onboardBody.text = "Bergabung dengan komunitas, akses layanan lokal, dan jadikan lingkungan sekitar lebih baik."
                binding.onboardImage.setImageResource(R.drawable.community_hero)
                binding.dots.text = "●  ○  ○"
            }
            1 -> {
                binding.onboardTitle.text = "Kenali Sekitarmu"
                binding.onboardBody.text = "Temukan fasilitas, layanan warga, dan kegiatan menarik yang dekat dengan rumahmu."
                binding.onboardImage.setImageResource(R.drawable.neighborhood)
                binding.dots.text = "○  ●  ○"
            }
            2 -> {
                binding.onboardTitle.text = "Hal Kecil,\nDampak Besar"
                binding.onboardBody.text = "Mulai kebaikan dari sekitar kita."
                binding.onboardImage.setImageResource(R.drawable.community_hero)
                binding.dots.text = "○  ○  ●"
            }
        }
        binding.next.text = if (step == 2) "Mulai Bersama" else "Lanjut"
    }

    // Intent membuka login; finish menutup halaman pengenalan.
    private fun openLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
