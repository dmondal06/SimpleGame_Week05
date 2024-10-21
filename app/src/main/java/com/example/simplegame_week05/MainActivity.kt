package com.example.simplegame_week05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            //  NavHost setup for both the splash screen and quiz navigation
            NavHost(navController = navController, startDestination = "splash") {
                // Splash screen route
                composable("splash") {
                    SplashScreen(navController = navController)
                }

                // Quiz route that launches the quiz questions
                composable("quiz") {
                    QuizApp()  // this launches the QuizApp once Start Now is clicked
                }
            }
        }
    }
}
