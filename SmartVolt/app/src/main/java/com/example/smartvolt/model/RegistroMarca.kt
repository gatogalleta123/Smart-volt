package com.example.smartvolt.model

/**
 * Los 6 tipos de marca según el flujo de la aplicación :
 * - ENTRADA: Inicio de la jornada laboral.
 * - SALIDA: Término de la jornada laboral.
 * - ENTRADA_COLACION: Inicio del periodo de colación.
 * - SALIDA_COLACION: Término del periodo de colación y regreso al trabajo.
 * - ENTRADA_HORAS_EXTRA: Inicio de horas extraordinarias.
 * - SALIDA_HORAS_EXTRA: Término de horas extraordinarias.
 */
enum class TipoMarca(val tituloDisplay: String) {
    ENTRADA("Marca de entrada"),
    SALIDA("Marca de salida"),
    ENTRADA_COLACION("Inicio de colación"),
    SALIDA_COLACION("Término de colación"),
    ENTRADA_HORAS_EXTRA("Inicio horas extra"),
    SALIDA_HORAS_EXTRA("Término horas extra")
}

/**
 * Estados de validación de la marca de asistencia
 */
enum class EstadoMarca {
    VALIDADA,
    PENDIENTE
}

data class RegistroMarca(
    val id: String = "",
    val tipo: TipoMarca = TipoMarca.ENTRADA,
    val hora: String = "08:30 a.m.",
    val fecha: String = "23 de octubre",
    val ubicacionFaena: String = "Faena Obra Norte",
    val estado: EstadoMarca = EstadoMarca.VALIDADA
)