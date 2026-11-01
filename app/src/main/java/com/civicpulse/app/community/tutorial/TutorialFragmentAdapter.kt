package com.civicpulse.app.community.tutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// Pola adapter pada Pertemuan 9 halaman 16 untuk mengisi ViewPager2.
class TutorialFragmentAdapter(
    activity: FragmentActivity,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(activity) {
    // Jumlah halaman mengikuti jumlah Fragment pada daftar.
    override fun getItemCount(): Int = fragments.size

    // ViewPager2 meminta Fragment berdasarkan posisi halaman.
    override fun createFragment(position: Int): Fragment = fragments[position]
}
