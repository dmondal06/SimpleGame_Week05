package com.example.simplegame_week05

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun QuestionScreen(
    question: Question,
    navController: NavController,
    nextRoute: String,
    currentScore: Int,
    updateScore: (Boolean) -> Unit // Function to update score
) {
    var selectedOption by remember { mutableStateOf(-1) }
    var showError by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) } // State to control popup dialog
    var isCorrect by remember { mutableStateOf(false) }  // State to determine if the answer is correct

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the current score
        Text(
            text = "Score: $currentScore",
            fontSize = 24.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the question text in white
        Text(
            text = question.questionText,
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display each option as a RadioButton with white text
        question.options.forEachIndexed { index, option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                RadioButton(
                    selected = selectedOption == index,
                    onClick = { selectedOption = index }
                )
                Text(
                    text = option,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        if (showError) {
            Text(
                text = "Please select an answer",
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Confirm button to check if the answer is correct and show dialog
        Button(
            onClick = {
                if (selectedOption == -1) {
                    showError = true
                } else {
                    // Check if the selected option is correct
                    isCorrect = selectedOption == question.correctAnswerIndex
                    updateScore(isCorrect)  // Update the score if correct
                    showDialog = true  // Show the popup dialog
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Confirm")
        }

        // Dialog to show the result of the answer
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = if (isCorrect) "You're Correct!" else "Oops! Wrong Answer",
                        color = if (isCorrect) Color.Black else Color.Red
                    )
                },
                text = {
                    if (!isCorrect) {
                        Text(
                            text = "The correct answer is: ${question.options[question.correctAnswerIndex]}",
                            color = Color.Black
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            // Navigate to the next question or stats screen
                            navController.navigate(nextRoute)
                        }
                    ) {
                        Text("Next")
                    }
                }
            )
        }
    }
}
