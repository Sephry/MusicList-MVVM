package com.ismokurt.mvvm.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ismokurt.mvvm.databinding.FragmentMusicBinding
import com.ismokurt.mvvm.databinding.SonglistItemRcvBinding
import com.ismokurt.mvvm.view.adapter.MusicAdapter
import com.ismokurt.mvvm.viewModel.MusicViewModel
import java.io.PipedOutputStream
import java.util.*

class MusicFragment : Fragment() {

    private val viewModel :MusicViewModel by viewModels()
    //private lateinit var adapter : MusicAdapter
    private val adapter: MusicAdapter by lazy { MusicAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMusicBinding.inflate(layoutInflater,container,false)

        viewModel.getMusic().observe(viewLifecycleOwner) {

            binding.recyclerViewMusic.layoutManager =GridLayoutManager(requireContext(),1)
            // binding.recyclerViewMusic.adapter = MusicAdapter()
            adapter.setData(it)
            binding.recyclerViewMusic.adapter =adapter


        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {


                val position = viewHolder.adapterPosition
                val song = adapter.musicList[position]

                viewModel.deleteMusic(song)
                Snackbar.make(binding.root,"Deleted!",Snackbar.LENGTH_LONG).apply {
                    setAction("Undo"){
                        viewModel.addMusic(song)
                    }
                    show()
                }
            }

        }).attachToRecyclerView(binding.recyclerViewMusic)

        setHasOptionsMenu(true)
        return binding.root
    }
}