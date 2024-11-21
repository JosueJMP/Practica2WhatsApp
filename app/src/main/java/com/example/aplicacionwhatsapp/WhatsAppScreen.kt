package com.example.aplicacionwhatsapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

import com.example.aplicacionwhatsapp.components.ChatList
import com.example.aplicacionwhatsapp.components.Tabs
import com.example.aplicacionwhatsapp.components.TopBar


@Composable
fun WhatsAppScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBar() },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Tabs()
                ChatList(navController = navController)
            }
        }
    )
}