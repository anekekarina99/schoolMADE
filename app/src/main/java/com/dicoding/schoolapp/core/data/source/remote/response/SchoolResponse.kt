package com.dicoding.schoolapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SchoolResponse(
    @field:SerializedName("alamat_jalan")
    val alamat_jalan: String, // Jl. Lapangan Hijau Rt. 05/03
    @field:SerializedName("_id")
    val _id: String, // 60d531f4ec2a980ec2df2433 // 80C29B94-2BF5-E011-AABF-732419A142F3 // Kec. Kepulauan Seribu Selatan
    @field:SerializedName("propinsi")
    val propinsi: String, // Prov. D.K.I. Jakarta
    @field:SerializedName("sekolah")
    val sekolah: String, // SD NEGERI PULAU TIDUNG 02 PG
    @field:SerializedName("status")
    val status: String ,// N
)


