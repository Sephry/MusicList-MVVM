package com.ismokurt.mvvm.view.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.viewModels
import com.ismokurt.mvvm.R
import com.ismokurt.mvvm.databinding.FragmentSettingsBinding
import com.ismokurt.mvvm.entity.Song
import com.ismokurt.mvvm.viewModel.MusicViewModel

class SettingsFragment : Fragment() {

    lateinit var binding: FragmentSettingsBinding
    val viewModel : MusicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater,container,false)

        binding.saveBtn.setOnClickListener {
            createMusic(it)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun createMusic(it: View?) {

        val songName = binding.addMusicName.text.toString()
        val singerName = binding.addSingerName.text.toString()
        val albumName = binding.addAlbumName.text.toString()


        val data = Song(null,songName,singerName,albumName)
        if (data.singerName.isEmpty() || data.songName.isEmpty() || data.albumName.isEmpty()){
            Toast.makeText(context,"Please complete all of the fields.", Toast.LENGTH_LONG).show()


        }else {
            viewModel.addMusic(data)
            Toast.makeText(context,"Created Successfully", Toast.LENGTH_LONG).show()

        }
    }
}