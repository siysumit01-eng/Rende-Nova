package com.example.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Services : Screen("services", "Services", Icons.Default.Star)
    object Contact : Screen("contact", "Contact", Icons.Default.Phone)
    object Login : Screen("login", "Login", Icons.Default.Lock)
}

val BottomNavigationScreens = listOf(
    Screen.Home,
    Screen.Services,
    Screen.Contact,
    Screen.Login
)
