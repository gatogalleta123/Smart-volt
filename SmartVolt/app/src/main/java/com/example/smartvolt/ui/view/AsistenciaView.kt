package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.domain.EstadoJornadaExtra
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.JornadaHorasExtra
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.ui.components.asistencia.DetalleAsistenciasSheet
import com.example.smartvolt.ui.components.asistencia.MarcaAsistenciaCard
import com.example.smartvolt.ui.components.asistencia.ResumenAsistenciaAzulCard
import com.example.smartvolt.ui.components.asistencia.ResumenAsistenciasMesCard
import com.example.smartvolt.ui.components.calendario.CalendarioAsistenciaDialog
import com.example.smartvolt.ui.components.encabezados.HeaderSmartVolt
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.theme.AzulElectrico
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.components.horasextra.HorasExtraMesCard
import com.example.smartvolt.ui.theme.AzulIntermedio
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSobreAzul
import com.example.smartvolt.viewmodel.AsistenciaViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Versión con estado: lee las marcas del mes desde Room (vía ViewModel)
 * y delega la parte visual en [AsistenciaContent].
 */
@Composable
fun AsistenciaView(
    onEscanearQr: () -> Unit = {},
    viewModel: AsistenciaViewModel = viewModel(),
    onPerfilClick: () -> Unit = {}
) {
    val marcasDelMes by viewModel.marcasDelMes.collectAsState()
    val marcasGuardadas by viewModel.marcasGuardadas.collectAsState()
    val asistenciasDelMes by viewModel.asistenciasDelMes.collectAsState()
    val sincronizando by viewModel.sincronizando.collectAsState()

    AsistenciaContent(
        marcasDelMes = marcasDelMes,
        marcasGuardadas = marcasGuardadas,
        asistenciasDelMes = asistenciasDelMes,
        sincronizando = sincronizando,
        onSincronizar = { viewModel.sincronizar() },
        onEscanearQr = onEscanearQr,
        onPerfilClick = onPerfilClick
    )
}

/**
 * Pestaña "Asistencia": resumen de asistencias del mes (con popup de detalle),
 * resumen mensual y horas extra del mes.
 */
