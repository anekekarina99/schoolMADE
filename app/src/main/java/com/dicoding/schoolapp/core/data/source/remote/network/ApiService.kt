package com.dicoding.schoolapp.core.data.source.remote.network

import com.dicoding.schoolapp.core.data.source.remote.response.ListSchoolismResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


    @GET("SD?page=1&perPage=5")
    fun getSchool(): Call<ListSchoolismResponse>
}