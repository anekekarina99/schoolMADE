package com.dicoding.schoolapp.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.schoolapp.core.data.source.local.entity.SchoolEntity

@Dao
interface SchoolDao {

    @Query("SELECT * FROM sekolah")
    fun getAllSchool(): LiveData<List<SchoolEntity>>

    @Query("SELECT * FROM sekolah where isFavorite = 1")
    fun getFavoriteSchool(): LiveData<List<SchoolEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSchool(school: List<SchoolEntity>)

    @Update
    fun updateFavoriteSchool(school: SchoolEntity)
}
