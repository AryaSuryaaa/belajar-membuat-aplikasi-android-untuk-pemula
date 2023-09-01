package com.aryasurya.sushifushion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryasurya.sushifushion.databinding.SushiTodayItemBinding
import com.bumptech.glide.Glide

class ListSushiTodayAdapter(private val listSushiToday: ArrayList<Sushis>): RecyclerView.Adapter<ListSushiTodayAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: SushiTodayItemBinding) : RecyclerView.ViewHolder(binding.root)
//    {
//        val imgPhoto: ImageView = itemView.findViewById(R.id.img_sushi_today)
//        val tvName: TextView = itemView.findViewById(R.id.tv_sushi_today)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.sushi_today_item, parent, false)
        val binding = SushiTodayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listSushiToday.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, price ,photo) = listSushiToday[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgSushiToday)
        holder.binding.tvSushiToday.text = name
    }
}