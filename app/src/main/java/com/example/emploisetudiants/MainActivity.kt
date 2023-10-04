package com.example.emploisetudiants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.emploisetudiants.screen.ScreenMain
import com.example.emploisetudiants.ui.theme.EmploisEtudiantsTheme

data class Message(val author: String, val body: String)
data class Offer(val title: String, val location: String, val salary: String, val contractType: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmploisEtudiantsTheme {
                ScreenMain()
            }
        }
    }
}
