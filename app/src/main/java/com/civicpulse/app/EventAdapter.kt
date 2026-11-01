package com.civicpulse.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.civicpulse.app.databinding.RowCardBinding

// Modul 7: adapter menghubungkan daftar data dengan layout kartu.
class EventAdapter(context: Context, private val events: List<CivicEvent>) :
    ArrayAdapter<CivicEvent>(context, 0, events) {

    // Android memanggil getView untuk membuat tampilan setiap baris.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Membuat kartu baru dengan View Binding sesuai contoh modul.
        val binding = RowCardBinding.inflate(LayoutInflater.from(context), parent, false)
        val data = events[position]
        // Mengisi isi kartu dari model pada posisi yang diminta.
        binding.cardTitle.text = data.title
        binding.cardMeta.text = "${data.date}\n${data.location}"
        binding.cardBody.text = data.description
        binding.cardTag.text = "${data.category} • ${data.price}"
        // Gambar lokal dimuat dengan Glide seperti pola modul 7.
        Glide.with(context).load(if (data.id == "garden") R.drawable.event_garden else R.drawable.community_hero).into(binding.cardImage)
        // Tombol hanya tampilan; tidak mendaftarkan pengguna.
        binding.cardAction.text = "Ikuti Event"
        binding.cardAction.isEnabled = false
        // Klik kartu hanya menampilkan informasi, tanpa mengubah data.
        binding.root.setOnClickListener {
            android.widget.Toast.makeText(context, binding.cardTitle.text, android.widget.Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}
