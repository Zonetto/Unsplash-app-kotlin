package com.example.paging_demo.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paging_demo.model.UnsplashImage

@Dao
interface UnsplashModelDao {
    @Query("SELECT * FROM unsplash_model_table")
    fun getAllImages(): PagingSource<Int, UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImage>)

    @Query("DELETE FROM unsplash_model_table")
    suspend fun deleteAllImages()
}