package com.example.googlebooksapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.googlebooksapi.BooksRoute
import com.example.googlebooksapi.domain.model.Book
import com.example.googlebooksapi.ui.screens.BookDetailScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.BOOKS,
        modifier = modifier
    ) {
        composable(Routes.BOOKS) {
            BooksRoute(
                onBookClick = { book ->
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("book", book)
                    navController.navigate(Routes.BOOK_DETAIL)
                }
            )
        }
        composable(Routes.BOOK_DETAIL) {
            val book = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Book>("book")

            if (book != null) {
                BookDetailScreen(
                    book = book,
                    onBackClick = { navController.popBackStack() }
                )
            }

        }
    }

}
