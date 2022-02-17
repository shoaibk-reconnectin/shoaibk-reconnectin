package com.cheezycode.randomquote.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sk2apps.moviesassignment.model.ResultModel

@Database(entities = [ResultModel::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun dao() : MovieDao

    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        MovieDatabase::class.java,
                        "movieDB")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}