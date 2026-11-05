package com.example.smartvolt.model.domain

enum class EstadoUbicacion {
    VERIFICADA,
    SIMULADA,
    SIN_SENAL,
    SIN_PERMISO
}

data class LecturaUbicacion(
    val estado: EstadoUbicacion,
    val latitud: Double? = null,
    val longitud: Double? = null,
    val precisionMetros: Float? = null,
    val esMock: Boolean = false
)

// Traduce la ubicación al estado visual que ya usa PermisosMarcajeCard
fun EstadoUbicacion.toEstadoVerificacion(): EstadoVerificacion = when (this) {
    EstadoUbicacion.VERIFICADA -> EstadoVerificacion.CORRECTO
    EstadoUbicacion.SIN_SENAL -> EstadoVerificacion.ADVERTENCIA
    EstadoUbicacion.SIMULADA,
    EstadoUbicacion.SIN_PERMISO -> EstadoVerificacion.ERROR
}