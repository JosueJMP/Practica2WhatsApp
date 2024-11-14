package com.example.aplicacionwhatsapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppScreen() {
    Scaffold(
        topBar = { TopBar() },
        content = { paddingValues ->
            WhatsAppContent(modifier = Modifier.padding(paddingValues))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "WhatsApp", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF075E54)
        ),
        actions = {

        }
    )
}

@Composable
fun WhatsAppContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Tabs()
        ChatList()
    }
}

@Composable
fun Tabs() {
    TabRow(selectedTabIndex = 0, containerColor = Color(0xFF075E54)) {
        listOf("CHATS", "ESTADOS", "LLAMADAS").forEachIndexed { index, title ->
            Tab(
                selected = index == 0,
                onClick = { /* Cambiar entre pestañas */ },
                text = { Text(text = title, color = Color.White) }
            )
        }
    }
}

@Composable
fun ChatList() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        Text("Lista de chats", color = Color.Gray, fontSize = 16.sp)

       //chats con los sinverguenzas
        ChatItem(chatName = "Angelote")
        ChatItem(chatName = "Raul Jabalí")
        ChatItem(chatName = "Luis")
        ChatItem(chatName = "Grupo: Representando a la mayoría")
    }
}

@Composable
fun ChatItem(chatName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = chatName,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WhatsAppScreenPreview() {
    WhatsAppScreen()
}
