package com.surya.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.surya.projectakhir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListAnimeAdapter.onItemClickCallbackk {

    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        rvAnime = findViewById(R.id.rv_animes)


        list.addAll(getListAnimes())
        showRecyclerList()
    }

    // Memanggil data
    private fun getListAnimes(): ArrayList<Anime> {
        val dataName = resources.getStringArray(R.array.data_anime_name)
        val dataDescription = resources.getStringArray(R.array.data_anime_description)
        val dataPhoto = resources.getStringArray(R.array.data_anime_photo)
        val dataStatus = resources.getStringArray(R.array.data_status_tayang)
        val dataSeason = resources.getStringArray(R.array.data_seasons)
        val dataStudios = resources.getStringArray(R.array.data_studios)
        val dataNameC1 = resources.getStringArray(R.array.data_name_main_char_1)
        val dataImgC1 = resources.getStringArray(R.array.data_img_main_char_1)
        val dataNameC2 = resources.getStringArray(R.array.data_name_main_char_2)
        val dataImgC2 = resources.getStringArray(R.array.data_img_main_char_2)
        val dataNameC3 = resources.getStringArray(R.array.data_name_main_char_3)
        val dataImgC3 = resources.getStringArray(R.array.data_img_main_char_3)
        val dataNameC4 = resources.getStringArray(R.array.data_name_main_char_4)
        val dataImgC4 = resources.getStringArray(R.array.data_img_main_char_4)
        val dataNameC5 = resources.getStringArray(R.array.data_name_main_char_5)
        val dataImgC5 = resources.getStringArray(R.array.data_img_main_char_5)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val listAnime = ArrayList<Anime>()
        for (i in dataName.indices) {
            val anime = Anime(dataName[i], dataDescription[i], dataPhoto[i], dataStatus[i], dataSeason[i], dataStudios[i], dataNameC1[i], dataImgC1[i], dataNameC2[i], dataImgC2[i], dataNameC3[i], dataImgC3[i], dataNameC4[i], dataImgC4[i], dataNameC5[i], dataImgC5[i],  dataGenre[i])
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter =ListAnimeAdapter(list)
        listAnimeAdapter.setOnItemClickCallback(this)
        rvAnime.adapter = listAnimeAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onItemClicked(data: Anime) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ANIME, data)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}