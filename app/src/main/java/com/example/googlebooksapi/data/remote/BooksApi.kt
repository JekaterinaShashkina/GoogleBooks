package com.example.googlebooksapi.data.remote

import retrofit2.http.Query
import retrofit2.http.GET

interface BooksApi {
    @GET("books/v1/volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResult: Int = 20,
    ) : BooksResponseDto
}