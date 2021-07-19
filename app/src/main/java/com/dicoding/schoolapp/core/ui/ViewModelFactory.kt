package com.dicoding.schoolapp.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.schoolapp.core.di.Injection
import com.dicoding.schoolapp.core.domain.usecase.SchoolUseCase
import com.dicoding.schoolapp.detail.DetailSchoolViewModel
import com.dicoding.schoolapp.favorite.FavoriteViewModel
import com.dicoding.schoolapp.home.HomeViewModel

class ViewModelFactory private constructor(private val schoolRepository: SchoolUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                instance
                    ?: ViewModelFactory(
                        Injection.provideSchoolUseCase(
                            context
                        )
                    )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(schoolRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(schoolRepository) as T
            }
            modelClass.isAssignableFrom(DetailSchoolViewModel::class.java) -> {
                DetailSchoolViewModel(schoolRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}