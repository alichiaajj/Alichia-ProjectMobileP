package com.civicpulse.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.civicpulse.app.databinding.ActivityBaseBinding
import com.civicpulse.app.home.HomeFragment
import com.civicpulse.app.community.CommunityFragment
import com.civicpulse.app.event.EventFragment
import com.civicpulse.app.help.HelpFragment
import com.civicpulse.app.profile.ProfileFragment
import com.civicpulse.app.local.LocalFragment
import com.civicpulse.app.notifications.NotificationsFragment

// Modul 7: Activity menjadi wadah Toolbar, Fragment, dan menu bawah.
class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    // Membuat tampilan utama dan memasang navigasi bawah.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Modul 6: halaman utama hanya boleh dibuka ketika status login masih aktif.
        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        if (!sharedPref.getBoolean("isLogin", false)) {
            logout()
            return
        }
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        // Contoh insets system bar dari modul 7 halaman 6.
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(androidx.core.view.WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, 0)
            insets
        }
        // Halaman awal adalah Beranda seperti contoh replaceFragment modul.
        openPage("home")
        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    openPage("home")
                    true
                }
                R.id.nav_community -> {
                    openPage("community")
                    true
                }
                R.id.nav_event -> {
                    openPage("events")
                    true
                }
                R.id.nav_help -> {
                    openPage("help")
                    true
                }
                R.id.nav_profile -> {
                    openPage("profile")
                    true
                }
                else -> false
            }
        }
    }

    // Memilih Fragment dengan percabangan when, lalu mengganti isi container.
    fun openPage(target: String) {
        val fragment: Fragment = when (target) {
            "home" -> HomeFragment()
            "community" -> CommunityFragment()
            "events" -> EventFragment()
            "help" -> HelpFragment()
            "profile" -> ProfileFragment()
            "local" -> LocalFragment()
            "notifications" -> NotificationsFragment()
            else -> return
        }
        // Judul diperbarui langsung, tanpa pemantauan lifecycle tambahan.
        supportActionBar?.title = when (target) {
            "home" -> "Civic Pulse"
            "community" -> "Komunitas"
            "events" -> "Event"
            "help" -> "Mutual Help"
            "profile" -> "Profil"
            "local" -> "Jelajah Lokal"
            else -> "Notifikasi"
        }
        val menuId = when (target) {
            "community" -> R.id.nav_community
            "events" -> R.id.nav_event
            "help" -> R.id.nav_help
            "profile" -> R.id.nav_profile
            else -> R.id.nav_home
        }
        binding.bottomNavView.menu.findItem(menuId).isChecked = true
        // Modul 7: perpindahan tab tidak ditambahkan ke back stack.
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }

    // Modul 5: mengambil item menu Toolbar dari XML.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Menangani menu informasi, notifikasi, tentang, dan logout.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_notifications -> {
                openPage("notifications")
                true
            }
            R.id.menu_info -> {
                startActivity(Intent(this, WebViewActivity::class.java))
                true
            }
            R.id.menu_about -> {
                AlertDialog.Builder(this).setTitle("Civic Pulse")
                    .setMessage("Bersama, Untuk Lingkungan Kita. Aplikasi praktikum dengan data contoh.")
                    .setPositiveButton("OK", null).show()
                true
            }
            R.id.menu_logout -> {
                confirmLogout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Modul 6: konfirmasi logout, hapus sesi, lalu kembali ke login.
    fun confirmLogout() {
        AlertDialog.Builder(this).setTitle("Logout")
            .setMessage("Apakah kamu yakin ingin keluar?")
            .setPositiveButton("Ya") { _, _ ->
                logout()
            }
            .setNegativeButton("Batal", null).show()
    }

    // Modul 6: satu fungsi untuk menghapus sesi dan membersihkan riwayat Activity.
    // Fungsi ini dipakai tombol Logout Profil dan menu Logout pada Toolbar.
    fun logout() {
        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        // Menghapus isLogin dan username; tidak hanya menutup tampilan Profil.
        sharedPref.edit().clear().apply()
        val intent = Intent(this, LoginActivity::class.java)
        // Setelah logout, tombol Back tidak bisa membuka Home yang lama.
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

}