@Composable
fun AsistenciaContent(
    marcasDelMes: List<RegistroMarca>,
    asistenciasDelMes: Int,
    marcasGuardadas: List<RegistroMarca> = marcasDelMes,
    mes: String = nombreMesActual(),
    asistenciasMarcadas: Int = 15,
    asistenciasTotales: Int = 30,
    horasExtraFormateadas: String = "12h 30 min",
    periodoHorasExtra: String = "Octubre 2026",
    sincronizando: Boolean = false,
    onSincronizar: () -> Unit = {},
    onEscanearQr: () -> Unit = {},
    jornadasHorasExtra: List<JornadaHorasExtra> = jornadasEjemplo,
    onVerCalendario: () -> Unit = {},
    onCambiarPeriodo: () -> Unit = {},
    onPerfilClick: () -> Unit = {}
) {
    var mostrarCalendario by remember { mutableStateOf(false) }
    var mostrarDetalle by remember { mutableStateOf(false) }

    if (mostrarCalendario) {
        CalendarioAsistenciaDialog(onDismiss = { mostrarCalendario = false })
    }

    if (mostrarDetalle) {
        DetalleAsistenciasSheet(
            mes = mes,
            ultimaActualizacion = fechaHoy(),
            marcas = marcasDelMes,
            onDismiss = { mostrarDetalle = false }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Encabezado
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 16.dp)
        ) {
            HeaderSmartVolt(
                onPerfilClick = onPerfilClick,
                onQrClick = onEscanearQr
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tus asistencias:",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                Button(
                    onClick = {
                        mostrarCalendario = true
                        onVerCalendario()
                    },
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzulIntermedio,
                        contentColor = TextoSobreAzul
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.CalendarMonth,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "Ver calendario", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                }
            }

            // Reemplaza la lista de tarjetas azules por la tarjeta resumen + popup
            ResumenAsistenciasMesCard(
                cantidad = asistenciasDelMes,
                onVerDetalle = { mostrarDetalle = true },
                titulo = "Asistencias de $mes"
            )

            TituloSeccion(texto = "Marcas guardadas (${marcasGuardadas.size})")
            if (marcasGuardadas.isEmpty()) {
                Text(text = "Aún no tienes marcas registradas.")
            } else {
                marcasGuardadas.take(5).forEach { marca ->
                    MarcaAsistenciaCard(
                        marca = MarcaDetalle(
                            titulo = marca.tipo.tituloDisplay,
                            fecha = marca.fecha,
                            faena = marca.ubicacionFaena,
                            hora = marca.hora,
                            estado = when (marca.estado) {
                                EstadoMarca.VALIDADA -> EstadoMarcaDetalle.VALIDADA
                                EstadoMarca.PENDIENTE -> EstadoMarcaDetalle.PENDIENTE
                            }
                        )
                    )
                }
            }
            Button(
                onClick = onSincronizar,
                enabled = marcasGuardadas.any { it.estado == EstadoMarca.PENDIENTE } && !sincronizando,
                colors = ButtonDefaults.buttonColors(
                    containerColor = AzulElectrico,
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (sincronizando) "Sincronizando..." else "Sincronizar marcas")
            }

            ResumenAsistenciaAzulCard(
                mes = mes,
                asistenciasMarcadas = asistenciasMarcadas,
                asistenciasTotales = asistenciasTotales
            )

            HorasExtraMesCard(
                horasFormateadas = horasExtraFormateadas,
                periodo = periodoHorasExtra,
                jornadas = jornadasHorasExtra,
                onCambiarPeriodo = onCambiarPeriodo
            )
        }
    }
}

// ---------- Utilidades ----------

private fun nombreMesActual(): String =
    SimpleDateFormat("MMMM", Locale("es")).format(Date())
        .replaceFirstChar { it.uppercase() }

private fun fechaHoy(): String =
    SimpleDateFormat("d/M/yyyy", Locale.getDefault()).format(Date())

// ---------- Datos ficticios para previews ----------

private val marcasEjemplo = listOf(
    RegistroMarca("1", TipoMarca.ENTRADA, "08:31", "4 de noviembre", "Obra frente 2", EstadoMarca.VALIDADA),
    RegistroMarca("2", TipoMarca.ENTRADA, "08:29", "3 de noviembre", "Obra frente 2", EstadoMarca.PENDIENTE)
)

private val jornadasEjemplo = listOf(
    JornadaHorasExtra(
        id = "1", fecha = "23 de Octubre", horario = "16:00 p.m. - 18:00 p.m. (2horas)",
        estado = EstadoJornadaExtra.APROBADAS,
        marcas = listOf(
            MarcaDetalle(titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA),
            MarcaDetalle(titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA)
        )
    ),
    JornadaHorasExtra(
        id = "2", fecha = "23 de Octubre", horario = "16:00 p.m. - 18:00 p.m. (2horas)",
        estado = EstadoJornadaExtra.PENDIENTE,
        marcas = listOf(
            MarcaDetalle(titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.PENDIENTE),
            MarcaDetalle(titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.PENDIENTE)
        )
    ),
    JornadaHorasExtra(
        id = "3", fecha = "23 de Octubre", horario = "16:00 p.m. - 18:00 p.m. (2horas)",
        estado = EstadoJornadaExtra.RECHAZADAS,
        marcas = listOf(
            MarcaDetalle(titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.SIN_REGISTRAR),
            MarcaDetalle(titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.PENDIENTE)
        )
    )
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AsistenciaViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        AsistenciaContent(
            marcasDelMes = marcasEjemplo,
            asistenciasDelMes = 23
        )
    }
}