package com.example.smartvolt.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.SmartVoltTheme

@Composable
fun EstadoAsistenciaCard(
    horario: String,
    estadoTexto: String,
    subtexto: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
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
            Text(
                text = "Jornada asignada",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = horario,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = estadoTexto,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtexto,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


@Preview(showBackground = true, name = "Estado: Pendiente de Marca")
@Composable
fun EstadoAsistenciaCardPendientePreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            horario = "08:30 hrs - 17:00 hrs",
            estadoTexto = "Aún no registras tu entrada",
            subtexto = "Acércate a un tótem habilitado para marcar asistencia",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Estado: Entrada Registrada")
@Composable
fun EstadoAsistenciaCardRegistradoPreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            horario = "08:30 hrs - 17:00 hrs",
            estadoTexto = "Entrada marcada a las 08:25 hrs",
            subtexto = "Tótem Faena Central • Verificado con GPS y BT",
            modifier = Modifier.padding(16.dp)
        )
    }
}
