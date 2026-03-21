package com.example.googlebooksapi.domain.repository

import com.example.googlebooksapi.domain.model.Book
import com.example.googlebooksapi.domain.model.BookSearchResult

interface BooksRepository {
    suspend fun searchBooks(query: String): BookSearchResult
    suspend fun getLastFiveQueries(): List<String>
}