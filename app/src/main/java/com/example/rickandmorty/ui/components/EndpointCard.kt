package com.example.rickandmorty.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmorty.R
import com.example.rickandmorty.ui.theme.Typography

@Composable
fun EndpointItem(
    name: String,
    description: String,
    imageUrl: String? = null,
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                println("Clicked")
            },
    ) {
        Row {
            if (imageUrl != null) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = name,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = "Placeholder",
                    modifier = Modifier
                        .padding(
                            end = 16.dp
                        )
                        .clip(shape = RoundedCornerShape(16.dp))
                )
            }
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                Text(
                    text = name,
                    color = MaterialTheme.colorScheme.primary,
                    style = Typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description,
                    color = MaterialTheme.colorScheme.secondary,
                    style = Typography.titleSmall,
                )
            }
        }
    }
}