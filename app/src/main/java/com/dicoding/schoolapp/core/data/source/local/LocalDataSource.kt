package com.dicoding.schoolapp.core.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.schoolapp.core.data.source.local.entity.SchoolEntity
import com.dicoding.schoolapp.core.data.source.local.room.SchoolDao

class LocalDataSource private constructor(private val schoolDao: SchoolDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(schoolDao: SchoolDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(schoolDao)
            }
    }

    fun getAllSchool(): LiveData<List<SchoolEntity>> = schoolDao.getAllSchool()

    fun getFavoriteSchool(): LiveData<List<SchoolEntity>> = schoolDao.getFavoriteSchool()

    fun insertSchool(schoolList: List<SchoolEntity>) = schoolDao.insertSchool(schoolList)

    fun setFavoriteSchool(school: SchoolEntity, newState: Boolean) {
        school.isFavorite = newState
        schoolDao.updateFavoriteSchool(school)
    }
}