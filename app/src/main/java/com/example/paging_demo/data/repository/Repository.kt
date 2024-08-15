package com.example.paging_demo.data.repository

import SearchPagingSource
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging_demo.data.local.UnsplashDatabase
import com.example.paging_demo.model.UnsplashImage
import com.example.paging_demo.data.paging.UnsplashRemoteMediator
import com.example.paging_demo.data.remote.UnsplashAPI
import com.example.paging_demo.utils.Constant.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val unsplashAPI: UnsplashAPI,
    private val unsplashDatabase: UnsplashDatabase,
) {
    @OptIn(ExperimentalPagingApi::class)
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashModelDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashAPI,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashAPI, query = query)
            }
        ).flow
    }

}