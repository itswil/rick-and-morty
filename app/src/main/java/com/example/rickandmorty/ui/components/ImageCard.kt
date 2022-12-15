package com.example.rickandmorty.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
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
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
            .clickable {
                navController.navigate(
                    "${Screen.EndpointScreen.route}/$endpointType"
                )
            },
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp,
    ) {
        Image(
            painter = image,
            contentDescription = description,
            contentScale = ContentScale.FillHeight,
        )
        Box(contentAlignment = Alignment.BottomStart) {
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