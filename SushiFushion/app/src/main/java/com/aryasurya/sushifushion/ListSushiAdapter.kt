package com.aryasurya.sushifushion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aryasurya.sushifushion.databinding.MenuItemBinding
import com.bumptech.glide.Glide

class ListSushiAdapter(private val listSushi: ArrayList<Sushis>) : RecyclerView.Adapter<ListSushiAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Sushis)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, price, photo) = listSushi[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemPrice.text = price

//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listSushi[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listSushi[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listSushi.size

    class ListViewHolder(var binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root)
}