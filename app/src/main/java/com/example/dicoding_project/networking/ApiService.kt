package com.example.dicoding_project.networking

import retrofit2.http.*
import com.example.dicoding_project.Model.CurrentWeatherResponse
import retrofit2.Call

interface  ApiService {
    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") key: String = ApiConfig.API_KEY,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<CurrentWeatherResponse>
}