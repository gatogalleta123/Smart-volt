package com.example.smartvolt.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

data class DestinoInferior(
    val ruta: String,
    val etiqueta: String,
    val icono: ImageVector
)

val destinosInferiores = listOf(
    DestinoInferior("inicio_usuario", "Inicio", Icons.Filled.Home),
    DestinoInferior("calendario", "Calendario", Icons.Filled.CalendarMonth),
    DestinoInferior("marcaje", "Marcaje", Icons.Filled.AccessTimeFilled),
    DestinoInferior("perfil", "perfil", Icons.Filled.AccountCircle),
    DestinoInferior("menu", "Menú", Icons.Filled.Menu)
)