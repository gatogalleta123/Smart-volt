package com.example.smartvolt.geo

import com.example.smartvolt.model.domain.EstadoUbicacion
import com.example.smartvolt.model.domain.LecturaUbicacion

enum class ResultadoUbicacion {
    VALIDA,
    FUERA_DE_PERIMETRO,
    PRECISION_INSUFICIENTE,
    SIMULADA,
    SIN_LECTURA
}

object ValidadorUbicacion {

    /** Precisión mínima aceptable, en metros. Es un parámetro a calibrar en terreno. */
    const val PRECISION_MAXIMA_METROS = 30f

    fun evaluar(lectura: LecturaUbicacion, perimetro: Perimetro): ResultadoUbicacion {
        val lat = lectura.latitud
        val lon = lectura.longitud
        return when {
            lectura.estado == EstadoUbicacion.SIMULADA -> ResultadoUbicacion.SIMULADA
            lat == null || lon == null -> ResultadoUbicacion.SIN_LECTURA
            (lectura.precisionMetros ?: Float.MAX_VALUE) > PRECISION_MAXIMA_METROS ->
                ResultadoUbicacion.PRECISION_INSUFICIENTE
            !Geocerca.estaDentro(lat, lon, perimetro) -> ResultadoUbicacion.FUERA_DE_PERIMETRO
            else -> ResultadoUbicacion.VALIDA
        }
    }
}