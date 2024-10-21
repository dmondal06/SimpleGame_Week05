package com.example.simplegame_week05

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var score by remember { mutableStateOf(0) }  // Track the score

    // Define a list of questions for the quiz
    val questions = listOf(
        Question(
            questionText = "What animal is Walt Disney's Dumbo?",
            options = listOf("Deer", "Rabbit", "Elephant", "Donkey"),
            correctAnswerIndex = 2
        ),
        Question(
            questionText = "Which is the largest planet in our solar system?",
            options = listOf("Earth", "Mars", "Jupiter", "Saturn"),
            correctAnswerIndex = 2
        ),
        Question(
            questionText = "Who wrote 'To Kill a Mockingbird'?",
            options = listOf("Harper Lee", "Mark Twain", "J.K. Rowling", "Charles Dickens"),
            correctAnswerIndex = 0
        ),
        Question(
            questionText = "What is the capital of Australia?",
            options = listOf("Sydney", "Melbourne", "Canberra", "Brisbane"),
            correctAnswerIndex = 2
        ),
        Question(
            questionText = "What is the smallest prime number?",
            options = listOf("1", "2", "3", "5"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Which element has the chemical symbol 'O'?",
            options = listOf("Oxygen", "Gold", "Hydrogen", "Iron"),
            correctAnswerIndex = 0
        ),
        Question(
            questionText = "Which country is home to the kangaroo?",
            options = listOf("Australia", "New Zealand", "South Africa", "Canada"),
            correctAnswerIndex = 0
        )
    )

    // Box to fill the screen and apply any necessary modifiers, including black background
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)  // Set background color to black
    ) {
        // Navigation between different screens
        NavHost(navController = navController, startDestination = "question/0") {
            // Dynamically load question screens by index
            questions.forEachIndexed { index, _ ->
                composable("question/$index") {
                    QuestionScreen(
                        question = questions[index],
                        navController = navController,
                        nextRoute = if (index == questions.size - 1) "stats" else "question/${index + 1}",
                        currentScore = score,  // Pass the current score
                        updateScore = { isCorrect ->
                            if (isCorrect) score += 1  // Increment score if correct
                        }
                    )
                }
            }

            // Final stats screen after all questions are answered
            composable("stats") {
                StatsScreen(navController = navController, finalScore = score, totalQuestions = questions.size)
            }
        }
    }
}
