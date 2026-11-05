package com.example.smartvolt.model.domain

/** Estado visual de una marca dentro de la pantalla Asistencia. */
enum class EstadoMarcaDetalle(val etiqueta: String) {
    VALIDADA("Validada"),
    PENDIENTE("Pendiente"),
    SIN_REGISTRAR("Sin registrar")
}

/** Estado de aprobación de una jornada con horas extra. */
enum class EstadoJornadaExtra(val etiqueta: String) {
    APROBADAS("Aprobadas"),
    PENDIENTE("Pendiente"),
    RECHAZADAS("Rechazadas")
}

/** Marca mostrada en las listas de la pantalla Asistencia (usar datos ficticios en el MVP). */
data class MarcaDetalle(
    val id: String = "",
    val titulo: String,
    val fecha: String,
    val faena: String,
    val hora: String,
    val estado: EstadoMarcaDetalle
)

/** Jornada con horas extra y las marcas asociadas (entrada / salida). */
data class JornadaHorasExtra(
    val id: String,
    val fecha: String,
    val horario: String,
    val estado: EstadoJornadaExtra,
    val marcas: List<MarcaDetalle>
)