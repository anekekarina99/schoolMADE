package com.dicoding.schoolapp.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.schoolapp.core.domain.usecase.SchoolUseCase

class FavoriteViewModel(schoolRepository: SchoolUseCase) : ViewModel() {

    val favoriteTourism = schoolRepository.getFavoriteSchool()

}

