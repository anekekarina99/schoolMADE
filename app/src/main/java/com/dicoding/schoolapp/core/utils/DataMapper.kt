package com.dicoding.schoolapp.core.utils

import com.dicoding.schoolapp.core.data.source.local.entity.SchoolEntity
import com.dicoding.schoolapp.core.data.source.remote.response.SchoolResponse
import com.dicoding.schoolapp.core.domain.model.Schoolism

object DataMapper {

    fun mapResponsesToEntities(input: List<SchoolResponse>): List<SchoolEntity> {
        val tourismList = ArrayList<SchoolEntity>()
        input.map {
            val tourism = SchoolEntity(
                schoolId = it._id,
              name  = it.sekolah,
               regional = it.propinsi,
                address = it.alamat_jalan,
                status = it.status,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }
    fun mapEntitiesToDomain(input: List<SchoolEntity>): List<Schoolism> =
        input.map {
            Schoolism(
                _id = it.schoolId,
                sekolah = it.name,
                propinsi = it.regional,
                alamat_jalan  = it.address,
                status = it.status,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: Schoolism) = SchoolEntity(
        schoolId = input._id,
        name = input.sekolah,
        address = input.alamat_jalan,
        regional = input.propinsi,
        status = input.status,
        isFavorite = input.isFavorite
    )
}