package com.example.aplicacionwhatsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(chatName: String?, navController: NavHostController) {
    val displayName = chatName ?: "Chat desconocido"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ChatTopBar(displayName = displayName, navController = navController)
        ChatContent(displayName = displayName)

    }
}

@Composable
fun ChatTopBar(displayName: String, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF075E54))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = displayName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Composable
fun ChatContent(displayName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        // Títulos y saludo
        Text(
            text = "Bienvenido al chat de $displayName",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Conversación
        Conversation()
    }
}

@Composable
fun Conversation() {
    // Lista de mensajes simulados
    val messages = listOf(
        "Que ase cabesa",
        "Aqui con el LOL",
        "Vá perdéh",
        "Diamante soy"
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        messages.forEachIndexed { index, message ->
            MessageBubble(message = message, isSender = index % 2 == 0)
        }
    }
}

@Composable
fun MessageBubble(message: String, isSender: Boolean) {
    val backgroundColor = if (isSender) Color(0xFFDCF8C6) else Color(0xFFE5E5E5)
    val textColor = if (isSender) Color.Black else Color.Black

    Row(
        horizontalArrangement = if (isSender) Arrangement.End else Arrangement.Start,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(backgroundColor, shape = MaterialTheme.shapes.medium)
                .padding(8.dp)
        ) {
            Text(text = message, color = textColor)
        }
    }
}


