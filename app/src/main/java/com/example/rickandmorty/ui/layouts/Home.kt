package com.example.rickandmorty.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmorty.ui.components.EndpointList

@Composable
fun Home(navController: NavController) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(modifier = Modifier.padding(start = 0.dp, end = 0.dp, top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 56.dp, bottom = 0.dp )) {
            item {
                EndpointList(navController = navController)
            }
        }
        TopAppBar(
            title = {
                Text(
                    ("Rick and Morty").uppercase(),
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                )
            },
            backgroundColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(WindowInsets.statusBars.asPaddingValues())
        )
    }
}