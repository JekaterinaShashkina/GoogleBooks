package com.example.googlebooksapi.domain.repository

import com.example.googlebooksapi.data.local.BookDao
import com.example.googlebooksapi.data.mapper.toDomain
import com.example.googlebooksapi.data.mapper.toEntity
import com.example.googlebooksapi.data.remote.BooksApi
import com.example.googlebooksapi.domain.model.Book

import com.example.googlebooksapi.domain.model.BookSearchResult
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val api: BooksApi,
    private val dao: BookDao

) : BooksRepository {

        override suspend fun searchBooks(query: String): BookSearchResult {
            return try {
                val response = api.searchBooks(query)
                val books: List<Book> = response.items?.map { it.toDomain() } ?: emptyList()

                dao.clearBooks(query)
                dao.insertBooks(books.map { it.toEntity(query) })
                dao.keepOnlyLastFiveQueries()

                BookSearchResult(
                    totalItems = response.totalItems,
                    books = books
                )
            } catch (e: Exception) {
                val cachedBooks = dao.getAllBooks(query).map {it.toDomain()}

                BookSearchResult(
                    totalItems = cachedBooks.size,
                    books = cachedBooks
                )
            }
        }
        override suspend fun getLastFiveQueries(): List<String> {
            return dao.getLastQueries()
        }
}