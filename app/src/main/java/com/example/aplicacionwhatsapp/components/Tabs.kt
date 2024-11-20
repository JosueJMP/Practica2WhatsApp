package com.example.aplicacionwhatsapp.components

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Tabs() {
    TabRow(selectedTabIndex = 0, containerColor = Color(0xFF075E54)) {
        listOf("CHATS", "ESTADOS", "LLAMADAS").forEachIndexed { index, title ->
            Tab(
                selected = index == 0,
                onClick = {  },
                text = { Text(text = title, color = Color.White) }
            )
        }
    }
}