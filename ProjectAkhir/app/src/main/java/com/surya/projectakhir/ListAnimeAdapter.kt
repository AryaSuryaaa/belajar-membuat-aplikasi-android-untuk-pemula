package com.surya.projectakhir


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surya.projectakhir.databinding.ItemDataBinding

class ListAnimeAdapter(private val listAnime: ArrayList<Anime>) : RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: onItemClickCallbackk

    fun setOnItemClickCallback(onItemClickCallback: onItemClickCallbackk){
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listAnime[position]
        holder.binding.animeItemName.text = name
        holder.binding.animeItemDescription.text = description
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.animeItemPhoto)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listAnime[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int = listAnime.size

    class ListViewHolder(var binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    interface onItemClickCallbackk {
        fun onItemClicked(data: Anime)

    }
}