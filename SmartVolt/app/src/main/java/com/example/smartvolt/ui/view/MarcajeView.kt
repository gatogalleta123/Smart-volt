package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartvolt.model.EstadoVerificacion
import com.example.smartvolt.model.TipoMarca
import com.example.smartvolt.ui.components.botones.BotonAccionGradiente
import com.example.smartvolt.ui.components.conexion.EstadoConexionCard
import com.example.smartvolt.ui.components.conexion.FaenaActualCard
import com.example.smartvolt.ui.components.permisos.PermisosMarcajeCard
import com.example.smartvolt.ui.components.asistencia.TarjetaMarcaje
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun MarcajeView(
    estaConectado: Boolean = true,
    nombreFaena: String = "Obra frente 2",
    tipoMarca: TipoMarca = TipoMarca.ENTRADA,   // ENTRADA o SALIDA
    hora: String = "08:30 a.m",
    estadoBluetooth: EstadoVerificacion = EstadoVerificacion.CORRECTO,
    estadoGps: EstadoVerificacion = EstadoVerificacion.ADVERTENCIA,
    estadoCamara: EstadoVerificacion = EstadoVerificacion.ERROR
) {
    val sinConexion = !estaConectado
    val tituloBase = if (tipoMarca == TipoMarca.SALIDA) "Salida por marcar" else "Validar y marcar entrada"
    val titulo = if (sinConexion) "$tituloBase sin conexión" else tituloBase

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Zona azul: conexión + faena
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            EstadoConexionCard(estaConectado = estaConectado)
            FaenaActualCard(nombreFaena = nombreFaena)
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TituloSeccion(texto = "Estados de permiso")

            PermisosMarcajeCard(
                estadoBluetooth = estadoBluetooth,
                estadoGps = estadoGps,
                estadoCamara = estadoCamara
            )

            TarjetaMarcaje(
                titulo = titulo,
                hora = hora,
                sinConexion = sinConexion
            )

            BotonAccionGradiente(
                texto = "Escanear QR supervisor",
                icono = Icons.Outlined.QrCodeScanner,
                fondo = SmartVoltGradients.SecondaryButton,
                colorContenido = TextoSobreAzul
            )

            BotonAccionGradiente(
                texto = "Modo Offline",
                icono = Icons.Outlined.WifiOff,
                fondo = SmartVoltGradients.MarcajeOffline,
                colorContenido = TextoSobreAmarillo
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "1. Online - Entrada")
@Composable
fun MarcajeViewOnlinePreview() {
    SmartVoltTheme(dynamicColor = false) { MarcajeView() }
}

@Preview(showBackground = true, showSystemUi = true, name = "2. Sin conexión - Entrada")
@Composable
fun MarcajeViewOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) { MarcajeView(estaConectado = false) }
}

@Preview(showBackground = true, showSystemUi = true, name = "3. Online - Salida")
@Composable
fun MarcajeViewSalidaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeView(tipoMarca = TipoMarca.SALIDA, hora = "5:30 p.m")
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "4. Sin conexión - Salida")
@Composable
fun MarcajeViewSalidaOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeView(estaConectado = false, tipoMarca = TipoMarca.SALIDA, hora = "5:30 p.m")
    }
}