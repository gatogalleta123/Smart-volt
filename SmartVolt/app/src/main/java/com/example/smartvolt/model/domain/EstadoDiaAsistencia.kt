package com.example.smartvolt.model.domain

/**
 * Estado de un día en el calendario de asistencia.
 * Los colores de cada estado se definen en un solo lugar:
 * CalendarioAsistenciaDialog.kt -> colorFondoDia().
 */
enum class EstadoDiaAsistencia {
    ASISTIDO,    // azul
    AUSENTE,     // rojo
    NO_LABORAL,  // gris
    HOY          // celeste
}