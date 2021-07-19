package com.dicoding.schoolapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSchoolismResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("places")
    val places: List<SchoolResponse>
)
