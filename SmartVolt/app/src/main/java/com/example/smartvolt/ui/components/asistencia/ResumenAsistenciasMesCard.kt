package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

/** Tarjeta resumen: título, cantidad de asistencias del mes y enlace "Ver detalle". */
@Composable
fun ResumenAsistenciasMesCard(
    cantidad: Int,
    onVerDetalle: () -> Unit,
    modifier: Modifier = Modifier,
    titulo: String = "Asistencias del mes"
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = titulo,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = cantidad.toString(),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Normal,
                    color = AzulCorporativo
                )
                Text(
                    text = "Ver detalle",
                    fontSize = 18.sp,
                    color = AzulCorporativo,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable(onClick = onVerDetalle)
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumenAsistenciasMesCardPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ResumenAsistenciasMesCard(
            cantidad = 23,
            onVerDetalle = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}