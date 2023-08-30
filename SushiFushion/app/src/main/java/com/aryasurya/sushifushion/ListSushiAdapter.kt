package com.aryasurya.sushifushion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListSushiAdapter(private val listSushi: AbstractList<Sushis>) : RecyclerView.Adapter<ListSushiAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, price, photo) = listSushi[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvPrice.text = price
    }

    override fun getItemCount(): Int = listSushi.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
    }
}