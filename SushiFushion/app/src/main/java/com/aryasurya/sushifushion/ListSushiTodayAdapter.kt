package com.aryasurya.sushifushion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListSushiTodayAdapter(private val listSushiToday: ArrayList<Sushis>): RecyclerView.Adapter<ListSushiTodayAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_sushi_today)
        val tvName: TextView = itemView.findViewById(R.id.tv_sushi_today)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.sushi_today_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSushiToday.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, price ,photo) = listSushiToday[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
    }
}