package com.example.smartvolt.ui.components.horasextra

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.outlined.MoreTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.DetalleHorasExtra
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.ui.components.asistencia.ItemMarcaAsistencia
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoAdvertencia
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun ItemHorasExtraDesplegable(
    detalle: DetalleHorasExtra,
    modifier: Modifier = Modifier,
    inicialmenteExpandido: Boolean = false
) {
    // Estado interno para alternar la visibilidad de los detalles
    var expandido by remember { mutableStateOf(inicialmenteExpandido) }

    // Colores del badge según el estado de aprobación
    val (colorFondoBadge, colorTextoBadge, etiquetaEstado) = when (detalle.estado) {
        EstadoMarca.VALIDADA -> Triple(FondoExito, Exito, "Aprobadas")
        EstadoMarca.PENDIENTE -> Triple(FondoAdvertencia, Advertencia, "Pendientes")
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { expandido = !expandido }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // === VISTA SIN DESPLEGAR (RESUMEN) ===
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Izquierda: Ícono + Fecha y horario de entrada/salida
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(AzulCorporativo.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.MoreTime,
                            contentDescription = "Horas Extra",
                            tint = AzulCorporativo,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = detalle.fecha,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextoPrincipal
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "${detalle.horaEntrada} - ${detalle.horaSalida} (${detalle.totalHoras})",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AzulCorporativo
                        )
                    }
                }

                // Derecha: Badge de estado + Flecha de desplegado
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(colorFondoBadge)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = etiquetaEstado,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorTextoBadge
                        )
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    Icon(
                        imageVector = if (expandido) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (expandido) "Colapsar" else "Desplegar",
                        tint = TextoSecundario,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // === VISTA DESPLEGADA (DETALLE DE MARCAS) ===
            AnimatedVisibility(
                visible = expandido,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(14.dp))

                    HorizontalDivider(
                        color = Borde.copy(alpha = 0.5f),
                        thickness = 1.dp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Marcas asociadas a la jornada",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoSecundario,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // Marca 1: Inicio de Horas Extra
                    ItemMarcaAsistencia(
                        registro = detalle.marcaEntrada,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

                    // Marca 2: Término de Horas Extra
                    ItemMarcaAsistencia(
                        registro = detalle.marcaSalida,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, name = "1. Colapsado (Sin desplegar)")
@Composable
fun ItemHorasExtrasColapsadoPreview() {
    SmartVoltTheme {
        ItemHorasExtraDesplegable(
            detalle = DetalleHorasExtra(
                fecha = "23 de octubre",
                horaEntrada = "17:30 p.m.",
                horaSalida = "19:30 p.m.",
                totalHoras = "2h 00m",
                estado = EstadoMarca.VALIDADA
            ),
            inicialmenteExpandido = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Desplegado (Mostrando marcas)")
@Composable
fun ItemHorasExtrasDesplegadoPreview() {
    SmartVoltTheme {
        ItemHorasExtraDesplegable(
            detalle = DetalleHorasExtra(
                fecha = "23 de octubre",
                horaEntrada = "17:30 p.m.",
                horaSalida = "19:30 p.m.",
                totalHoras = "2h 00m",
                estado = EstadoMarca.VALIDADA
            ),
            inicialmenteExpandido = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}
