package com.aryasurya.sushifushion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.aryasurya.sushifushion.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        private val TAG = "Detail Activity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Sushis>("DATA")
        val getName = data?.name
        val getPrice = data?.price
        val getPhoto = data?.photo
        val getDescription = data?.deskripsi

        binding.tvDetailSushiName.text = getName
//        if (getPhoto != null) {
//            binding.imgDetailSushi.setImageResource(getPhoto)
//        }
        Glide.with(this)
            .load(getPhoto)
            .into(binding.imgDetailSushi)
        binding.tvPriceDetailSushi.text = getPrice
        binding.btnPayment.text = "Tambah ke keranjang - $getPrice"
        binding.tvDescriptionSushi.text = getDescription

        binding.imgShare.setOnClickListener {
            val shareContent = "Ayo nikmati $getName ini bersama"

            val intent= Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareContent)
            }

            if(intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(intent, "Bagikan melalui"))
            }
        }
    }

}