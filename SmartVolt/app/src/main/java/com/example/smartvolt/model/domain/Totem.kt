package com.example.smartvolt.model.domain

/** Baliza BLE de faena (datos ficticios en el MVP). */
data class Totem(
    val id: String,
    val nombre: String
)

/** Pasos del flujo de validación al marcar entrada. */
enum class PasoValidacion {
    INACTIVO,
    BUSCANDO_TOTEMS,
    SELECCION_TOTEM,
    SOLICITANDO_CAMARA,
    CONFIRMAR_FOTO
}