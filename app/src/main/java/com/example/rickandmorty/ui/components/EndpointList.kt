package com.example.rickandmorty.ui.components

import ImageCard
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickandmorty.R

@Composable
fun EndpointList(navController: NavController) {
    ImageCard(
        image = painterResource(id = R.drawable.location_1),
        description = "Location 1",
        navController = navController,
        title = "Characters",
        endpointType = "characters"
    )
    ImageCard(
        image = painterResource(id = R.drawable.location_2),
        description = "Location 2",
        navController = navController,
        title = "Locations",
        endpointType = "locations"
    )
    ImageCard(
        image = painterResource(id = R.drawable.location_3),
        description = "Location 3",
        navController = navController,
        title = "Episodes",
        endpointType = "episodes"
    )
    Spacer(modifier = Modifier.padding(bottom = 32.dp))
}