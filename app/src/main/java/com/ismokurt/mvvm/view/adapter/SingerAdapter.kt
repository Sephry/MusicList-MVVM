package com.ismokurt.mvvm.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismokurt.mvvm.databinding.SingerlistItemRcvBinding
import com.ismokurt.mvvm.entity.Song

class SingerAdapter(requireContext : Context, val singerList: List<Song>):
    RecyclerView.Adapter<SingerAdapter.SingerViewHolder>() {

    class SingerViewHolder(val binding : SingerlistItemRcvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingerViewHolder {
        return SingerViewHolder(SingerlistItemRcvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SingerViewHolder, position: Int) {

        val data= singerList[position]
        holder.binding.songListItemSinger.text = data.singerName
    }

    override fun getItemCount() = singerList.size
}