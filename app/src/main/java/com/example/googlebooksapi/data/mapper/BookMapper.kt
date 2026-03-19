package com.example.googlebooksapi.data.mapper

import com.example.googlebooksapi.data.local.BookEntity
import com.example.googlebooksapi.data.remote.BooksResponseDto
import com.example.googlebooksapi.domain.model.Book

fun BooksResponseDto.BookItemDto.toDomain(): Book {
    val info = volumeInfo

    return Book(
        id = id,
        title = info?.title ?: "No title",
        authors = info?.authors?.joinToString(", ") ?: "Unknown author",
        publishedDate = info?.publishedDate ?: "Unknown date",
        description = info?.description ?: "No description",
        pageCount = info?.pageCount ?: 0,
        thumbnail = info?.imageLinks?.thumbnail?.replace("http://", "https://") ?: "",
        smallThumbnail =     info?.imageLinks?.smallThumbnail
            ?.replace("http://", "https://")
            ?: info?.imageLinks?.thumbnail
                ?.replace("http://", "https://")
            ?: ""
    )
}

fun BookEntity.toDomain(): Book {
    return Book(
        id = id,
        title = title,
        authors = authors,
        publishedDate = publishedDate,
        description = description,
        pageCount = pageCount,
        thumbnail = thumbnail,
        smallThumbnail = smallThumbnail
    )
}

fun Book.toEntity(searchQuery: String): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        authors = authors,
        publishedDate = publishedDate,
        description = description,
        pageCount = pageCount,
        thumbnail = thumbnail,
        searchQuery = searchQuery,
        smallThumbnail = smallThumbnail
    )
}