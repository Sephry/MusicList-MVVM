package com.ismokurt.mvvm.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "song_table")
data class Song(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,

    @ColumnInfo(name = "song_name")
    var songName : String,

    @ColumnInfo(name = "singer_name")
    var singerName : String,

    @ColumnInfo(name = "album_name")
    var albumName : String,

) : Parcelable