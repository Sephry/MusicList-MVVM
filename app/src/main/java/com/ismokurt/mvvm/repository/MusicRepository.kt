package com.ismokurt.mvvm.repository

import androidx.lifecycle.LiveData
import com.ismokurt.mvvm.dao.MusicDao
import com.ismokurt.mvvm.entity.Song

class MusicRepository (val dao : MusicDao) {


    fun getAllSong() : LiveData<List<Song>>{
        return dao.getSongs()
    }

    fun insertSong(song: Song){
        dao.insertSong(song)
    }

     fun updateSong(song: Song){
        dao.updateSong(song)
    }

     fun deleteSong(song: Song){
        dao.deleteSong(song)
    }

}