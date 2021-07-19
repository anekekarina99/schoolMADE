package com.dicoding.schoolapp.detail

import androidx.lifecycle.ViewModel

import com.dicoding.schoolapp.core.domain.model.Schoolism
import com.dicoding.schoolapp.core.domain.usecase.SchoolUseCase

class DetailSchoolViewModel(private val schoolRepository: SchoolUseCase) : ViewModel() {
    fun setFavoriteSchool(school: Schoolism, newStatus:Boolean) = schoolRepository.setFavoriteSchool(school, newStatus)
}

