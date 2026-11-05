package com.example.smartvolt.ui.components.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.smartvolt.model.domain.EstadoDiaAsistencia
import com.example.smartvolt.ui.theme.AzulBrillante
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulElectrico
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.Pendiente
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import java.util.Calendar

private val NOMBRES_MES = listOf(
    "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"
)
private val DIAS_SEMANA = listOf("Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa")

/** ÚNICO lugar donde se definen los colores de los días. */
private fun colorFondoDia(estado: EstadoDiaAsistencia): Color = when (estado) {
    EstadoDiaAsistencia.ASISTIDO -> AzulCorporativo
    EstadoDiaAsistencia.AUSENTE -> Error
    EstadoDiaAsistencia.NO_LABORAL -> Pendiente
    EstadoDiaAsistencia.HOY -> AzulBrillante
}

/**
 * Calendario emergente. [estadoDia] recibe (año, mes 0-11, día) y devuelve el estado
 * a pintar, o null si el día no lleva color.
 */
@Composable
fun CalendarioAsistenciaDialog(
    onDismiss: () -> Unit,
    estadoDia: (anio: Int, mes: Int, dia: Int) -> EstadoDiaAsistencia? = ::estadoDiaEjemplo
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(modifier = Modifier.padding(horizontal = 24.dp)) {
            CalendarioAsistenciaContenido(onSalir = onDismiss, estadoDia = estadoDia)
        }
    }
}

