package com.civicpulse.app

// Data contoh untuk ditampilkan pada halaman.
// Model data kegiatan komunitas.
// Modul 7: data class menjadi wadah data satu kartu.
data class CivicEvent(
    val id: String,          // Kode pengenal event.
    val title: String,       // Nama kegiatan.
    val date: String,        // Tanggal dan waktu dalam bentuk teks.
    val location: String,   // Nama lokasi kegiatan.
    val category: String,   // Kategori, misalnya Lingkungan atau Edukasi.
    val price: String,      // Harga dalam bentuk teks, misalnya Gratis.
    val description: String // Penjelasan kegiatan.
)

// Model data permintaan atau penawaran bantuan.
data class HelpPost(
    val id: String,          // Kode pengenal postingan.
    val user: String,        // Nama pembuat postingan.
    val title: String,       // Judul bantuan.
    val description: String,// Penjelasan kebutuhan atau penawaran.
    val kind: String,        // Jenis: Membutuhkan atau Menawarkan.
    val time: String         // Keterangan waktu dalam bentuk teks.
)

// Model data fasilitas atau tempat di lingkungan sekitar.
data class LocalPlace(
    val name: String,        // Nama tempat.
    val category: String,    // Kategori fasilitas.
    val distance: String,    // Jarak contoh dalam bentuk teks.
    val hours: String,       // Jam operasional.
    val address: String     // Alamat tempat.
)

// Daftar event contoh untuk Beranda dan halaman Event.
val eventList = listOf(
    CivicEvent(
        "clean",
        "Aksi Bersih Lingkungan",
        "Sab, 31 Okt 2026 • 07.00–10.00",
        "Taman Kota Harapan",
        "Lingkungan",
        "Gratis",
        "Bersama warga RW 04 membersihkan taman dan memilah sampah. Bawa botol minum serta sarung tangan."
    ),

    CivicEvent(
        "garden",
        "Workshop Urban Farming",
        "Min, 1 Nov 2026 • 09.00–12.00",
        "Balai RW 04",
        "Edukasi",
        "Rp25.000",
        "Belajar menanam sayuran di lahan sempit. Biaya contoh mencakup bibit dan media tanam; tidak ada pembayaran di aplikasi."
    ),

    CivicEvent(
        "market",
        "Pasar UMKM Warga",
        "Sab, 7 Nov 2026 • 08.00–15.00",
        "Lapangan RW 04",
        "Ekonomi",
        "Gratis",
        "Kenali produk dan kuliner buatan tetangga. Terbuka untuk seluruh warga."
    ),

    CivicEvent(
        "trees",
        "Menanam untuk Esok",
        "Min, 18 Okt 2026 • 07.00–10.00",
        "Kebun Komunitas",
        "Lingkungan",
        "Gratis",
        "Kegiatan penanaman pohon telah selesai. Terima kasih kepada seluruh relawan."
    )
)

// Daftar fasilitas contoh untuk halaman Jelajah Lokal.
val placeList = listOf(
    LocalPlace(
        "Puskesmas Kecamatan",
        "Kesehatan",
        "1,2 km",
        "08.00–16.00",
        "Jl. Sehat No. 8"
    ),

    LocalPlace(
        "Toko Sembako Makmur",
        "Toko & Kuliner",
        "0,6 km",
        "07.00–21.00",
        "Jl. Melati No. 12"
    ),

    LocalPlace(
        "Taman Kota Harapan",
        "Fasilitas Umum",
        "0,8 km",
        "06.00–22.00",
        "Jl. Harapan Raya"
    ),

    LocalPlace(
        "Balai RW 04",
        "Fasilitas Umum",
        "0,3 km",
        "08.00–17.00",
        "Jl. Melati No. 4"
    )
)

// Daftar postingan bantuan contoh.
// Semua postingan tetap; belum ada fitur menambah bantuan.
val helpList = listOf(
    HelpPost(
        "h1",
        "Budi Santoso",
        "Butuh bantuan angkat barang",
        "Pindahan rumah di Jl. Melati No. 12. Membutuhkan dua orang untuk memindahkan lemari pada Sabtu pagi.",
        "Membutuhkan",
        "2 jam lalu"
    ),

    HelpPost(
        "h2",
        "Siti Nurhaliza",
        "Mencari tutor matematika",
        "Mencari pendamping belajar matematika untuk anak SD kelas 4, dua kali seminggu di lingkungan RW 04.",
        "Membutuhkan",
        "4 jam lalu"
    ),

    HelpPost(
        "h3",
        "Andi Pratama",
        "Bantu jaga rumah sementara",
        "Saya bisa membantu menyiram tanaman dan mengecek rumah tetangga selama bepergian, maksimal tiga hari.",
        "Menawarkan",
        "5 jam lalu"
    )
)
