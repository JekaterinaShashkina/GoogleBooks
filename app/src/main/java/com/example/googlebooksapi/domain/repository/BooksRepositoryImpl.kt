package com.example.googlebooksapi.domain.repository

import com.example.googlebooksapi.data.mapper.toDomain
import com.example.googlebooksapi.data.remote.BooksApi
import com.example.googlebooksapi.domain.model.Book
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val api: BooksApi
) : BooksRepository {

        override suspend fun searchBooks(query: String): List<Book> {
            val response = api.searchBooks(query)
            return response.items
                ?.map { it.toDomain() }
                ?: emptyList()
        }
}