package com.dicoding.schoolapp.core.data.source.local.room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.dicoding.schoolapp.core.data.source.local.entity.SchoolEntity

@Database(entities = [SchoolEntity::class], version = 1, exportSchema = false)
abstract class SchoolDatabase : RoomDatabase() {

    abstract fun tourismDao(): SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase =
            INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                SchoolDatabase::class.java,
                "School.db"
            )
                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            instance
        }
    }
}