package com.ismokurt.mvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ismokurt.mvvm.entity.Song

@Dao
interface MusicDao {

    //Song DAO
    @Query("SELECT * FROM song_table")
    fun getSongs() : LiveData<List<Song>>

    @Insert(entity = Song::class)
     fun insertSong(song: Song)

    @Delete(entity = Song::class)
     fun deleteSong(song: Song)

    @Update(entity = Song::class)
     fun updateSong(song: Song)

}
