package com.civicpulse.app.notifications

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
import com.civicpulse.app.databinding.FragmentNotificationsBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class NotificationsFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Pemberitahuan merupakan daftar teks contoh, bukan push notification.
        binding.simpleHeading.text = "Kabar Lingkungan"
        binding.simpleBody.text = "Informasi kegiatan Civic Pulse."
        binding.simpleAction.text = "Lihat Event"
        binding.simpleAction.setOnClickListener { (requireActivity() as BaseActivity).openPage("events") }
        val rows = listOf("Aksi Bersih Lingkungan • 31 Oktober", "Komunitas RW 04", "Informasi Bantuan Warga")
        // ArrayAdapter menampilkan satu teks di setiap baris.
        binding.simpleList.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, rows)
        binding.simpleList.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), rows[position], Toast.LENGTH_SHORT).show()
        }
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
