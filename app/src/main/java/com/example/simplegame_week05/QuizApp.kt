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

    // This defines a list of questions for the quiz
    val questions = listOf(
        Question(
            questionText = "Which animal can hold its breath the longest?",
            options = listOf("Elephant", "Dolphin", "Sea Turtle", "Sperm Whale"),
            correctAnswerIndex = 3
        ),

        Question(
            questionText = "If you have 3 apples and you take away 2, how many apples do you have?",
            options = listOf("1", "2", "3", "0"),
            correctAnswerIndex = 1
        ),

        Question(
            questionText = "Which is heavier, a pound of feathers or a pound of bricks?",
            options = listOf("Feathers", "Bricks", "They weigh the same", "Depends on the wind"),
            correctAnswerIndex = 2
        ),

        Question(
            questionText = "Which planet in our solar system could float in water?",
            options = listOf("Earth", "Saturn", "Mars", "Jupiter"),
            correctAnswerIndex = 1
        ),

        Question(
            questionText = "How many months have 28 days?",
            options = listOf("1", "12", "6", "Depends on the year"),
            correctAnswerIndex = 1
        ),

        Question(
            questionText = "What is the only letter not in any U.S. state name?",
            options = listOf("Z", "X", "Q", "J"),
            correctAnswerIndex = 2
        ),

        Question(
            questionText = "What happens if you throw a blue stone into the Red Sea?",
            options = listOf("It floats", "It sinks", "It turns red", "It disappears"),
            correctAnswerIndex = 1
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
