package com.example.smartvolt.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun ResumenAsistenciaMensualCard(
    mes: String = "Octubre",
    asistenciasMarcadas: Int = 15,
    asistenciasTotales: Int = 30,
    modifier: Modifier = Modifier
) {
    // Cálculo automático del porcentaje de cumplimiento (0% - 100%)
    val porcentajeCalculado = if (asistenciasTotales > 0) {
        ((asistenciasMarcadas.toFloat() / asistenciasTotales.toFloat()) * 100).toInt()
    } else {
        0
    }

    // Progreso normalizado entre 0.0f y 1.0f para el indicador circular
    val progresoFloat = if (asistenciasTotales > 0) {
        (asistenciasMarcadas.toFloat() / asistenciasTotales.toFloat()).coerceIn(0f, 1f)
    } else {
        0f
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título superior de la sección
            Text(
                text = "Asistencias de $mes",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Gráfico Circular de Progreso con texto en el centro
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(150.dp)
            ) {
                // Indicador circular de Material Design 3
                CircularProgressIndicator(
                    progress = { progresoFloat },
                    modifier = Modifier.fillMaxSize(),
                    color = AzulCorporativo,
                    strokeWidth = 12.dp,
                    trackColor = AzulCorporativo.copy(alpha = 0.12f),
                    strokeCap = StrokeCap.Round
                )

                // Texto interno: "15/30" y "asistencias"
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$asistenciasMarcadas/$asistenciasTotales",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextoPrincipal
                    )
                    Text(
                        text = "asistencias",
                        fontSize = 13.sp,
                        color = TextoSecundario
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Porcentaje Total destacado
            Text(
                text = "Total: $porcentajeCalculado%",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AzulCorporativo
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Leyenda explicativa en el pie de la tarjeta
            Text(
                text = "Tienes $asistenciasMarcadas asistencias marcadas de los $asistenciasTotales turnos que te fueron asignados",
                fontSize = 13.sp,
                color = TextoSecundario,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        }
    }
}

@Preview(showBackground = true, name = "1. Mitad del Mes (50%)")
@Composable
fun ResumenAsistencia50PercentPreview() {
    SmartVoltTheme {
        ResumenAsistenciaMensualCard(
            mes = "Octubre",
            asistenciasMarcadas = 15,
            asistenciasTotales = 30,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Mes Completo (100%)")
@Composable
fun ResumenAsistencia100PercentPreview() {
    SmartVoltTheme {
        ResumenAsistenciaMensualCard(
            mes = "Octubre",
            asistenciasMarcadas = 22,
            asistenciasTotales = 22,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Inicio de Mes (0%)")
@Composable
fun ResumenAsistencia0PercentPreview() {
    SmartVoltTheme {
        ResumenAsistenciaMensualCard(
            mes = "Noviembre",
            asistenciasMarcadas = 0,
            asistenciasTotales = 20,
            modifier = Modifier.padding(16.dp)
        )
    }
}

