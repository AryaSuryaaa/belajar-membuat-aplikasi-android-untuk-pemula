package com.surya.projectakhir

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.surya.projectakhir.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnMyEmail: Button = findViewById(R.id.btn_my_email)
        btnMyEmail.setOnClickListener(this)

        val btnMyInsta: Button = findViewById(R.id.btn_my_insta)
        btnMyInsta.setOnClickListener(this)

        val btnMyGithub: Button = findViewById(R.id.btn_my_github)
        btnMyGithub.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_my_email -> {
                val recipient = "suryasaputra914@gmail.com"

                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
                }

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
            R.id.btn_my_insta -> {
                val uri = Uri.parse("https://www.instagram.com/aryasuryaa__/")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            R.id.btn_my_github -> {
                val uri = Uri.parse("https://github.com/AryaSuryaaa")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
    }
}