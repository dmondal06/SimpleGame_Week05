package com.example.simplegame_week05

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simplegame_week05.R

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)  // Set background color to black
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the quiz logo (replace with your actual logo)
            val logo: Painter = painterResource(id = R.drawable.quizlogo)
            Image(
                painter = logo,
                contentDescription = "Quiz Logo",
                modifier = Modifier
                    .size(200.dp)  // Adjust size as needed
                    .padding(bottom = 24.dp)
            )

            // Display splash screen text in white
            Text(
                text = "Welcome to the Quiz App!",
                fontSize = 32.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Start Now button to begin the quiz
            Button(
                onClick = {
                    // Navigate to the quiz screen when the button is clicked
                    navController.navigate("quiz")
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Start Now", color = Color.White)
            }
        }
    }
}
