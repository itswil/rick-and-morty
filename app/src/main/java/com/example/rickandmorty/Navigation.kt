package com.example.rickandmorty

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmorty.ui.layouts.Endpoint
import com.example.rickandmorty.ui.layouts.Home
import com.example.rickandmorty.viewmodel.CharacterViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val characterViewModel = CharacterViewModel()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            Home(navController = navController)
        }
        composable(
            route = "${Screen.EndpointScreen.route}/{endpointType}",
            arguments = listOf(navArgument("endpointType") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("endpointType")?.let { Endpoint(navController, characterViewModel, it) }
        }
    }

}