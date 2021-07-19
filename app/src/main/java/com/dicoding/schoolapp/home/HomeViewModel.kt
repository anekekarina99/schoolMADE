package com.dicoding.schoolapp.home

import androidx.lifecycle.ViewModel
import com.dicoding.schoolapp.core.domain.usecase.SchoolUseCase

class HomeViewModel(schoolRepository: SchoolUseCase) : ViewModel() {

    val tourism = schoolRepository.getAllSchool()

}

