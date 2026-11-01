package com.civicpulse.app.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.civicpulse.app.*
import com.civicpulse.app.databinding.FragmentHomeBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class HomeFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Latihan modul 7: sapaan membaca username sesi login.
        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        binding.greeting.text = "Halo, ${sharedPref.getString("username", "Pengguna")} ☀"
        val activity = requireActivity() as BaseActivity
        // Ikon Lokasi Lokal sekarang membuka Fragment Jelajah Lokal.
        binding.shortcutLocal.setOnClickListener {
            activity.openPage("local")
        }
        // Tiga ikon dashboard lainnya masih berupa tampilan.
        binding.banner.setOnClickListener { activity.openPage("community") }
        binding.seeEvents.setOnClickListener { activity.openPage("events") }
        // Pencarian belum dibuat; kartu beranda adalah layout XML tetap.
        binding.search.isEnabled = false
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
