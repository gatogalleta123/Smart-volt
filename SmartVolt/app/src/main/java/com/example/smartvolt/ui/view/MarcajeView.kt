package com.example.smartvolt.ui.view

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.smartvolt.model.domain.EstadoUbicacion
import com.example.smartvolt.model.domain.LecturaUbicacion
import com.example.smartvolt.ui.components.ubicacion.AlertaAnomaliaUbicacion
import com.example.smartvolt.ui.components.ubicacion.MapaUbicacionCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.domain.EstadoVerificacion
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.ui.components.asistencia.TarjetaMarcaje
import com.example.smartvolt.ui.components.conexion.EstadoConexionCard
import com.example.smartvolt.ui.components.conexion.FaenaActualCard
import com.example.smartvolt.ui.components.HeaderSmartVolt
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.components.marcaje.PantallaEscanerQr
import com.example.smartvolt.ui.components.marcaje.ValidacionMarcajeDialog
import com.example.smartvolt.ui.components.permisos.PermisosMarcajeCard
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.viewmodel.MarcajeViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Versión con estado: obtiene los datos del ViewModel y delega la UI en [MarcajeContent].
 */
@Composable
fun MarcajeView(
    nombreFaena: String = "Obra frente 2",
    viewModel: MarcajeViewModel = viewModel(),
    onPerfilClick: () -> Unit = {}
) {
    val marcas by viewModel.marcas.collectAsState()
    val paso by viewModel.paso.collectAsState()
    val ubicacion by viewModel.ubicacion.collectAsState()
    val foto by viewModel.foto.collectAsState()
    val horaMarca by viewModel.horaMarca.collectAsState()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val conectado = rememberInternetConnection()
    var revisionPermisos by remember { mutableIntStateOf(0) }
    var mostrarEscanerQr by remember { mutableStateOf(false) }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) revisionPermisos++
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    val bluetoothListo = remember(context, revisionPermisos) { bluetoothEstaListo(context) }
    val gpsListo = remember(context, revisionPermisos) { gpsEstaListo(context) }
    val camaraLista = remember(context, revisionPermisos) {
        ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) ==
            PackageManager.PERMISSION_GRANTED
    }

    val lanzadorCamara = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { concedido ->
        revisionPermisos++
        viewModel.camaraResuelta(concedido)
        if (!concedido) {
            Toast.makeText(
                context,
                "Se necesita el permiso de cámara para validar tu identidad",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    val lanzadorCamaraQr = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { concedido ->
        revisionPermisos++
        if (concedido) {
            mostrarEscanerQr = true
        } else {
            Toast.makeText(context, "Se necesita permiso de cámara para abrir el lector QR", Toast.LENGTH_LONG).show()
        }
    }

    val lanzadorPermisoCamara = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { revisionPermisos++ }

    val lanzadorUbicacion = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        revisionPermisos++
        viewModel.actualizarUbicacion()
    }

    val lanzadorBluetooth = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permisos ->
        revisionPermisos++
        if (permisos.values.all { it }) {
            context.abrirConfiguracion(Settings.ACTION_BLUETOOTH_SETTINGS)
        }
    }

    LaunchedEffect(Unit) {
        val concedido = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        if (concedido) viewModel.actualizarUbicacion()
        else lanzadorUbicacion.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    LaunchedEffect(paso) {
        if (paso == PasoValidacion.SOLICITANDO_CAMARA) {
            val yaConcedido = ContextCompat.checkSelfPermission(
                context, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
            if (yaConcedido) viewModel.camaraResuelta(true)
            else lanzadorCamara.launch(Manifest.permission.CAMERA)
        }
    }

    val marcaActual = marcas.firstOrNull { it.fecha == fechaActual() }
    val tipoMarcaActual = siguienteTipoMarca(marcaActual?.tipo)

    MarcajeContent(
        estaConectado = conectado,
        nombreFaena = nombreFaena,
        tipoMarca = tipoMarcaActual,
        estadoBluetooth = if (bluetoothListo) EstadoVerificacion.CORRECTO else EstadoVerificacion.ERROR,
        estadoGps = if (gpsListo) EstadoVerificacion.CORRECTO else EstadoVerificacion.ERROR,
        estadoCamara = if (camaraLista) EstadoVerificacion.CORRECTO else EstadoVerificacion.ERROR,
        horaTarjeta = horaActual(),
        onIniciarValidacion = { viewModel.iniciarValidacion() },
        onEscanearQr = {
            if (camaraLista) mostrarEscanerQr = true
            else lanzadorCamaraQr.launch(Manifest.permission.CAMERA)
        },
        onBluetoothClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val permisosNecesarios = arrayOf(
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT
                ).filter {
                    ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
                }
                if (permisosNecesarios.isNotEmpty()) {
                    lanzadorBluetooth.launch(permisosNecesarios.toTypedArray())
                } else {
                    context.abrirConfiguracion(Settings.ACTION_BLUETOOTH_SETTINGS)
                }
            } else {
                context.abrirConfiguracion(Settings.ACTION_BLUETOOTH_SETTINGS)
            }
        },
        onGpsClick = {
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                lanzadorUbicacion.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            } else {
                context.abrirConfiguracion(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            }
        },
        onCamaraClick = {
            if (!camaraLista) lanzadorPermisoCamara.launch(Manifest.permission.CAMERA)
        },
        ubicacion = ubicacion,
        onPerfilClick = onPerfilClick
    )

    ValidacionMarcajeDialog(
        paso = paso,
        totems = viewModel.totemsDisponibles,
        foto = foto,
        horaMarca = horaMarca,
        onSeleccionarTotem = { viewModel.seleccionarTotem(it) },
        onConfirmarAviso = { viewModel.confirmarAvisoFoto() },
        onFotoTomada = { viewModel.fotoTomada(it) },
        onContinuarFoto = { viewModel.continuarConFoto(horaActual()) },
        onReintentarFoto = { viewModel.reintentarFoto() },
        onContinuarBuenTurno = {
            viewModel.finalizarMarca(
                tipo = tipoMarcaActual,
                fecha = fechaActual(),
                faena = nombreFaena
            )
        },
        onCancelar = { viewModel.cancelarValidacion() }
    )

    if (mostrarEscanerQr) {
        PantallaEscanerQr(onVolver = { mostrarEscanerQr = false })
    }
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
    onIniciarValidacion: () -> Unit,
    onEscanearQr: () -> Unit = {},
    onBluetoothClick: () -> Unit = {},
    onGpsClick: () -> Unit = {},
    onCamaraClick: () -> Unit = {},
    ubicacion: LecturaUbicacion? = null,
    onPerfilClick: () -> Unit = {}
) {
    val sinConexion = !estaConectado
    val tituloBase = textoParaTipoMarca(tipoMarca)
    val titulo = if (sinConexion) "$tituloBase sin conexión" else tituloBase

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Encabezado y faena
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(top = 16.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            HeaderSmartVolt(
                onPerfilClick = onPerfilClick,
                onQrClick = onEscanearQr
            )
            FaenaActualCard(
                nombreFaena = nombreFaena,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
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
                estadoCamara = estadoCamara,
                onBluetoothClick = onBluetoothClick,
                onGpsClick = onGpsClick,
                onCamaraClick = onCamaraClick
            )

            TarjetaMarcaje(
                titulo = titulo,
                hora = horaTarjeta,
                sinConexion = sinConexion,
                onClick = onIniciarValidacion
            )

            val latitud = ubicacion?.latitud
            val longitud = ubicacion?.longitud
            TituloSeccion(texto = "Tu ubicación")
            if (latitud != null && longitud != null) {
                MapaUbicacionCard(latitud = latitud, longitud = longitud)
            } else {
                Text(
                    text = when (ubicacion?.estado) {
                        null -> "Obteniendo ubicación GPS..."
                        EstadoUbicacion.SIN_PERMISO ->
                            "Activa el permiso de ubicación para mostrar el mapa."
                        EstadoUbicacion.SIN_SENAL ->
                            "No se pudo obtener una ubicación. Verifica que el GPS esté activo."
                        EstadoUbicacion.VERIFICADA, EstadoUbicacion.SIMULADA ->
                            "No hay coordenadas disponibles para mostrar el mapa."
                    }
                )
            }

        }
    }
}

