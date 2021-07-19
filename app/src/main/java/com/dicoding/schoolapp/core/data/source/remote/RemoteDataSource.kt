package com.dicoding.schoolapp.core.data.source.remote


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.schoolapp.core.data.source.remote.network.ApiResponse
import com.dicoding.schoolapp.core.data.source.remote.network.ApiService
import com.dicoding.schoolapp.core.data.source.remote.response.ListSchoolismResponse
import com.dicoding.schoolapp.core.data.source.remote.response.SchoolResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val jsonHelper: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper:ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllSchool(): LiveData<ApiResponse<List<SchoolResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<SchoolResponse>>>()

        //get data from remote api
        val client =jsonHelper.getSchool()

        client.enqueue(object : Callback<ListSchoolismResponse> {
            override fun onResponse(
                call: Call<ListSchoolismResponse>,
                response: Response<ListSchoolismResponse>
            ) {
                val dataArray = response.body()?.places
                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListSchoolismResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

}

