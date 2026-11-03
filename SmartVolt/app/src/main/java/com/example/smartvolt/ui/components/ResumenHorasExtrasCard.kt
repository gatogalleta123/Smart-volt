package com.example.smartvolt.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.outlined.MoreTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun ResumenHorasExtrasCard(
    mes: String = "Octubre",
    horasFormateadas: String = "12h 30m",
    jornadasConExtra: Int = 4,
    estadoAprobacion: String = "Aprobadas",
    modifier: Modifier = Modifier
) {
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
                .padding(20.dp)
        ) {
            // Cabecera: Título y Badge de estado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Horas extras de $mes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                // Chip indicador de estado
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(FondoExito)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = estadoAprobacion,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Exito
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sección Central: Ícono + Total de horas acumuladas
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ícono destacado de Horas Extra (MoreTime)
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(AzulCorporativo.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.MoreTime,
                        contentDescription = "Horas Extraordinarias",
                        tint = AzulCorporativo,
                        modifier = Modifier.size(26.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = horasFormateadas,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = AzulCorporativo
                    )
                    Text(
                        text = "Acumuladas en $jornadasConExtra jornadas laborales",
                        fontSize = 12.sp,
                        color = TextoSecundario
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "1. Con Horas Extras Acumuladas")
@Composable
fun ResumenHorasExtrasConHorasPreview() {
    SmartVoltTheme {
        ResumenHorasExtrasCard(
            mes = "Octubre",
            horasFormateadas = "12h 30m",
            jornadasConExtra = 4,
            estadoAprobacion = "Aprobadas",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Sin Horas Extras Registradas")
@Composable
fun ResumenHorasExtrasCeroPreview() {
    SmartVoltTheme {
        ResumenHorasExtrasCard(
            mes = "Noviembre",
            horasFormateadas = "0h 00m",
            jornadasConExtra = 0,
            estadoAprobacion = "Sin registros",
            modifier = Modifier.padding(16.dp)
        )
    }
}