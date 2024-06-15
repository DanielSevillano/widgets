package com.daniel.widgets

import android.content.Context
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.ImageProvider
import androidx.glance.appwidget.CheckBox
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.Text

class WidgetTexto : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Box(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .background(GlanceTheme.colors.widgetBackground),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "¡Hola Glance!")
            }
        }
    }
}

class WidgetLista : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Scaffold(
                titleBar = {
                    TitleBar(
                        startIcon = ImageProvider(R.drawable.ic_launcher_foreground),
                        title = "Personajes"
                    )
                }
            ) {
                LazyColumn(
                    modifier = GlanceModifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    items(Persona.entries) { persona ->
                        Row(
                            modifier = GlanceModifier.padding(bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CheckBox(checked = true, onCheckedChange = {})
                            Spacer(modifier = GlanceModifier.width(4.dp))
                            Text(text = "${persona.nombre} ${persona.apellido}")
                        }
                    }
                }
            }
        }
    }
}

class WidgetTextoReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = WidgetTexto()
}

class WidgetListaReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = WidgetLista()
}