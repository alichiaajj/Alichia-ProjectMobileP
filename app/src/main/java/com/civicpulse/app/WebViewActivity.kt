package com.civicpulse.app

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.civicpulse.app.databinding.ActivityWebViewBinding

// Modul 5: menampilkan panduan HTML dalam WebView dan memakai Toolbar.
class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Toolbar menampilkan judul dan tombol kembali.
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Panduan Lingkungan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // WebViewClient membuat halaman dibuka di dalam aplikasi.
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("file:///android_asset/panduan.html")
    }

    // Tombol panah menutup Activity panduan dan kembali ke halaman sebelumnya.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            finish()
            true
        } else super.onOptionsItemSelected(item)
    }
}
