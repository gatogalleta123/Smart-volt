package com.example.smartvolt.model.domain

/** Días de la semana usados en la jornada laboral. */
enum class DiaSemana(val abreviatura: String, val nombre: String) {
    LUNES("Lu", "Lunes"),
    MARTES("Ma", "Martes"),
    MIERCOLES("Mi", "Miércoles"),
    JUEVES("Ju", "Jueves"),
    VIERNES("Vi", "Viernes"),
    SABADO("Sá", "Sábado"),
    DOMINGO("Do", "Domingo")
}

/** Datos del trabajador que se muestran en el perfil (solo lectura). Datos ficticios en el MVP. */
data class DatosTrabajador(
    val rut: String = "",
    val nombreCompleto: String = "",
    val cargo: String = "",
    val areaTrabajo: String = "",
    val tipoContrato: String = "",
    val horasSemanales: Int = 0,
    val diasJornada: Set<DiaSemana> = emptySet(),
    val fechaIngreso: String = "",
    val sueldoBruto: Long = 0L,
    val sueldoLiquido: Long = 0L
)