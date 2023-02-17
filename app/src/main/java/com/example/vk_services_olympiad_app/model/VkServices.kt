package com.example.vk_services_olympiad_app.model

import com.example.vk_services_olympiad_app.model.Item
import com.squareup.moshi.Json

data class VkServices (
    @Json(name = "items")
    var items: List<Item>
)