@Composable
fun CalendarioAsistenciaContenido(
    onSalir: () -> Unit,
    modifier: Modifier = Modifier,
    estadoDia: (anio: Int, mes: Int, dia: Int) -> EstadoDiaAsistencia? = ::estadoDiaEjemplo
) {
    val hoy = remember { Calendar.getInstance() }
    val anioActual = hoy.get(Calendar.YEAR)
    var anio by remember { mutableIntStateOf(anioActual) }
    var mes by remember { mutableIntStateOf(hoy.get(Calendar.MONTH)) } // 0..11

    val anios = (minOf(anioActual - 5, anio)..maxOf(anioActual + 1, anio)).toList()
    val celdas = remember(anio, mes) { construirCeldas(anio, mes) }

    fun cambiarMes(delta: Int) {
        var nuevoMes = mes + delta
        var nuevoAnio = anio
        if (nuevoMes < 0) { nuevoMes = 11; nuevoAnio-- }
        if (nuevoMes > 11) { nuevoMes = 0; nuevoAnio++ }
        mes = nuevoMes
        anio = nuevoAnio
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Superficie)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Selector de mes / año
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { cambiarMes(-1) }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Mes anterior",
                    tint = TextoPrincipal
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SelectorDesplegable(
                    textoActual = NOMBRES_MES[mes],
                    opciones = NOMBRES_MES,
                    onSeleccion = { indice -> mes = indice }
                )
                SelectorDesplegable(
                    textoActual = anio.toString(),
                    opciones = anios.map { it.toString() },
                    onSeleccion = { indice -> anio = anios[indice] }
                )
            }
            IconButton(onClick = { cambiarMes(1) }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Mes siguiente",
                    tint = TextoPrincipal
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Cabecera de días de la semana
        Row(modifier = Modifier.fillMaxWidth()) {
            DIAS_SEMANA.forEach { dia ->
                Text(
                    text = dia,
                    fontSize = 12.sp,
                    color = TextoSecundario,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Grilla de días
        celdas.chunked(7).forEach { semana ->
            Row(modifier = Modifier.fillMaxWidth()) {
                semana.forEach { celda ->
                    CeldaDiaCalendario(
                        celda = celda,
                        estado = if (celda.delMes) estadoDia(anio, mes, celda.dia) else null,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSalir,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulElectrico,
                contentColor = Color.White
            )
        ) {
            Text(text = "Salir", fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun SelectorDesplegable(
    textoActual: String,
    opciones: List<String>,
    onSeleccion: (Int) -> Unit
) {
    var abierto by remember { mutableStateOf(false) }
    val forma = RoundedCornerShape(6.dp)

    Box {
        Row(
            modifier = Modifier
                .clip(forma)
                .border(width = 1.dp, color = Borde, shape = forma)
                .clickable { abierto = true }
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = textoActual, fontSize = 14.sp, color = TextoPrincipal)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                tint = TextoPrincipal,
                modifier = Modifier.size(18.dp)
            )
        }
        DropdownMenu(expanded = abierto, onDismissRequest = { abierto = false }) {
            opciones.forEachIndexed { indice, opcion ->
                DropdownMenuItem(
                    text = { Text(text = opcion) },
                    onClick = {
                        onSeleccion(indice)
                        abierto = false
                    }
                )
            }
        }
    }
}

@Composable
private fun CeldaDiaCalendario(
    celda: CeldaDia,
    estado: EstadoDiaAsistencia?,
    modifier: Modifier = Modifier
) {
    val (fondo, colorTexto) = when {
        celda.dia == 0 -> Color.Transparent to Color.Transparent
        !celda.delMes -> Color.Transparent to TextoSecundario.copy(alpha = 0.4f)
        estado == null -> Color.Transparent to TextoPrincipal
        else -> colorFondoDia(estado) to Color.White
    }

    Box(
        modifier = modifier
            .padding(2.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(6.dp))
            .background(fondo),
        contentAlignment = Alignment.Center
    ) {
        if (celda.dia != 0) {
            Text(text = celda.dia.toString(), fontSize = 14.sp, color = colorTexto)
        }
    }
}

// ---------- Lógica de calendario (java.util.Calendar: funciona con minSdk 24 sin desugaring) ----------

/** dia = 0 -> celda vacía antes del día 1. delMes = false -> días del mes siguiente (en gris). */
private data class CeldaDia(val dia: Int, val delMes: Boolean)

private fun construirCeldas(anio: Int, mes: Int): List<CeldaDia> {
    val primerDia = Calendar.getInstance().apply {
        clear()
        set(anio, mes, 1)
    }
    val vaciasInicio = primerDia.get(Calendar.DAY_OF_WEEK) - 1 // domingo = 0
    val diasDelMes = primerDia.getActualMaximum(Calendar.DAY_OF_MONTH)

    val celdas = mutableListOf<CeldaDia>()
    repeat(vaciasInicio) { celdas.add(CeldaDia(0, false)) }
    for (dia in 1..diasDelMes) celdas.add(CeldaDia(dia, true))
    val relleno = (7 - celdas.size % 7) % 7
    for (dia in 1..relleno) celdas.add(CeldaDia(dia, false))
    return celdas
}

/** Datos de ejemplo mientras no haya datos reales: hoy celeste, sábados grises, pasados azules. */
fun estadoDiaEjemplo(anio: Int, mes: Int, dia: Int): EstadoDiaAsistencia? {
    val hoy = Calendar.getInstance()
    val clave = anio * 10000 + mes * 100 + dia
    val claveHoy = hoy.get(Calendar.YEAR) * 10000 + hoy.get(Calendar.MONTH) * 100 + hoy.get(Calendar.DAY_OF_MONTH)
    val diaSemana = Calendar.getInstance().apply {
        clear()
        set(anio, mes, dia)
    }.get(Calendar.DAY_OF_WEEK)

    return when {
        clave == claveHoy -> EstadoDiaAsistencia.HOY
        clave > claveHoy -> null
        diaSemana == Calendar.SATURDAY -> EstadoDiaAsistencia.NO_LABORAL
        dia == 8 -> EstadoDiaAsistencia.AUSENTE
        else -> EstadoDiaAsistencia.ASISTIDO
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF8A94A6, name = "Calendario")
@Composable
fun CalendarioAsistenciaContenidoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        CalendarioAsistenciaContenido(
            onSalir = {},
            modifier = Modifier.padding(24.dp)
        )
    }
}