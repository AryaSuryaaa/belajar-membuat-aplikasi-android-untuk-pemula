package com.aryasurya.sushifushion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aryasurya.sushifushion.databinding.ActivityDetailBinding

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
        if (getPhoto != null) {
            binding.imgDetailSushi.setImageResource(getPhoto)
        }
        binding.tvPriceDetailSushi.text = getPrice
        binding.btnPayment.text = "Tambah ke keranjang - $getPrice"
        binding.tvDescriptionSushi.text = getDescription
    }
}