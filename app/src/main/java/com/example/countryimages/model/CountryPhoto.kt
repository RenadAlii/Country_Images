package com.example.countryimages.model

import com.squareup.moshi.Json

data class CountryPhoto(
   @Json(name = "error")  val error: Boolean ,@Json(name = "msg") val msg:String,  @Json(name = "data")  val data: List<DataCountry>
)
