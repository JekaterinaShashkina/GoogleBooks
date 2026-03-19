package com.example.googlebooksapi.di

import com.example.googlebooksapi.domain.repository.BooksRepository
import com.example.googlebooksapi.domain.repository.BooksRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindBooksRepository(
        booksRepositoryImpl: BooksRepositoryImpl
    ): BooksRepository
}