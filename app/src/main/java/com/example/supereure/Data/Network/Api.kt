package com.example.supereure.Data.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private var builder = Retrofit.Builder()
        .baseUrl("http://192.168.1.6:1425/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var tokent = "aki le paso el tokent"

    var buildSuerheroes = builder.create(SuperheroesService::class.java)



}