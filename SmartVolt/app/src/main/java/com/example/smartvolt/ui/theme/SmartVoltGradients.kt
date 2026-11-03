package com.example.smartvolt.ui.theme

import androidx.compose.ui.graphics.Brush

object SmartVoltGradients {

    // ========================================
    // INICIO DE SESIÓN
    // Azul luminoso hacia azul profundo
    // ========================================

    val LoginBackground = Brush.verticalGradient(
        colorStops = arrayOf(
            0.00f to AzulBase,
            0.25f to AzulProfundo,
            0.77f to AzulMarino,
            1.00f to AzulNoche
        )
    )

    // ========================================
    // BOTÓN PRINCIPAL DE ASISTENCIA
    // ========================================

    val AttendanceButton = Brush.verticalGradient(
        colors = listOf(
            AzulCorporativo,
            AzulProfundo
        )
    )

    // ========================================
    // BOTONES SECUNDARIOS
    // ========================================

    val SecondaryButton = Brush.verticalGradient(
        colors = listOf(
            AzulProfundo,
            AzulMarino
        )
    )

    // ========================================
    // DECORACIÓN AZUL LUMINOSA
    // ========================================

    val BlueDecoration = Brush.linearGradient(
        colors = listOf(
            AzulProfundo,
            AzulCorporativo,
            AzulElectrico
        )
    )

    // ========================================
    // BOTÓN AMARILLO
    // ========================================

    val YellowButton = Brush.verticalGradient(
        colors = listOf(
            AmarilloPrincipal,
            AmarilloCalido
        )
    )

    // ========================================
    // TARJETA DE MARCAJE
    // ========================================

    // Online: azul noche (navy-900, 0%) -> azul brillante (blue-900, 100%)
    val MarcajeOnline = Brush.verticalGradient(
        colors = listOf(
            AzulNoche,
            AzulElectrico
        )
    )

    // Sin conexión: dorado (gold-900, 0%) -> amarillo (gold-400, 100%)
    val MarcajeOffline = Brush.verticalGradient(
        colors = listOf(
            AmarilloOro,
            AmarilloPrincipal
        )
    )
}