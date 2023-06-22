package com.comunidadedevspace.taskbeats.data.remote

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val data: List<NewsDto>
)

data class NewsDto(
    @SerializedName("uuid")
    val id: Int,
    @SerializedName("snippet")
    val content: String,
    val title: String,
    @SerializedName("image_url")
    val imageUrl: String,
)
