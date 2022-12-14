package com.example.rickandmorty.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmorty.ui.components.EndpointItem
import com.example.rickandmorty.viewmodel.EndpointViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Endpoint(
    navController: NavController, endpointViewModel: EndpointViewModel, endpointType: String
) {
    LaunchedEffect(Unit, block = {
        when (endpointType) {
            "characters" -> {
                endpointViewModel.getCharacterResponse()
            }
            "locations" -> {
                endpointViewModel.getLocationResponse()
            }
            "episodes" -> {
                endpointViewModel.getEpisodeResponse()
            }
        }
    })

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        TopAppBar(title = {
            Text(
                (endpointType).uppercase(),
                color = MaterialTheme.colorScheme.background,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.background
        ), navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "backIcon",
                    tint = MaterialTheme.colorScheme.background
                )
            }
        })

        if (endpointViewModel.isLoading) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }

        if (endpointViewModel.errorMessage.isNotEmpty()) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = endpointViewModel.errorMessage)
            }
        }

        if (!endpointViewModel.isLoading && endpointViewModel.errorMessage.isEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 0.dp, end = 0.dp,
                        top = WindowInsets.statusBars
                            .asPaddingValues()
                            .calculateTopPadding() + TopAppBarDefaults.windowInsets
                            .asPaddingValues()
                            .calculateTopPadding() * 2 + 16.dp,
                        bottom = 0.dp,
                    ), contentPadding = PaddingValues(
                    bottom = 16.dp, top = 8.dp
                )
            ) {
                when (endpointType) {
                    "characters" -> {
                        items(endpointViewModel.characterResponse.value.results) { character ->
                            EndpointItem(
                                name = character.name,
                                description = "${character.gender} ${character.species} at ${character.origin.name}",
                                imageUrl = character.image
                            )
                        }
                    }
                    "locations" -> {
                        items(endpointViewModel.locationResponse.value.results) { location ->
                            EndpointItem(
                                name = location.name,
                                description = "${location.type} in ${location.dimension}"
                            )
                        }
                    }
                    "episodes" -> {
                        items(endpointViewModel.episodeResponse.value.results) { episode ->
                            EndpointItem(
                                name = episode.name,
                                description = "Episode ${episode.episode} aired on ${episode.air_date}"
                            )
                        }
                    }
                }
            }
        }
    }
}