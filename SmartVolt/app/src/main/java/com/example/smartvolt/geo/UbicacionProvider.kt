package com.example.smartvolt.geo

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import androidx.core.content.ContextCompat
import com.example.smartvolt.model.domain.EstadoUbicacion
import com.example.smartvolt.model.domain.LecturaUbicacion
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Obtiene una única lectura de ubicación en el momento de marcar.
 * No hace seguimiento en segundo plano.
 */
class UbicacionProvider(private val context: Context) {

    private val cliente = LocationServices.getFusedLocationProviderClient(context)

    fun tienePermiso(): Boolean =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    suspend fun obtenerUbicacion(): LecturaUbicacion {
        if (!tienePermiso()) return LecturaUbicacion(EstadoUbicacion.SIN_PERMISO)

        // Si el GPS está apagado o no hay lectura, llega null
        val location = obtenerLocalizacionActual()
            ?: return LecturaUbicacion(EstadoUbicacion.SIN_SENAL)

        val simulada = location.esSimulada()

        return LecturaUbicacion(
            estado = if (simulada) EstadoUbicacion.SIMULADA else EstadoUbicacion.VERIFICADA,
            latitud = location.latitude,
            longitud = location.longitude,
            precisionMetros = if (location.hasAccuracy()) location.accuracy else null,
            esMock = simulada
        )
    }

    @SuppressLint("MissingPermission")
    private suspend fun obtenerLocalizacionActual(): Location? {
        val actual = suspendCancellableCoroutine<Location?> { continuacion ->
            val cancelacion = CancellationTokenSource()
            cliente.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, cancelacion.token)
                .addOnSuccessListener { location ->
                    if (continuacion.isActive) continuacion.resume(location)
                }
                .addOnFailureListener {
                    if (continuacion.isActive) continuacion.resume(null)
                }
            continuacion.invokeOnCancellation { cancelacion.cancel() }
        }

        if (actual != null) return actual

        return suspendCancellableCoroutine { continuacion ->
            cliente.lastLocation
                .addOnSuccessListener { location ->
                    if (continuacion.isActive) continuacion.resume(location)
                }
                .addOnFailureListener {
                    if (continuacion.isActive) continuacion.resume(null)
                }
        }
    }

    // Location.isMock existe desde API 31; antes se usaba isFromMockProvider
    @Suppress("DEPRECATION")
    private fun Location.esSimulada(): Boolean =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) isMock else isFromMockProvider
}