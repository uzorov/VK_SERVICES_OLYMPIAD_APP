package com.example.vk_services_olympiad_app.model

import com.squareup.moshi.Json

data class Item(
    val name : String,
    val description : String,
    @Json(name = "icon_url") val iconUrl: String,
    @Json(name = "service_url") val serviceUrl: String
)
