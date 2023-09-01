package com.aryasurya.sushifushion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aryasurya.sushifushion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var rvSushis: RecyclerView
    private lateinit var rvSushis2: RecyclerView
    private val list = ArrayList<Sushis>()
    private lateinit var listSushiAdapter: ListSushiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvSushis = binding.rvSushis
        rvSushis.setHasFixedSize(true)

        rvSushis2 = binding.rvSushiToday
        rvSushis2.setHasFixedSize(true)

        list.addAll(getListSushi())
        showRecyclerList()

        binding.profileUser.setOnClickListener {
            val intentToProfile = Intent(this, ProfileActivity::class.java)
            startActivity(intentToProfile)
        }
    }

    private fun getListSushi(): ArrayList<Sushis> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataUrlPhoto = resources.getStringArray(R.array.data_url_photo)
        val dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        val listSushi = ArrayList<Sushis>()
        for (i in dataName.indices) {
            val sushi = Sushis(dataName[i], dataPrice[i], dataPhoto.getResourceId(i, -1), dataUrlPhoto[i], dataDeskripsi[i])
            listSushi.add(sushi)
        }
        return listSushi
    }

    private fun showRecyclerList() {
        rvSushis.layoutManager = GridLayoutManager(this, 2)
        val listSushiAdapter = ListSushiAdapter(list)
        rvSushis.adapter = listSushiAdapter

        rvSushis2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listSushiAdapter2 = ListSushiTodayAdapter(list)
        rvSushis2.adapter = listSushiAdapter2



        listSushiAdapter.setOnItemClickCallback(object : ListSushiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Sushis) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

}