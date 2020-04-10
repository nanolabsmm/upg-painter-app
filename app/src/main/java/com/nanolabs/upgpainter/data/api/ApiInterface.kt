package com.nanolabs.upgpainter.data.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("multiRecycler.json")
    fun getData(): Call<List<ApiResponse>>
}