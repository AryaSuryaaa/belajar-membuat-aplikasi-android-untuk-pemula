package com.aryasurya.sushifushion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvSushis: RecyclerView
    private lateinit var rvSushis2: RecyclerView
    private val list = ArrayList<Sushis>()
    private lateinit var listSushiAdapter: ListSushiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSushis = findViewById(R.id.rv_sushis)
        rvSushis.setHasFixedSize(true)

        rvSushis2 = findViewById(R.id.rv_sushi_today)
        rvSushis2.setHasFixedSize(true)

        list.addAll(getListSushi())
        showRecyclerList()
    }

    private fun getListSushi(): ArrayList<Sushis> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSushi = ArrayList<Sushis>()
        for (i in dataName.indices) {
            val sushi = Sushis(dataName[i], dataPrice[i], dataPhoto.getResourceId(i, -1))
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