package com.example.supereure.Data.Network

import com.example.supereure.Data.Model.Superheroe
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface SuperheroesService {

    @GET("Superheroes")
    fun GetAllHeroes(): Call<List<Superheroe>>

    @GET("Superheroes/{id}")
    fun GetHeroesByID(@Path("id") id: String): Call<Superheroe>

    @POST("Superheroes")
    fun PostHeroe(
        @Header("Authorization") tokent: String,
        @Body superheroe: Superheroe
    ): Call<Superheroe>

    @DELETE("Superheroes/{id}")
    fun DeleteHeroe(
        @Header("Authorization") tokent: String,
        @Path("id") id: String
    ): Call<Superheroe>

    @PUT("Superheroes/{id}")
    fun PutHeroe(
        @Header("Authorization") tokent: String,
        @Path("id") id: String,
        @Body superheroe: Superheroe
    ): Call<Superheroe>

}