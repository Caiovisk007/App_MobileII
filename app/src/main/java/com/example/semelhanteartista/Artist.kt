package com.example.semelhanteartista

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Artist {
    @GET("similar")
    fun getPosts(@Query("q") q: String?): Call<ResponseApiSimilar>
}