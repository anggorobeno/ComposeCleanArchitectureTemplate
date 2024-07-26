package com.example.composecleanarchitecturetemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composecleanarchitecturetemplate.feature.main.ui.MainScreen


const val HOME_SCREEN = "home-screen"


val listScreen = listOf(
    HOME_SCREEN
)

@Composable
fun QrisNavigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = HOME_SCREEN
    ) {
        composable(route = HOME_SCREEN) {
            MainScreen(navController)
        }
    }
}
