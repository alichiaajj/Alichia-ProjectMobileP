package com.civicpulse.app.community.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.civicpulse.app.R
import com.civicpulse.app.databinding.ActivityTutorialCivicBinding

// Tutorial tiga halaman dengan ViewPager2 dan DotsIndicator sesuai Pertemuan 9.
class TutorialCivicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialCivicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Binding menghubungkan Activity dengan layout tutorial.
        binding = ActivityTutorialCivicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Memberi jarak supaya konten tidak tertutup status bar atau navigasi HP.
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        // Tombol panah menutup tutorial dan kembali ke halaman asal.
        binding.toolbar.title = "Kenali Civic Pulse"
        binding.toolbar.setNavigationIcon(R.drawable.ic_back)
        binding.toolbar.setNavigationOnClickListener { finish() }
        // Tiga Fragment menjadi isi halaman yang dapat digeser kiri dan kanan.
        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialViewPager.adapter = adapter
        // attachTo dipanggil setelah adapter dipasang, mengikuti urutan praktikum.
        binding.dotIndicator.attachTo(binding.tutorialViewPager)
        // Tombol ini hanya menutup tutorial, tanpa mendaftarkan aktivitas warga.
        binding.closeTutorial.setOnClickListener { finish() }
    }
}
