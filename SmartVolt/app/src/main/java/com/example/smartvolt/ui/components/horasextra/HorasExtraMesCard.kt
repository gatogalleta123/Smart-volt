package com.example.smartvolt.ui.components.horasextra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoJornadaExtra
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.JornadaHorasExtra
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulElectrico
import com.example.smartvolt.ui.theme.AzulMarino
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAzul

/** Tarjeta oscura "Horas extra del mes" con botón de período y detalle por jornada. */
@Composable
fun HorasExtraMesCard(
    horasFormateadas: String,
    periodo: String,
    jornadas: List<JornadaHorasExtra>,
    modifier: Modifier = Modifier,
    onCambiarPeriodo: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AzulMarino)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Horas extra del mes",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextoSobreAzul
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = horasFormateadas,
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
            color = AzulElectrico
        )
        Text(text = periodo, fontSize = 12.sp, color = TextoSobreAzul)

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onCambiarPeriodo,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulCorporativo,
                contentColor = TextoSobreAzul
            )
        ) {
            Text(text = "Cambiar periodo", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 24.dp),
            color = TextoSobreAzul.copy(alpha = 0.6f)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Detalle de las horas extra:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TextoSobreAzul,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (jornadas.isEmpty()) {
            Text(
                text = "No hay horas extra registradas en este período",
                fontSize = 13.sp,
                color = TextoSobreAzul.copy(alpha = 0.8f)
            )
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                jornadas.forEachIndexed { indice, jornada ->
                    // key evita que el estado desplegado se mezcle entre ítems
                    key(jornada.id) {
                        JornadaHorasExtraItem(
                            jornada = jornada,
                            inicialmenteExpandido = indice == 0
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Con jornadas")
@Composable
fun HorasExtraMesCardPreview() {
    val marcas = listOf(
        MarcaDetalle(
            titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        ),
        MarcaDetalle(
            titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        )
    )
    SmartVoltTheme(dynamicColor = false) {
        HorasExtraMesCard(
            horasFormateadas = "12h 30 min",
            periodo = "Octubre 2026",
            jornadas = listOf(
                JornadaHorasExtra("1", "23 de Octubre", "16:00 p.m. - 18:00 p.m. (2horas)", EstadoJornadaExtra.APROBADAS, marcas),
                JornadaHorasExtra("2", "23 de Octubre", "16:00 p.m. - 18:00 p.m. (2horas)", EstadoJornadaExtra.PENDIENTE, marcas)
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Sin jornadas")
@Composable
fun HorasExtraMesCardVaciaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        HorasExtraMesCard(
            horasFormateadas = "0h 00 min",
            periodo = "Noviembre 2026",
            jornadas = emptyList(),
            modifier = Modifier.padding(16.dp)
        )
    }
}