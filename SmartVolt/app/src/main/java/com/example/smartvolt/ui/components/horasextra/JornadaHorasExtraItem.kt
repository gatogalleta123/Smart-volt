package com.example.smartvolt.ui.components.horasextra

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoJornadaExtra
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.JornadaHorasExtra
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.ui.components.asistencia.BadgeEstado
import com.example.smartvolt.ui.components.asistencia.MarcaAsistenciaCard
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.ErrorClaro
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.ExitoClaro
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Jornada con horas extra: cabecera (reloj de color según estado, fecha, horario, badge, flecha)
 * y, al desplegar, las marcas asociadas.
 */
@Composable
fun JornadaHorasExtraItem(
    jornada: JornadaHorasExtra,
    modifier: Modifier = Modifier,
    inicialmenteExpandido: Boolean = false
) {
    var expandido by remember { mutableStateOf(inicialmenteExpandido) }

    val colorReloj = when (jornada.estado) {
        EstadoJornadaExtra.APROBADAS -> ExitoClaro
        EstadoJornadaExtra.PENDIENTE -> AmarilloPrincipal
        EstadoJornadaExtra.RECHAZADAS -> ErrorClaro
    }
    val (fondoBadge, textoBadge) = when (jornada.estado) {
        EstadoJornadaExtra.APROBADAS -> Exito to TextoSobreAzul
        EstadoJornadaExtra.PENDIENTE -> AmarilloPrincipal to TextoSobreAmarillo
        EstadoJornadaExtra.RECHAZADAS -> Error to TextoSobreAzul
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(AzulProfundo)
    ) {
        // Cabecera (siempre visible)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulCorporativo)
                .clickable { expandido = !expandido }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Schedule,
                contentDescription = "Horas extra",
                tint = colorReloj,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = jornada.fecha,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoSobreAzul
                )
                Text(
                    text = jornada.horario,
                    fontSize = 11.sp,
                    color = TextoSobreAzul.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                BadgeEstado(
                    texto = jornada.estado.etiqueta,
                    fondo = fondoBadge,
                    colorTexto = textoBadge
                )
            }
            Icon(
                imageVector = if (expandido) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expandido) "Colapsar" else "Desplegar",
                tint = TextoSobreAzul,
                modifier = Modifier.size(28.dp)
            )
        }

        // Detalle desplegable
        AnimatedVisibility(
            visible = expandido,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                jornada.marcas.forEachIndexed { indice, marca ->
                    if (indice > 0) {
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            color = TextoSobreAzul.copy(alpha = 0.5f)
                        )
                    }
                    MarcaAsistenciaCard(marca = marca, colorFondo = Color.Transparent)
                }
            }
        }
    }
}

private fun jornadaEjemplo(estado: EstadoJornadaExtra) = JornadaHorasExtra(
    id = "1",
    fecha = "23 de Octubre",
    horario = "16:00 p.m. - 18:00 p.m. (2horas)",
    estado = estado,
    marcas = listOf(
        MarcaDetalle(
            titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        ),
        MarcaDetalle(
            titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        )
    )
)

@Preview(showBackground = true, name = "Aprobadas - desplegada")
@Composable
fun JornadaHorasExtraAprobadaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        JornadaHorasExtraItem(
            jornada = jornadaEjemplo(EstadoJornadaExtra.APROBADAS),
            inicialmenteExpandido = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Pendiente - colapsada")
@Composable
fun JornadaHorasExtraPendientePreview() {
    SmartVoltTheme(dynamicColor = false) {
        JornadaHorasExtraItem(
            jornada = jornadaEjemplo(EstadoJornadaExtra.PENDIENTE),
            modifier = Modifier.padding(16.dp)
        )
    }
}