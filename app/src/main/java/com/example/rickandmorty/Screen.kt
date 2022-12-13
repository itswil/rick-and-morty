package com.example.rickandmorty

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object EndpointScreen : Screen("endpoint_screen")
}