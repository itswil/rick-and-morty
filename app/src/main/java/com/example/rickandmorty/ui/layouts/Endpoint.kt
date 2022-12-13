package com.example.rickandmorty.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Endpoint(navController: NavController, endpointType: String) {
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
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "I am the Endpoint screen for: $endpointType")
        }
    }
}