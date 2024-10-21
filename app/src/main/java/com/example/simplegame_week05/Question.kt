package com.example.simplegame_week05


// This is the data class for questions
data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
