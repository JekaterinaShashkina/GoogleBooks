package com.example.googlebooksapi.domain.model

data class Book(
    val id: String,
    val title: String,
    val authors: String,
    val publishedDate: String,
    val description: String,
    val pageCount: Int,
    val smallThumbnail: String,
    val thumbnail: String
)
