# Pathz

**Pathz** adalah aplikasi Android untuk mengompresi video menggunakan pemrosesan berbasis hardware encoder. Aplikasi ini ditulis dengan Kotlin dan Jetpack Compose.

- **Nama aplikasi:** Pathz
- **Application ID:** `com.pathz.terryzen`
- **Versi:** `1.0.0` (`versionCode` 100)
- **Minimum Android:** Android 7.0 (API 24)
- **Target SDK:** API 37
- **Lisensi:** MIT — lihat [`LICENSE`](LICENSE)

## 🔥 Fitur v1.0.0

Berdasarkan implementasi yang tersedia di source code:

- Memilih video dari perangkat.
- Membaca metadata video dan menghitung estimasi hasil kompresi.
- Memilih resolusi target: 720p, 1080p, 1440p, atau 4K.
- Memilih codec H.265 (HEVC) atau H.264 (AVC), mengikuti dukungan hardware perangkat.
- Mengatur pemotongan awal dan akhir video (trim).
- Memilih untuk menghapus audio dari hasil video.
- Menampilkan progres dan estimasi waktu kompresi melalui notifikasi foreground service.
- Membatalkan proses kompresi.
- Menyimpan hasil video ke folder publik `Movies/Pathz`.

> Hasil dan pilihan codec yang tersedia dapat bergantung pada kemampuan encoder dan perangkat Android yang digunakan.

## 🛠 Tech Stack & Library

* **Language:** Kotlin
* **Minimum SDK:** API 24 (Android 7.0)
* **Target SDK:** API 37
* **UI Framework:** Jetpack Compose (Material Design 3)
* **Video Engine:** AndroidX Media3 Transformer & Effect (ClippingConfiguration untuk trimming)
* **Concurrency:** Kotlin Coroutines & StateFlow
* **Background Task:** Android Foreground Services
* **Storage:** MediaStore API (Scoped Storage Compatible)

## Struktur proyek

```text
Pathz/
├── app/
│   ├── src/main/
│   │   ├── java/com/pathz/terryzen/
│   │   │   ├── ui/
│   │   │   │   ├── components/
│   │   │   │   ├── screens/
│   │   │   │   └── theme/
│   │   │   ├── MainActivity.kt
│   │   │   ├── VideoAnalyzer.kt
│   │   │   ├── VideoCompressorService.kt
│   │   │   ├── VideoTranscoder.kt
│   │   │   └── CompressorState.kt
│   │   └── res/
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── LICENSE
└── README.md
```

## Persyaratan build

- JDK 11 atau versi JDK yang diwajibkan oleh versi Android Gradle Plugin yang digunakan.
- Android SDK dan Android SDK Build Tools yang sesuai.
- Koneksi internet pada build pertama untuk mengunduh Gradle dan dependency.
- Perangkat/emulator Android API 24 atau lebih baru untuk menjalankan aplikasi.

Versi plugin dan dependency didefinisikan di `gradle/libs.versions.toml` serta file Gradle proyek. Gunakan versi Gradle/JDK yang kompatibel dengan Android Gradle Plugin pada proyek ini.

## Build APK

### Linux / macOS

Dari direktori utama proyek:

```bash
chmod +x gradlew
./gradlew assembleDebug
```

### Windows

```bat
gradlew.bat assembleDebug
```

APK debug akan dibuat di:

```text
app/build/outputs/apk/debug/app-debug.apk
```

Untuk membuat APK release:

```bash
./gradlew assembleRelease
```

atau di Windows:

```bat
gradlew.bat assembleRelease
```

APK release berada di:

```text
app/build/outputs/apk/release/app-release.apk
```

**Catatan:** konfigurasi release pada proyek ini menggunakan debug signing config. Untuk distribusi publik, buat dan gunakan signing key milik sendiri, simpan keystore serta password secara aman, lalu konfigurasi signing release sebelum membagikan APK.

## Menjalankan tes

```bash
./gradlew test
```

Untuk Windows:

```bat
gradlew.bat test
```

## Penyimpanan hasil

Video yang berhasil diproses disimpan melalui Android MediaStore pada:

```text
Movies/Pathz/
```

Akses media dan notifikasi mengikuti mekanisme izin Android sesuai versi sistem operasi.

## Catatan dan batasan

- Kecepatan, kualitas, ukuran akhir, dan ketersediaan codec dipengaruhi oleh perangkat, video sumber, serta dukungan hardware encoder.
- Estimasi ukuran merupakan perkiraan; ukuran hasil sebenarnya dapat berbeda.
- Proyek ini tidak menyertakan jaminan bahwa setiap kombinasi resolusi dan codec tersedia di semua perangkat.
- Pastikan memiliki hak atau izin untuk memproses video yang dipilih.

## Kontribusi

Perubahan kode dapat diajukan melalui branch atau pull request. Sertakan ringkasan perubahan dan langkah pengujian agar mudah ditinjau.

## Lisensi

Pathz didistribusikan berdasarkan MIT License. Lihat file [`LICENSE`](LICENSE) untuk teks lisensi lengkap.
