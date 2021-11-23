package com.example.countryimages.network

import com.example.countryimages.model.CountryPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://countriesnow.space/api/v0.1/countries/flag/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
// this is Retrofit builder to build and create a Retrofit object.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface CountryApiService {
    @GET("images")
    suspend fun getPhotos(): List<CountryPhoto>
}

object CountryApi {
    val retrofitService : CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java) }
}