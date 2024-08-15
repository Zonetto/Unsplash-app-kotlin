package com.example.paging_demo.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paging_demo.utils.Constant.UNSPLASH_MODEL_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = UNSPLASH_MODEL_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val urls: UrlsModel,
    val likes: Int,
    @Embedded
    val user: UserModel,
)
