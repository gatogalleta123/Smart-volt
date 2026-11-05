package com.example.smartvolt.ui.view


import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.smartvolt.model.domain.EstadoUbicacion
import com.example.smartvolt.model.domain.LecturaUbicacion
import com.example.smartvolt.model.domain.toEstadoVerificacion
import com.example.smartvolt.ui.components.ubicacion.AlertaAnomaliaUbicacion
import com.example.smartvolt.ui.components.ubicacion.MapaUbicacionCard
import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.EstadoVerificacion
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.ui.components.asistencia.ItemMarcaAsistencia
import com.example.smartvolt.ui.components.asistencia.TarjetaMarcaje
import com.example.smartvolt.ui.components.botones.BotonAccionGradiente
import com.example.smartvolt.ui.components.conexion.EstadoConexionCard
import com.example.smartvolt.ui.components.conexion.FaenaActualCard
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.components.marcaje.ValidacionMarcajeDialog
import com.example.smartvolt.ui.components.permisos.PermisosMarcajeCard
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
    val paso by viewModel.paso.collectAsState()
    val ubicacion by viewModel.ubicacion.collectAsState()
    val context = LocalContext.current

    // Lanzador del permiso de cámara (sin cambios)
    val lanzadorCamara = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { concedido ->
        viewModel.camaraResuelta(concedido)
        if (!concedido) {
            Toast.makeText(
                context,
                "Se necesita el permiso de cámara para validar tu identidad",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // Lanzador del permiso de ubicación
    val lanzadorUbicacion = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { viewModel.actualizarUbicacion() }

    // Al entrar a la pantalla, pedimos el permiso si falta
    LaunchedEffect(Unit) {
        val concedido = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        if (concedido) viewModel.actualizarUbicacion()
        else lanzadorUbicacion.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    // Cuando el flujo llega al paso de cámara (sin cambios)
    LaunchedEffect(paso) {
        if (paso == PasoValidacion.SOLICITANDO_CAMARA) {
            val yaConcedido = ContextCompat.checkSelfPermission(
                context, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
            if (yaConcedido) viewModel.camaraResuelta(true)
            else lanzadorCamara.launch(Manifest.permission.CAMERA)
        }
    }

    MarcajeContent(
        estaConectado = estaConectado,
        nombreFaena = nombreFaena,
        tipoMarca = tipoMarca,
        estadoBluetooth = estadoBluetooth,
        // El GPS ahora refleja la verificación real; si aún no hay lectura, usa el valor recibido
        estadoGps = ubicacion?.estado?.toEstadoVerificacion() ?: estadoGps,
        estadoCamara = estadoCamara,
        horaTarjeta = horaActual(),
        marcas = marcas,
        sincronizando = sincronizando,
        onIniciarValidacion = { viewModel.iniciarValidacion() },
        onSincronizar = { viewModel.sincronizar() },
        ubicacion = ubicacion
    )

    ValidacionMarcajeDialog(
        paso = paso,
        totems = viewModel.totemsDisponibles,
        onSeleccionarTotem = { viewModel.seleccionarTotem(it) },
        onConfirmarFoto = { /* TODO: siguiente instrucción */ },
        onCancelar = { viewModel.cancelarValidacion() }
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
    onIniciarValidacion: () -> Unit,
    onSincronizar: () -> Unit,
    ubicacion: LecturaUbicacion? = null
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
            EstadoConexionCard(estaConectado = estaConectado)
            // La alerta se reabre cada vez que llega una lectura nueva
            var alertaVisible by remember(ubicacion) { mutableStateOf(true) }
            AlertaAnomaliaUbicacion(
                visible = ubicacion?.estado == EstadoUbicacion.SIMULADA && alertaVisible,
                onCerrar = { alertaVisible = false }
            )
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
                onClick = onIniciarValidacion
            )

            val latitud = ubicacion?.latitud
            val longitud = ubicacion?.longitud
            if (latitud != null && longitud != null) {
                TituloSeccion(texto = "Tu ubicación")
                MapaUbicacionCard(latitud = latitud, longitud = longitud)
            }

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
            onIniciarValidacion = {},
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
            onIniciarValidacion = {},
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
            onIniciarValidacion = {},
            onSincronizar = {}
        )
    }
}

// ---------- Utilidades ----------

private fun horaActual(): String =
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

private fun fechaActual(): String =
    SimpleDateFormat("d 'de' MMMM", Locale("es")).format(Date())