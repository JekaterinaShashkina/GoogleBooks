package com.example.googlebooksapi.domain.repository

import com.example.googlebooksapi.domain.model.Book

interface BooksRepository {
    suspend fun searchBooks(query: String): List<Book>
}