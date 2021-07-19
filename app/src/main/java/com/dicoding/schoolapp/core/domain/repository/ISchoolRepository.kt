package com.dicoding.schoolapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.dicoding.schoolapp.core.data.Resource
import com.dicoding.schoolapp.core.domain.model.Schoolism

interface ISchoolRepository {

    fun getAllSchool(): LiveData<Resource<List<Schoolism>>>

    fun getFavoriteSchool(): LiveData<List<Schoolism>>

    fun setFavoriteSchool(tourism: Schoolism, state: Boolean)
}