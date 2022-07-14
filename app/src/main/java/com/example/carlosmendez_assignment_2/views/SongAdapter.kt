package com.example.carlosmendez_assignment_2.views

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carlosmendez_assignment_2.R
import com.example.carlosmendez_assignment_2.databinding.FragmentRockBinding
import com.example.carlosmendez_assignment_2.databinding.SongItemBinding
import com.example.data.carlosmendez_assignment_2.Song

class SongAdapter(
    private val songList: List<Song>
): RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    inner class SongViewHolder(private val binding: SongItemBinding)
        :RecyclerView.ViewHolder(binding.root) {
            fun onBind(song: Song) {
                // Text
                binding.tvArtistName.text = song.artistName
                binding.tvCollectionName.text = song.collectionName
                binding.tvPrice.text = song.trackPrice + " USD"

                // Image
                Glide.with(binding.ivAlbumCover)
                    .load(song.artworkUrl60)
                    .placeholder(R.mipmap.ic_beluga)
                    .into(binding.ivAlbumCover)

                // Play song preview
                binding.root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setAction(Intent.ACTION_VIEW)
                    intent.setDataAndType(Uri.parse(song.previewUrl), "audio/*")
                    binding.root.context.startActivity(intent)
                }
            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            SongItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(songList[position])
    }

    override fun getItemCount(): Int {
        return songList.size
    }
}