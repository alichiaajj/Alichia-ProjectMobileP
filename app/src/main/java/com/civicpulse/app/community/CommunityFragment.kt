package com.civicpulse.app.community

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.civicpulse.app.community.tutorial.TutorialCivicActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.civicpulse.app.*
import com.civicpulse.app.databinding.FragmentCommunityBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class CommunityFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Pertemuan 9: tombol info di Toolbar membuka Tutorial Screen.
        // Menu terikat pada viewLifecycleOwner dan hilang setelah pindah tab.
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.community_toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_tutorial -> {
                        startActivity(Intent(requireContext(), TutorialCivicActivity::class.java))
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        // Informasi komunitas adalah data contoh yang tidak berubah.
        binding.simpleHeading.text = "Komunitas RW 04"
        binding.simpleBody.text = "123 anggota • Lingkungan Harapan\n\nBerbagi informasi, agenda kegiatan, dan saling membantu antarwarga."
        binding.simpleAction.text = "Gabung Komunitas"
        binding.simpleAction.isEnabled = false
        // Modul 7: SimpleAdapter memasangkan judul dan deskripsi ke dua TextView.
        val rows = listOf(
            mapOf("title" to "Diskusi Warga", "desc" to "Kabar lingkungan RW 04"),
            mapOf("title" to "Agenda Kegiatan", "desc" to "Informasi event komunitas"),
            mapOf("title" to "Bantuan Antarwarga", "desc" to "Informasi kebutuhan warga"),
            mapOf("title" to "Fasilitas Sekitar", "desc" to "Lokasi layanan lokal"),
            mapOf("title" to "Kerja Bakti", "desc" to "Jadwal kebersihan lingkungan"),
            mapOf("title" to "Keamanan", "desc" to "Informasi ronda malam"),
            mapOf("title" to "Bank Sampah", "desc" to "Informasi pemilahan sampah"),
            mapOf("title" to "Pengumuman RW", "desc" to "Pengumuman untuk warga")
        )
        binding.simpleList.adapter = SimpleAdapter(requireContext(), rows,
            android.R.layout.simple_list_item_2, arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2))
        // Klik hanya memperlihatkan judul melalui Toast seperti modul.
        binding.simpleList.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), rows[position]["title"], Toast.LENGTH_SHORT).show()
        }
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
