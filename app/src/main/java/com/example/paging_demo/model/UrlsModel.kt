package com.example.paging_demo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UrlsModel(
    @SerialName("regular")
    val regular: String,
)
