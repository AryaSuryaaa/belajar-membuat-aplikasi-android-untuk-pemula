package com.aryasurya.sushifushion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menunda tampilan activity utama dengan handler
        Handler().postDelayed({
            // Intentkan atau pindahkan ke activity utama setelah jangka waktu tertentu
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity splash screen agar tidak dapat kembali ke sana
        }, SPLASH_TIME_OUT.toLong())
    }
}