package com.civicpulse.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.civicpulse.app.databinding.RowCardBinding

// Modul 7: adapter menghubungkan daftar data dengan layout kartu.
class HelpAdapter(context: Context, private val posts: List<HelpPost>) :
    ArrayAdapter<HelpPost>(context, 0, posts) {

    // Android memanggil getView untuk membuat tampilan setiap baris.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Membuat kartu baru dengan View Binding sesuai contoh modul.
        val binding = RowCardBinding.inflate(LayoutInflater.from(context), parent, false)
        val data = posts[position]
        // Mengisi isi kartu dari model pada posisi yang diminta.
        binding.cardImage.visibility = View.GONE
        binding.cardTitle.text = data.title
        binding.cardMeta.text = "${data.user} • ${data.time}"
        binding.cardBody.text = data.description
        binding.cardTag.text = data.kind
        // Belum ada fitur membantu atau menghubungi warga.
        binding.cardAction.text = "Bantu Warga"
        binding.cardAction.isEnabled = false
        // Klik kartu hanya menampilkan informasi, tanpa mengubah data.
        binding.root.setOnClickListener {
            android.widget.Toast.makeText(context, binding.cardTitle.text, android.widget.Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}
