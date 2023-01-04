package com.example.rickandmorty.widget

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.Text
import com.example.rickandmorty.R

val touchUnitSize = 44.dp

class SearchWidget : GlanceAppWidget() {
    @Composable
    override fun Content() {
        Row(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalAlignment = Alignment.CenterVertically,
            modifier = GlanceModifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            SearchBar()
            SpacerCustom()
            Shortcut("1")
            SpacerCustom()
            Shortcut("2")
            SpacerCustom()
            Shortcut("3")
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = GlanceModifier.cornerRadius(touchUnitSize).padding(8.dp)
            .background(color = MaterialTheme.colorScheme.surfaceVariant).height(touchUnitSize)
            .width(touchUnitSize * 3.5f),
        horizontalAlignment = Alignment.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            provider = ImageProvider(R.mipmap.ic_launcher_round),
            contentDescription = "Search",
            modifier = GlanceModifier.height(touchUnitSize - 8.dp).width(touchUnitSize - 8.dp)
                .padding(end = 8.dp)
        )
        Text(text = "Search")
    }
}

@Composable
fun Shortcut(customText: String) {
    Box(
        modifier = GlanceModifier.cornerRadius(touchUnitSize)
            .background(color = MaterialTheme.colorScheme.surfaceVariant).size(touchUnitSize),
        contentAlignment = Alignment.Center
    ) {
        Text(text = customText)
    }
}

@Composable
fun SpacerCustom() {
    Spacer(modifier = GlanceModifier.width(8.dp))
}

class SearchWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget = SearchWidget()
}