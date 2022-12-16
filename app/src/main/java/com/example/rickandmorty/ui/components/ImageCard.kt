package com.example.rickandmorty.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmorty.Screen

@Composable
fun ImageCard(
    image: Painter,
    description: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    title: String,
    endpointType: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(bottom = 16.dp)
            .clickable {
                navController.navigate(
                    "${Screen.EndpointScreen.route}/$endpointType"
                )
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box(contentAlignment = Alignment.BottomStart) {
            Image(
                painter = image,
                contentDescription = description,
                contentScale = ContentScale.FillHeight,
            )
            Text(
                text = (title).uppercase(),
                modifier = modifier
                    .alpha(0.80F)
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(16.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}