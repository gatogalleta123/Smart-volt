package com.example.smartvolt.model

/** Estado de verificación de un permiso o sensor en la pantalla de marcaje */
enum class EstadoVerificacion {
    CORRECTO,     // ✓ verde
    ADVERTENCIA,  // ! naranja
    ERROR         // ✗ rojo
}