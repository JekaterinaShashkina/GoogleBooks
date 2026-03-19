package com.example.googlebooksapi.data.remote

data class BooksResponseDto(
    val totalItems: Int,
    val items: List<BookItemDto>
) {
    data class BookItemDto(
        val id: String,
        val volumeInfo: VolumeInfoDto?

    )
    data class VolumeInfoDto(
        val title: String?,
        val authors: List<String>?,
        val publishedDate: String?,
        val description: String?,
        val pageCount: Int?,
        val imageLinks: ImageLinksDto?
    )
    data class ImageLinksDto(
        val smallThumbnail: String?,
        val thumbnail: String?

    )
}