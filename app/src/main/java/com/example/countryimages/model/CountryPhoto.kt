package com.example.countryimages.model

import com.squareup.moshi.Json

data class CountryPhoto(
    @Json(name = "data")  val data: List<DataCountry>
)
