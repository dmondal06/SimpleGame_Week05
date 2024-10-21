package com.example.simplegame_week05

import androidx.compose.foundation.layout.Box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplegame_week05.ui.theme.SimpleGame_Week05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // This enables edge-to-edge display
        setContent {
            SimpleGame_Week05Theme {
                // Directly call QuizApp and use Modifier for padding and full size
                QuizApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun QuizApp(modifier: Modifier = Modifier) {
    // Apply the modifier to your existing QuizApp
    Box(modifier = modifier) {
        // Call your existing QuizApp composable with navigation and screens
        QuizApp()  // Launch the app navigation and quiz logic here
    }
}
