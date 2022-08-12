package com.ismokurt.mvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ismokurt.mvvm.database.MusicDatabase
import com.ismokurt.mvvm.entity.Song
import com.ismokurt.mvvm.repository.MusicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel(application: Application) : AndroidViewModel(application){

    private val repository : MusicRepository

    init {
        val dao = MusicDatabase.getDatabaseInstance(application).musicDao()
        repository = MusicRepository(dao)
    }

    fun getMusic() : LiveData<List<Song>> = repository.getAllSong()

    fun addMusic(song: Song){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertSong(song)
        }
    }

    fun deleteMusic(song: Song){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteSong(song)
        }
    }

    fun updateSong(song: Song){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateSong(song)
        }
    }

}