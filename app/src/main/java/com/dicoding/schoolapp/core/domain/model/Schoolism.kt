package com.dicoding.schoolapp.core.domain.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Schoolism(
        val alamat_jalan: String, // Jl. Lapangan Hijau Rt. 05/03
        val _id:String, // 60d531f4ec2a980ec2df2433 // 80C29B94-2BF5-E011-AABF-732419A142F3 // Kec. Kepulauan Seribu Selatan
        val propinsi: String, // Prov. D.K.I. Jakarta
        val sekolah: String, // SD NEGERI PULAU TIDUNG 02 PG
        val status: String ,// N
        val isFavorite :Boolean
) : Parcelable
