package com.example.aplicacionwhatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aplicacionwhatsapp.ui.theme.AplicacionWhatsappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionWhatsappTheme {
                WhatsAppScreen() //LLamada a pantalla de Whatsapp
            }
        }
    }
}