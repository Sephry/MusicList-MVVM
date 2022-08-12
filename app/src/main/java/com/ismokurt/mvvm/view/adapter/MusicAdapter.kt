package com.ismokurt.mvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismokurt.mvvm.databinding.SonglistItemRcvBinding
import com.ismokurt.mvvm.entity.Song


class MusicAdapter():  RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {


    class MusicViewHolder(val binding: SonglistItemRcvBinding) :RecyclerView.ViewHolder(binding.root)
    var musicList = emptyList<Song>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(
            SonglistItemRcvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {

        val data = musicList[position]
        holder.binding.songListItemName.text= data.songName
        holder.binding.songListItemSinger.text = data.singerName
        holder.binding.songListItemAlbum.text = data.albumName

    }

    override fun getItemCount() = musicList.size
    fun setData(newData: List<Song>){
        musicList = newData
        notifyDataSetChanged()
    }
}