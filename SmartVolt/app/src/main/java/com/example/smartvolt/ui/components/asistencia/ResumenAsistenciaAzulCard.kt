package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulElectrico
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAzul

/** Resumen mensual con fondo azul degradado y gráfico circular sobre panel blanco. */
@Composable
fun ResumenAsistenciaAzulCard(
    mes: String = "Octubre",
    asistenciasMarcadas: Int = 15,
    asistenciasTotales: Int = 30,
    modifier: Modifier = Modifier
) {
    val progreso = if (asistenciasTotales > 0) {
        (asistenciasMarcadas.toFloat() / asistenciasTotales.toFloat()).coerceIn(0f, 1f)
    } else 0f
    val porcentaje = (progreso * 100).toInt()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Brush.verticalGradient(listOf(AzulElectrico, AzulProfundo)))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Asistencias de $mes",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextoSobreAzul
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Panel blanco con el gráfico circular
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Superficie)
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(150.dp)) {
                CircularProgressIndicator(
                    progress = { progreso },
                    modifier = Modifier.fillMaxSize(),
                    color = AzulCorporativo,
                    strokeWidth = 12.dp,
                    trackColor = AzulCorporativo.copy(alpha = 0.12f),
                    strokeCap = StrokeCap.Round
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$asistenciasMarcadas/$asistenciasTotales",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextoPrincipal
                    )
                    Text(text = "asistencias", fontSize = 13.sp, color = TextoSecundario)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = TextoSobreAzul)) { append("Total: ") }
                withStyle(SpanStyle(color = AmarilloPrincipal)) { append("$porcentaje%") }
            },
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Tienes $asistenciasMarcadas asistencias marcadas de los $asistenciasTotales turnos que te fueron asignados",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextoSobreAzul,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, name = "50%")
@Composable
fun ResumenAsistenciaAzulCardPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ResumenAsistenciaAzulCard(modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true, name = "0%")
@Composable
fun ResumenAsistenciaAzulCardVacioPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ResumenAsistenciaAzulCard(
            mes = "Noviembre",
            asistenciasMarcadas = 0,
            asistenciasTotales = 20,
            modifier = Modifier.padding(16.dp)
        )
    }
}