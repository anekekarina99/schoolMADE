package com.dicoding.schoolapp.core.di

import android.content.Context

import com.dicoding.schoolapp.core.data.source.local.LocalDataSource
import com.dicoding.schoolapp.core.data.source.local.room.SchoolDatabase

import com.dicoding.schoolapp.core.data.SchoolRepository
import com.dicoding.schoolapp.core.data.source.remote.RemoteDataSource
import com.dicoding.schoolapp.core.data.source.remote.network.ApiConfig
import com.dicoding.schoolapp.core.domain.repository.ISchoolRepository
import com.dicoding.schoolapp.core.domain.usecase.SchoolInteractor
import com.dicoding.schoolapp.core.domain.usecase.SchoolUseCase
import com.dicoding.schoolapp.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): ISchoolRepository {
        val database = SchoolDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return SchoolRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideSchoolUseCase(context: Context): SchoolUseCase {
        val repository = provideRepository(context)
        return SchoolInteractor(repository)
    }
}
