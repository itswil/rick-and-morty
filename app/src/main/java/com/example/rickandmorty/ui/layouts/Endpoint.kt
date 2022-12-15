package com.example.rickandmorty.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmorty.viewmodel.EndpointViewModel

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
        }, backgroundColor = MaterialTheme.colorScheme.primary, navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "backIcon",
                    tint = MaterialTheme.colorScheme.background
                )
            }
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(WindowInsets.statusBars.asPaddingValues())
        )

        if (endpointViewModel.errorMessage.isNotEmpty()) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = endpointViewModel.errorMessage)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 0.dp,
                        end = 0.dp,
                        top = WindowInsets.statusBars
                            .asPaddingValues()
                            .calculateTopPadding() + 56.dp,
                        bottom = 0.dp
                    )
            ) {
                when (endpointType) {
                    "characters" -> {
                        items(endpointViewModel.characterResponse.value.results) { character ->
//                            CharacterItem(character = character)
                            Text(text = character.name)
                        }
                    }
                    "locations" -> {
                        println(endpointViewModel.locationResponse.value)
                        items(endpointViewModel.locationResponse.value.results) { location ->
                            Text(text = location.name)
                        }
                    }
                    "episodes" -> {
                        items(endpointViewModel.episodeResponse.value.results) { episode ->
                            Text(text = episode.name)
                        }
                    }
                }
            }
        }
    }
}