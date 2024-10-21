package com.example.simplegame_week05

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StatsScreen(navController: NavController, finalScore: Int, totalQuestions: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Quiz Complete!",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Displays the final score
        Text(
            text = "You answered $finalScore/$totalQuestions questions correctly!",
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("question/0") }) {
            Text(text = "Restart Quiz")
        }
    }
}
