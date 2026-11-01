package com.civicpulse.app.community.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.civicpulse.app.R

// Pertemuan 9: satu Fragment menampilkan satu halaman tutorial.
class Tutorial1Fragment : Fragment() {
    // Layout halaman berisi gambar, judul, dan penjelasan Civic Pulse.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_tutorial1, container, false)
    }
}
