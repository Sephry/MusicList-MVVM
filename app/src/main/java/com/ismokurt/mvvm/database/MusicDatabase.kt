package com.ismokurt.mvvm.database

import android.content.Context
import android.graphics.Bitmap
import androidx.room.*
import com.ismokurt.mvvm.dao.MusicDao
import com.ismokurt.mvvm.entity.Song

@Database(entities = arrayOf(Song::class), version = 1, exportSchema = false)
abstract class MusicDatabase : RoomDatabase() {

    abstract fun musicDao() : MusicDao

    companion object {

        @Volatile
        var INSTANCE : MusicDatabase? = null

        fun getDatabaseInstance(context : Context) : MusicDatabase{
            val tempInstnce = INSTANCE

            if (tempInstnce != null) {
                return tempInstnce
            }

            synchronized(this) {
                val roomDatabaseInstance = Room.databaseBuilder(
                    context,
                    MusicDatabase::class.java,
                    "Music")
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }

        }
    }

}