package com.example.paging_demo.model

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val username: String,
    @Embedded // To allow nested fields in the database
    val links: UserLinksModel,
)
