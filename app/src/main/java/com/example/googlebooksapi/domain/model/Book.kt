package com.example.googlebooksapi.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val id: String,
    val title: String,
    val authors: String,
    val publishedDate: String,
    val description: String,
    val pageCount: Int,
    val smallThumbnail: String,
    val thumbnail: String
) : Parcelable
