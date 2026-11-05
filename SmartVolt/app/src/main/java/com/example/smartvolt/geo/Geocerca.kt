package com.example.smartvolt.geo

import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/** Perímetro circular de una faena (datos sintéticos en el MVP). */
data class Perimetro(
    val nombre: String,
    val latCentro: Double,
    val lonCentro: Double,
    val radioMetros: Double
)

object Geocerca {

    private const val RADIO_TIERRA_METROS = 6_371_000.0

    /** Distancia en metros entre dos coordenadas (fórmula de Haversine). */
    fun distanciaMetros(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat / 2).pow(2) +
                cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(dLon / 2).pow(2)
        return 2 * RADIO_TIERRA_METROS * asin(sqrt(a))
    }

    fun estaDentro(latitud: Double, longitud: Double, perimetro: Perimetro): Boolean =
        distanciaMetros(latitud, longitud, perimetro.latCentro, perimetro.lonCentro) <= perimetro.radioMetros
}