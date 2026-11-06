package com.example.smartvolt.model.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinos(val ruta: String) {
    object Inicio : Destinos("inicio")
    object Login : Destinos("login")
    object Home : Destinos("home") // contenedor con la barra inferior
    object EscanerQr : Destinos("escaner_qr")

    // Pestañas de la barra inferior
    sealed class Inferior(
        ruta: String,
        val etiqueta: String,
        val icono: ImageVector
    ) : Destinos(ruta) {
        object InicioUsuario : Inferior("inicio_usuario", "Inicio", Icons.Filled.Home)
        object Calendario : Inferior("asistencia", "Asistencia", Icons.Filled.CalendarMonth)
        object Marcaje : Inferior("marcaje", "Marcaje", Icons.Filled.AccessTimeFilled)
        object Perfil : Inferior("perfil", "Perfil", Icons.Filled.AccountCircle)
        object Menu : Inferior("menu", "Menú", Icons.Filled.Menu)
    }
}

val destinosInferiores = listOf(
    Destinos.Inferior.InicioUsuario,
    Destinos.Inferior.Calendario,
    Destinos.Inferior.Marcaje,
    Destinos.Inferior.Perfil,
    Destinos.Inferior.Menu
)