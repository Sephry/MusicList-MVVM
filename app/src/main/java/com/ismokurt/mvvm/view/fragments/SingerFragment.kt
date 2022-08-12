package com.ismokurt.mvvm.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ismokurt.mvvm.R
import com.ismokurt.mvvm.databinding.FragmentSingerBinding
import com.ismokurt.mvvm.view.adapter.SingerAdapter
import com.ismokurt.mvvm.viewModel.MusicViewModel


class SingerFragment : Fragment() {

    lateinit var binding: FragmentSingerBinding
    val viewModel : MusicViewModel by  viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingerBinding.inflate(layoutInflater,container,false)
        viewModel.getMusic().observe(viewLifecycleOwner) {  singerList ->

            binding.recyclerViewSinger.layoutManager = GridLayoutManager(requireContext(), 1)

            binding.recyclerViewSinger.adapter = SingerAdapter(requireContext(),singerList)


        }

        return binding.root
    }


}