package com.surya.projectakhir

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.surya.projectakhir.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityDetailBinding
    companion object {
        const val EXTRA_ANIME = "extra_anime"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val anime = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_ANIME, Anime::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_ANIME)
        }

        if (anime != null) {
            Glide.with(this)
                .load(anime.photo)
                .into(binding.imgItemDetail)

            binding.nameItemDetail.text = anime.name
            binding.statusItemDetail.text = "Status : " + anime.status
            binding.seasonItemDetail.text = "Text : " + anime.season
            binding.studiosItemDetail.text = "Studios : " +anime.studios

            Glide.with(this)
                .load(anime.imgc1)
                .into(binding.itemImgMainChar)
            binding.itemNameMainChar.text = anime.namec1

            Glide.with(this)
                .load(anime.imgc2)
                .into(binding.itemImgMainChar2)
            binding.itemNameMainChar2.text = anime.namec2

            Glide.with(this)
                .load(anime.imgc3)
                .into(binding.itemImgMainChar3)
            binding.itemNameMainChar3.text = anime.namec3

            Glide.with(this)
                .load(anime.imgc4)
                .into(binding.itemImgMainChar4)
            binding.itemNameMainChar4.text = anime.namec4

            Glide.with(this)
                .load(anime.imgc5)
                .into(binding.itemImgMainChar5)
            binding.itemNameMainChar5.text = anime.namec5

            binding.genresAnimeItemDetail.text = anime.genre

            binding.descriptionAnimeItemDetail.text = anime.description
        }

        binding.btnShareDetail.setOnClickListener{

            val shareContent = "Ayo Nonton Anime " + binding.nameItemDetail.text

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareContent)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(intent, "Bagikan melalui"))
            }
        }

    }
}