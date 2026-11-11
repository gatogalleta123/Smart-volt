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
import com.example.smartvolt.BuildConfig
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.util.GeoPoint
import org.osmdroid.util.MapTileIndex
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.CopyrightOverlay
import org.osmdroid.views.overlay.Marker

/**
 * Mosaicos de Mapbox (Static Tiles API). Cambia "streets-v12" por otro estilo si quieres:
 * "light-v11" (claro y sobrio), "outdoors-v12" o "satellite-streets-v12".
 */
private val TilesMapbox = object : OnlineTileSourceBase(
    "MapboxStreets",
    0,
    22,
    256,
    "",
    arrayOf("https://api.mapbox.com/styles/v1/mapbox/streets-v12/tiles/256/"),
    "© Mapbox © OpenStreetMap contributors"
) {
    // Mapbox usa el orden z/x/y
    override fun getTileURLString(pMapTileIndex: Long): String =
        baseUrl +
                MapTileIndex.getZoom(pMapTileIndex) + "/" +
                MapTileIndex.getX(pMapTileIndex) + "/" +
                MapTileIndex.getY(pMapTileIndex) +
                "?access_token=" + BuildConfig.MAPBOX_TOKEN
}

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
            setTileSource(TilesMapbox)
            setMultiTouchControls(true)
            isTilesScaledToDpi = true   // evita que las etiquetas se vean diminutas
            controller.setZoom(18.0)
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
            // Atribución obligatoria de Mapbox y OpenStreetMap
            vista.overlays.add(CopyrightOverlay(contexto))
            vista.invalidate()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}