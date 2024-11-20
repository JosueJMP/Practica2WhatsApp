package com.example.aplicacionwhatsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aplicacionwhatsapp.ChatScreen
import com.example.aplicacionwhatsapp.WhatsAppScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            WhatsAppScreen(navController = navController)
        }
        composable("chat/{chatName}") { backStackEntry ->
            val chatName = backStackEntry.arguments?.getString("chatName")
            ChatScreen(chatName = chatName)
        }
    }
}