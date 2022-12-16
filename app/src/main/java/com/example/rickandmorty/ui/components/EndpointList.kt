package com.example.rickandmorty.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.rickandmorty.R

data class Endpoint(
    val title: String, val description: String, val image: Int, val endpointType: String
)

val endpoints = listOf(
    Endpoint(
        title = "Characters",
        description = "View all the characters in the Rick and Morty universe",
        image = R.drawable.location_1,
        endpointType = "characters"
    ), Endpoint(
        title = "Locations",
        description = "View all the locations in the Rick and Morty universe",
        image = R.drawable.location_2,
        endpointType = "locations"
    ), Endpoint(
        title = "Episodes",
        description = "View all the episodes in the Rick and Morty universe",
        image = R.drawable.location_3,
        endpointType = "episodes"
    )
)

@Composable
fun EndpointList(navController: NavController) {
    endpoints.forEach { endpoint ->
        ImageCard(
            title = endpoint.title,
            description = endpoint.description,
            image = painterResource(id = endpoint.image),
            navController = navController,
            endpointType = endpoint.endpointType,
        )
    }
}