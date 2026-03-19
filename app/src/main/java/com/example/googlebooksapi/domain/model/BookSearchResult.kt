package com.example.googlebooksapi.domain.model

data class BookSearchResult(
    val totalItems: Int,
    val books: List<Book>
)
