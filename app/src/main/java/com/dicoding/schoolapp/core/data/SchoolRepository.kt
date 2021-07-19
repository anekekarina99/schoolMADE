package com.dicoding.schoolapp.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.dicoding.schoolapp.core.data.source.remote.network.ApiResponse
import com.dicoding.schoolapp.core.data.source.local.LocalDataSource
import com.dicoding.schoolapp.core.data.source.remote.RemoteDataSource
import com.dicoding.schoolapp.core.data.source.remote.response.SchoolResponse
import com.dicoding.schoolapp.core.domain.model.Schoolism
import com.dicoding.schoolapp.core.domain.repository.ISchoolRepository
import com.dicoding.schoolapp.core.utils.AppExecutors
import com.dicoding.schoolapp.core.utils.DataMapper

class SchoolRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
)  : ISchoolRepository {

    companion object {
        @Volatile
        private var instance: SchoolRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): SchoolRepository =
            instance ?: synchronized(this) {
                instance ?: SchoolRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllSchool(): LiveData<Resource<List<Schoolism>>> =
        object : NetworkBoundResource<List<Schoolism>, List<SchoolResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Schoolism>> {
               return Transformations.map(localDataSource.getAllSchool()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Schoolism>?): Boolean =
                true

            override fun createCall(): LiveData<ApiResponse<List<SchoolResponse>>> =
                remoteDataSource.getAllSchool()

            override fun saveCallResult(data: List<SchoolResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSchool(tourismList)
            }
        }.asLiveData()

    override fun getFavoriteSchool(): LiveData<List<Schoolism>> {
        return Transformations.map(localDataSource.getFavoriteSchool()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteSchool(tourism: Schoolism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteSchool(tourismEntity, state) }
    }

}

