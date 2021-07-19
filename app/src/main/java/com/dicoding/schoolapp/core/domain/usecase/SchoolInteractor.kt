package com.dicoding.schoolapp.core.domain.usecase

import com.dicoding.schoolapp.core.domain.model.Schoolism
import com.dicoding.schoolapp.core.domain.repository.ISchoolRepository

class SchoolInteractor (private val tourismRepository: ISchoolRepository): SchoolUseCase {

        override fun getAllSchool() = tourismRepository.getAllSchool()

        override fun getFavoriteSchool() = tourismRepository.getFavoriteSchool()

        override fun setFavoriteSchool(tourism: Schoolism, state: Boolean) = tourismRepository.setFavoriteSchool(tourism, state)

}
