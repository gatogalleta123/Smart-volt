package com.example.smartvolt.ui.components.ubicacion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.FondoError
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal

/** Aviso que se muestra cuando el GPS reporta una ubicación simulada. */
@Composable
fun AlertaAnomaliaUbicacion(
    visible: Boolean,
    onCerrar: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(visible = visible, modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = FondoError),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 4.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Filled.Warning,
                    contentDescription = null,
                    tint = Error,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Anomalía en tu ubicación",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Error
                    )
                    Spacer(modifier = Modifier.width(0.dp))
                    Text(
                        text = "El GPS de este dispositivo parece simulado (Fake GPS o ubicación de prueba). " +
                                "Tu marca quedará pendiente de revisión por tu supervisor.",
                        fontSize = 13.sp,
                        color = TextoPrincipal
                    )
                }
                IconButton(onClick = onCerrar) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Cerrar alerta",
                        tint = TextoPrincipal
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Alerta de anomalía")
@Composable
fun AlertaAnomaliaUbicacionPreview() {
    SmartVoltTheme(dynamicColor = false) {
        AlertaAnomaliaUbicacion(
            visible = true,
            onCerrar = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}