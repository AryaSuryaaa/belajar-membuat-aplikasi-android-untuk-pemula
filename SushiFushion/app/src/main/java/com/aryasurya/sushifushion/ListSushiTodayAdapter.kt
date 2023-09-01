package com.aryasurya.sushifushion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryasurya.sushifushion.databinding.SushiTodayItemBinding
import com.bumptech.glide.Glide

class ListSushiTodayAdapter(private val listSushiToday: ArrayList<Sushis>): RecyclerView.Adapter<ListSushiTodayAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: SushiTodayItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = SushiTodayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listSushiToday.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, price ,photo, urlPhoto) = listSushiToday[position]
        Glide.with(holder.itemView.context)
            .load(urlPhoto)
            .into(holder.binding.imgSushiToday)
        holder.binding.tvSushiToday.text = name
    }
}