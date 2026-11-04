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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.EstadoMarca
import com.example.smartvolt.model.EstadoVerificacion
import com.example.smartvolt.model.RegistroMarca
import com.example.smartvolt.model.TipoMarca
import com.example.smartvolt.ui.components.BotonAccionGradiente
import com.example.smartvolt.ui.components.EstadoConexionCard
import com.example.smartvolt.ui.components.FaenaActualCard
import com.example.smartvolt.ui.components.ItemMarcaAsistencia
import com.example.smartvolt.ui.components.PermisosMarcajeCard
import com.example.smartvolt.ui.components.TarjetaMarcaje
import com.example.smartvolt.ui.components.TituloSeccion
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul
import com.example.smartvolt.viewmodel.MarcajeViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Versión con estado: obtiene los datos del ViewModel y delega la UI en [MarcajeContent].
 */
@Composable
fun MarcajeView(
    estaConectado: Boolean = true,
    nombreFaena: String = "Obra frente 2",
    tipoMarca: TipoMarca = TipoMarca.ENTRADA,
    estadoBluetooth: EstadoVerificacion = EstadoVerificacion.CORRECTO,
    estadoGps: EstadoVerificacion = EstadoVerificacion.ADVERTENCIA,
    estadoCamara: EstadoVerificacion = EstadoVerificacion.ERROR,
    viewModel: MarcajeViewModel = viewModel()
) {
    val marcas by viewModel.marcas.collectAsState()
    val sincronizando by viewModel.sincronizando.collectAsState()

    MarcajeContent(
        estaConectado = estaConectado,
        nombreFaena = nombreFaena,
        tipoMarca = tipoMarca,
        estadoBluetooth = estadoBluetooth,
        estadoGps = estadoGps,
        estadoCamara = estadoCamara,
        horaTarjeta = horaActual(),
        marcas = marcas,
        sincronizando = sincronizando,
        onRegistrarMarca = {
            viewModel.registrarMarca(
                tipo = tipoMarca,
                hora = horaActual(),
                fecha = fechaActual(),
                faena = nombreFaena
            )
        },
        onSincronizar = { viewModel.sincronizar() }
    )
}

/**
 * Versión sin ViewModel: solo recibe datos y eventos. Es la que se puede previsualizar.
 */
@Composable
fun MarcajeContent(
    estaConectado: Boolean,
    nombreFaena: String,
    tipoMarca: TipoMarca,
    estadoBluetooth: EstadoVerificacion,
    estadoGps: EstadoVerificacion,
    estadoCamara: EstadoVerificacion,
    horaTarjeta: String,
    marcas: List<RegistroMarca>,
    sincronizando: Boolean,
    onRegistrarMarca: () -> Unit,
    onSincronizar: () -> Unit
) {
    val sinConexion = !estaConectado
    val tituloBase = if (tipoMarca == TipoMarca.SALIDA) "Salida por marcar" else "Validar y marcar entrada"
    val titulo = if (sinConexion) "$tituloBase sin conexión" else tituloBase

    val hayPendientes = marcas.any { it.estado == EstadoMarca.PENDIENTE }

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
                hora = horaTarjeta,
                sinConexion = sinConexion,
                onClick = onRegistrarMarca
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

            // ---- Sección de prueba: marcas guardadas en Room ----
            TituloSeccion(texto = "Marcas guardadas (${marcas.size})")

            if (marcas.isEmpty()) {
                Text(text = "Aún no hay marcas. Toca la tarjeta para registrar una.")
            }

            marcas.forEach { registro ->
                ItemMarcaAsistencia(registro = registro)
            }

            Button(
                onClick = onSincronizar,
                enabled = hayPendientes && !sincronizando,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (sincronizando) "Sincronizando..." else "Sincronizar pendientes")
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

// ---------- Previews (usan datos de ejemplo, sin ViewModel ni Room) ----------

private val marcasEjemplo = listOf(
    RegistroMarca(
        id = "1",
        tipo = TipoMarca.ENTRADA,
        hora = "08:31",
        fecha = "12 de octubre",
        ubicacionFaena = "Obra frente 2",
        estado = EstadoMarca.VALIDADA
    ),
    RegistroMarca(
        id = "2",
        tipo = TipoMarca.ENTRADA_COLACION,
        hora = "13:05",
        fecha = "12 de octubre",
        ubicacionFaena = "Obra frente 2",
        estado = EstadoMarca.PENDIENTE
    )
)

@Preview(showBackground = true, showSystemUi = true, name = "1. Online - Sin marcas")
@Composable
fun MarcajeContentOnlinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeContent(
            estaConectado = true,
            nombreFaena = "Obra frente 2",
            tipoMarca = TipoMarca.ENTRADA,
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.ADVERTENCIA,
            estadoCamara = EstadoVerificacion.ERROR,
            horaTarjeta = "08:30 a.m",
            marcas = emptyList(),
            sincronizando = false,
            onRegistrarMarca = {},
            onSincronizar = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "2. Sin conexión - Con marcas")
@Composable
fun MarcajeContentOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeContent(
            estaConectado = false,
            nombreFaena = "Obra frente 2",
            tipoMarca = TipoMarca.ENTRADA,
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.CORRECTO,
            estadoCamara = EstadoVerificacion.CORRECTO,
            horaTarjeta = "08:30 a.m",
            marcas = marcasEjemplo,
            sincronizando = false,
            onRegistrarMarca = {},
            onSincronizar = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "3. Sincronizando")
@Composable
fun MarcajeContentSincronizandoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeContent(
            estaConectado = true,
            nombreFaena = "Obra frente 2",
            tipoMarca = TipoMarca.SALIDA,
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.CORRECTO,
            estadoCamara = EstadoVerificacion.CORRECTO,
            horaTarjeta = "17:30 p.m",
            marcas = marcasEjemplo,
            sincronizando = true,
            onRegistrarMarca = {},
            onSincronizar = {}
        )
    }
}

// ---------- Utilidades ----------

private fun horaActual(): String =
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

private fun fechaActual(): String =
    SimpleDateFormat("d 'de' MMMM", Locale("es")).format(Date())