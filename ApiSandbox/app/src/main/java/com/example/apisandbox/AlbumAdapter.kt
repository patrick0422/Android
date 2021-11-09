package com.example.apisandbox

import android.app.Service
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apisandbox.databinding.AlbumItemBinding
import com.example.apisandbox.retrofit.model.Album

class AlbumAdapter(var itemList: ArrayList<Album>): RecyclerView.Adapter<AlbumViewHolder>() {
    private lateinit var binding: AlbumItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = parent.context.getSystemService(Service.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = AlbumItemBinding.inflate(inflater, parent, false)

        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}

class AlbumViewHolder(private val binding: AlbumItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(album: Album) {
        binding.tvTitle.text = album.title
        binding.tvAlbumId.text = "Album Id: ${album.id}"
        binding.tvUserId.text = "User Id: ${album.userId}"
    }
}