// ---------- Previews (usan datos de ejemplo, sin ViewModel ni Room) ----------

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
            onIniciarValidacion = {}
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
            onIniciarValidacion = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "3. Salida")
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
            onIniciarValidacion = {}
        )
    }
}

// ---------- Utilidades ----------

private fun horaActual(): String =
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

private fun fechaActual(): String =
    SimpleDateFormat("d 'de' MMMM", Locale("es")).format(Date())

private fun siguienteTipoMarca(ultimaMarca: TipoMarca?): TipoMarca = when (ultimaMarca) {
    TipoMarca.ENTRADA -> TipoMarca.ENTRADA_COLACION
    TipoMarca.ENTRADA_COLACION -> TipoMarca.SALIDA_COLACION
    TipoMarca.SALIDA_COLACION -> TipoMarca.SALIDA
    else -> TipoMarca.ENTRADA
}

private fun textoParaTipoMarca(tipo: TipoMarca): String = when (tipo) {
    TipoMarca.ENTRADA -> "Validar y marcar entrada"
    TipoMarca.ENTRADA_COLACION -> "Marcar entrada a colación"
    TipoMarca.SALIDA_COLACION -> "Marcar salida de colación"
    TipoMarca.SALIDA -> "Marcar salida"
    TipoMarca.ENTRADA_HORAS_EXTRA -> "Marcar entrada de horas extra"
    TipoMarca.SALIDA_HORAS_EXTRA -> "Marcar salida de horas extra"
}

@Composable
private fun rememberInternetConnection(): Boolean {
    val context = LocalContext.current
    val connectivityManager = remember(context) {
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    var conectado by remember(connectivityManager) {
        mutableStateOf(connectivityManager.tieneInternetValidado())
    }

    DisposableEffect(connectivityManager) {
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                conectado = connectivityManager.tieneInternetValidado(network)
            }

            override fun onLost(network: Network) {
                conectado = connectivityManager.tieneInternetValidado()
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                conectado = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            }
        }
        connectivityManager.registerDefaultNetworkCallback(callback)
        onDispose { connectivityManager.unregisterNetworkCallback(callback) }
    }
    return conectado
}

private fun ConnectivityManager.tieneInternetValidado(network: Network? = activeNetwork): Boolean =
    network?.let { getNetworkCapabilities(it) }?.let {
        it.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
            it.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    } == true

private fun bluetoothEstaListo(context: Context): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val conectPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_CONNECT
        ) == PackageManager.PERMISSION_GRANTED
        val scanPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_SCAN
        ) == PackageManager.PERMISSION_GRANTED
        if (!conectPermission || !scanPermission) return false
    }
    return adaptadorBluetooth()?.isEnabled == true
}

@Suppress("DEPRECATION")
private fun adaptadorBluetooth(): BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

private fun gpsEstaListo(context: Context): Boolean {
    val permisoUbicacion = ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
    val gpsActivo = (context.getSystemService(Context.LOCATION_SERVICE) as LocationManager)
        .isProviderEnabled(LocationManager.GPS_PROVIDER)
    return permisoUbicacion && gpsActivo
}

private fun Context.abrirConfiguracion(accion: String) {
    startActivity(Intent(accion).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
}