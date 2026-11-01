package com.civicpulse.app.local

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.chip.Chip
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.civicpulse.app.*
import com.civicpulse.app.databinding.FragmentLocalBinding

// Modul 7: halaman menggunakan Fragment dan View Binding.
class LocalFragment : Fragment() {
    // Binding hanya digunakan selama tampilan Fragment tersedia.
    private var _binding: FragmentLocalBinding? = null
    private val binding get() = _binding!!

    // Membuat layout halaman dan mengembalikan tampilan utamanya.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLocalBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Mengisi data dan memasang klik setelah tampilan selesai dibuat.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ListView dan Custom Adapter dari Pertemuan 7 tetap digunakan.
        showItems("Semua")
        binding.list.emptyView = binding.empty
        binding.search.isEnabled = false
        // Pertemuan 9: ambil chip terpilih, tampilkan Toast, lalu perbarui daftar.
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(requireContext(), "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                showItems(chip.text.toString())
            }
        }
    }

    // Perulangan dan if memilih data yang cocok dengan kategori chip.
    private fun showItems(category: String) {
        val items = ArrayList<LocalPlace>()
        for (item in placeList) {
            if (category == "Semua" || item.category == category) {
                items.add(item)
            }
        }
        // Membuat adapter baru dari hasil pilihan; tidak mengubah data contoh.
        binding.list.adapter = PlaceAdapter(requireContext(), items)
        binding.resultCount.text = "${items.size} lokasi • RW 04"
    }

    // Modul 7: melepas binding ketika tampilan Fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
