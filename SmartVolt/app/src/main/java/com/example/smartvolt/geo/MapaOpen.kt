package com.example.smartvolt.geo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapaOpen(){
    val locationPermission = rememberPermissionState(
        permission = android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    Box(modifier = Modifier.fillMaxSize().padding(15.dp)){
        Text(text = "Para mostrar el mapa necesitamos de su permiso")
        Button(onClick = {locationPermission.launchPermissionRequest()}) {
            Text(text = "Pínchame")
        }
    }
}

@Composable
fun osm_mapa(){
    val contexto = LocalContext.current

    val mapaView = remember { MapView(contexto) }
    val myLocation = remember {
        val provider = GpsMyLocationProvider(contexto)
        MyLocationNewOverlay(provider, mapaView).apply{
            enableFollowLocation()
            isDrawAccuracyEnabled = true
        }
    }
}