package com.example.googlebooksapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.googlebooksapi.domain.model.Book
import com.example.googlebooksapi.ui.navigation.AppNavHost
import com.example.googlebooksapi.ui.screens.BooksScreen
import com.example.googlebooksapi.ui.theme.GoogleBooksAPITheme
import com.example.googlebooksapi.viewmodel.BooksViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}

@Composable
fun BooksRoute(
    onBookClick: (Book) -> Unit,
    viewModel: BooksViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val totalItems by viewModel.totalItems.collectAsState()

    BooksScreen(
        books = books,
        isLoading = isLoading,
        error = error,
        totalItems = totalItems,
        onSearch = { query -> viewModel.searchBooks(query) },
        onBookClick = onBookClick
    )
}
