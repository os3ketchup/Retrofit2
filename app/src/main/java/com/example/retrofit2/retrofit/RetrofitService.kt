package com.example.retrofit2.retrofit

import com.example.retrofit2.models.User
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("json")
    fun getUsers():Call<List<User>>
}