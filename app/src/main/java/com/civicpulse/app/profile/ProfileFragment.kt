package com.civicpulse.app.profile

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
import com.civicpulse.app.databinding.FragmentProfileBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class ProfileFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Modul 6 dan latihan modul 7: membaca username dari SharedPreferences.
        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Pengguna")
        binding.simpleHeading.text = username
        binding.simpleBody.text = "Warga RW 04 • Lingkungan Harapan"
        // Edit profil belum dibuat; tombol dipertahankan untuk desain.
        binding.simpleAction.text = "Edit Nama"
        binding.simpleAction.isEnabled = false
        // Logout langsung menghapus sesi dan membuka Login tanpa dialog tambahan.
        binding.btnLogout.setOnClickListener {
            (requireActivity() as BaseActivity).logout()
        }
        // Modul 7: ArrayAdapter memakai layout bawaan dengan satu teks.
        val rows = listOf("Event", "Bantuan Warga", "Komunitas", "Panduan Lingkungan")
        binding.simpleList.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, rows)
        binding.simpleList.setOnItemClickListener { _, _, position, _ ->
            val activity = requireActivity() as BaseActivity
            when (position) {
                0 -> activity.openPage("events")
                1 -> activity.openPage("help")
                2 -> activity.openPage("community")
                3 -> startActivity(Intent(requireContext(), WebViewActivity::class.java))
            }
        }
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
