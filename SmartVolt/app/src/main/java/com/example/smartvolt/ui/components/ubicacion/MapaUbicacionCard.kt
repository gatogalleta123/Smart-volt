package com.example.smartvolt.ui.components.ubicacion

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.CopyrightOverlay
import org.osmdroid.views.overlay.Marker

/**
 * Muestra la posición del dispositivo sobre un mapa OpenStreetMap.
 * Requiere conexión para descargar los mosaicos que aún no estén en caché.
 */
@Composable
fun MapaUbicacionCard(
    latitud: Double,
    longitud: Double,
    modifier: Modifier = Modifier
) {
    val contexto = LocalContext.current
    val ciclo = LocalLifecycleOwner.current

    val mapa = remember {
        MapView(contexto).apply {
            setTileSource(TileSourceFactory.OpenTopo)
            setMultiTouchControls(true)
            controller.setZoom(17.0)
        }
    }

    // El MapView debe recibir los eventos de ciclo de vida de la Activity
    DisposableEffect(ciclo) {
        val observador = LifecycleEventObserver { _, evento ->
            when (evento) {
                Lifecycle.Event.ON_RESUME -> mapa.onResume()
                Lifecycle.Event.ON_PAUSE -> mapa.onPause()
                else -> Unit
            }
        }
        ciclo.lifecycle.addObserver(observador)
        onDispose {
            ciclo.lifecycle.removeObserver(observador)
            mapa.onDetach()
        }
    }

    AndroidView(
        factory = { mapa },
        update = { vista ->
            val punto = GeoPoint(latitud, longitud)
            vista.controller.setCenter(punto)
            vista.overlays.clear()
            vista.overlays.add(
                Marker(vista).apply {
                    position = punto
                    setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    title = "Tu ubicación"
                }
            )
            // Atribución obligatoria: "© OpenStreetMap contributors"
            vista.overlays.add(CopyrightOverlay(contexto))
            vista.invalidate()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}