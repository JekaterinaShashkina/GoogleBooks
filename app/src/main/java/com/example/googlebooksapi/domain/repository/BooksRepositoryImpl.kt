package com.example.googlebooksapi.domain.repository

import com.example.googlebooksapi.data.mapper.toDomain
import com.example.googlebooksapi.data.remote.BooksApi

import com.example.googlebooksapi.domain.model.BookSearchResult
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val api: BooksApi
) : BooksRepository {

        override suspend fun searchBooks(query: String): BookSearchResult {
            val response = api.searchBooks(query)
            return BookSearchResult(
                totalItems = response.totalItems,
                books = response.items?.map { it.toDomain() } ?: emptyList()
            )
        }
}