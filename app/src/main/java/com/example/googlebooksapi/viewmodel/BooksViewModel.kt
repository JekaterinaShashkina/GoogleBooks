package com.example.googlebooksapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebooksapi.domain.model.Book
import com.example.googlebooksapi.domain.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val booksRepository: BooksRepository
) : ViewModel(
) {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books.asStateFlow()

    init {
        searchBooks("kotlin")
    }

    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                _books.value = booksRepository.searchBooks(query)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}