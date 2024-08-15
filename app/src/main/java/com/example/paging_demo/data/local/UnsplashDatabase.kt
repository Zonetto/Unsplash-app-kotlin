package com.example.paging_demo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging_demo.model.UnsplashImage
import com.example.paging_demo.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {
    abstract fun unsplashModelDao(): UnsplashModelDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}