package com.example.countryimages.model

import com.squareup.moshi.Json

data class DataCountry(
    @Json(name = "name")  val name: String, @Json(name = "flag") val flag: String

)
