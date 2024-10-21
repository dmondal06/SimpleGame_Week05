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
import androidx.navigation.NavController


@Composable
fun SplashScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val logo: Painter = painterResource(id = R.drawable.quizlogo)
            Image(
                painter = logo,
                contentDescription = "Quiz Logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 24.dp)
            )


            Spacer(modifier = Modifier.height(32.dp))

            // Start Now button to begin the quiz
            Button(
                onClick = {
                    // Navigates to the quiz screen when the button is clicked
                    navController.navigate("quiz")
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Start Now", color = Color.White)
            }
        }
    }
}
