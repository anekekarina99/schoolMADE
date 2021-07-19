package com.dicoding.schoolapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.schoolapp.core.data.Resource
import com.dicoding.schoolapp.core.domain.model.Schoolism

interface SchoolUseCase {

    fun getAllSchool(): LiveData<Resource<List<Schoolism>>>
    fun getFavoriteSchool(): LiveData<List<Schoolism>>
    fun setFavoriteSchool(tourism: Schoolism, state: Boolean)

}