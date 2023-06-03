package com.comunidadedevspace.taskbeats.data.remote

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val count: Int,
    val next: String,
    val previous: Boolean,
    val results: List<NewsDto>
)

data class NewsDto(
    val id: Int,
    val title: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val summary: String,
)
