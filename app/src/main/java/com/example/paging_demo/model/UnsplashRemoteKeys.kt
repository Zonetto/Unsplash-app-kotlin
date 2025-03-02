package com.example.paging_demo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paging_demo.utils.Constant.UNSPlASH_REMOTE_KEYS_TABLE

@Entity(tableName = UNSPlASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?,
)
