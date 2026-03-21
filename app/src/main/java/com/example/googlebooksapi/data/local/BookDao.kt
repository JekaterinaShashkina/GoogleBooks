package com.example.googlebooksapi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<BookEntity>)

    @Query("SELECT * FROM books WHERE searchQuery = :query")
    suspend fun getAllBooks(query: String): List<BookEntity>

    @Query("SELECT DISTINCT searchQuery FROM books ORDER BY rowid DESC LIMIT 5")
    suspend fun getLastQueries(): List<String>

    @Query("DELETE FROM books WHERE searchQuery = :query")
    suspend fun clearBooks(query: String)

    @Query("DELETE FROM books WHERE searchQuery NOT IN (SELECT DISTINCT searchQuery FROM books ORDER BY rowid DESC LIMIT 5)")
    suspend fun keepOnlyLastFiveQueries()
}