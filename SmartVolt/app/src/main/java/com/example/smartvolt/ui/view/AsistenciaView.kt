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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoJornadaExtra
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.JornadaHorasExtra
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.ui.components.asistencia.MarcaAsistenciaCard
import com.example.smartvolt.ui.components.asistencia.ResumenAsistenciaAzulCard
import com.example.smartvolt.ui.components.encabezados.Header
import com.example.smartvolt.ui.components.horasextra.HorasExtraMesCard
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSobreAmarillo

/**
 * Pestaña "Asistencia": últimas marcas, resumen mensual y horas extra del mes.
 * Solo visual: recibe los datos por parámetro (por defecto, datos ficticios de ejemplo).
 */
@Composable
fun AsistenciaView(
    marcasRecientes: List<MarcaDetalle> = marcasRecientesEjemplo,
    mes: String = "Octubre",
    asistenciasMarcadas: Int = 15,
    asistenciasTotales: Int = 30,
    horasExtraFormateadas: String = "12h 30 min",
    periodoHorasExtra: String = "Octubre 2026",
    jornadasHorasExtra: List<JornadaHorasExtra> = jornadasEjemplo,
    onVerCalendario: () -> Unit = {},
    onCambiarPeriodo: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Zona azul: mismo Header de las demás pantallas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 16.dp)
        ) {
            Header()
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
                    onClick = onVerCalendario,
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AmarilloPrincipal,
                        contentColor = TextoSobreAmarillo
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

            marcasRecientes.forEach { marca ->
                MarcaAsistenciaCard(marca = marca)
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

// ---------- Datos ficticios para previews y pruebas ----------

private val marcasRecientesEjemplo = listOf(
    MarcaDetalle(
        id = "1", titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte",
        hora = "9:31", estado = EstadoMarcaDetalle.PENDIENTE
    ),
    MarcaDetalle(
        id = "2", titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte",
        hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
    ),
    MarcaDetalle(
        id = "3", titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte",
        hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
    )
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
        AsistenciaView()
    }
}