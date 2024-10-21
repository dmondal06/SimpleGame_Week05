package com.example.quizapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplegame_week05.Question
import com.example.simplegame_week05.QuestionScreen
import com.example.simplegame_week05.StatsScreen
import kotlinx.coroutines.delay



@Composable
fun QuizApp() {
    val navController = rememberNavController()

    // List of questions
    val questions = listOf(
        Question(
            questionText = "What animal is Walt Disney's Dumbo?",
            options = listOf("Deer", "Rabbit", "Elephant", "Donkey"),
            correctAnswerIndex = 2
        ),
        // Add more questions here
    )

    NavHost(navController = navController, startDestination = "splash") {
        // Splash screen
        composable("splash") {
            SplashScreen(navController = navController)
        }

        // Dynamically load each question based on the index
        composable("question/{questionIndex}") { backStackEntry ->
            val questionIndex = backStackEntry.arguments?.getString("questionIndex")?.toInt() ?: 0
            if (questionIndex < questions.size) {
                QuestionScreen(
                    question = questions[questionIndex],
                    navController = navController,
                    nextRoute = if (questionIndex == questions.size - 1) "stats" else "question/${questionIndex + 1}"
                )
            }
        }

        // Final stats screen after all questions
        composable("stats") {
            StatsScreen(navController = navController)
        }
    }
}

// Splash Screen
@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3000) // 3-second delay for splash screen
        navController.navigate("question/0") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Welcome to the Quiz App!",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
