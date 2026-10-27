package com.example.smartvolt.ui.theme

import androidx.compose.ui.graphics.Brush

object SmartVoltGradients {

    // ========================================
    // INICIO DE SESIÓN
    // Azul luminoso hacia azul profundo
    // ========================================

    val LoginBackground = Brush.verticalGradient(
        colors = listOf(
            AzulElectrico,
            AzulCorporativo,
            AzulProfundo
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
}