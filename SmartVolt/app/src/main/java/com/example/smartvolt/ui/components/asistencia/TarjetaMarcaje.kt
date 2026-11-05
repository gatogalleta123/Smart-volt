package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Tarjeta grande de marcaje (entrada o salida).
 * - sinConexion = false -> degradado azul, texto blanco
 * - sinConexion = true  -> degradado amarillo, texto oscuro
 */
@Composable
fun TarjetaMarcaje(
    titulo: String,
    hora: String,
    sinConexion: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val fondo = if (sinConexion) SmartVoltGradients.MarcajeOffline else SmartVoltGradients.MarcajeOnline
    val colorTexto = if (sinConexion) TextoSobreAmarillo else TextoSobreAzul

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(brush = fondo)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            // Imagen del badge (reemplaza al círculo azul + rayo)
            Image(
                painter = painterResource(id = R.drawable.badge_asistencia_foto),
                contentDescription = "Marcar asistencia",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(56.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = titulo,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = colorTexto
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = hora, fontSize = 14.sp, color = colorTexto)
        }
    }
}

@Preview(showBackground = true, name = "1. Entrada (online)")
@Composable
fun TarjetaMarcajeEntradaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Validar y marcar entrada",
            hora = "08:30 a.m",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Entrada sin conexión")
@Composable
fun TarjetaMarcajeEntradaOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Validar y marcar entrada sin conexión",
            hora = "08:30 a.m",
            sinConexion = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Salida (online)")
@Composable
fun TarjetaMarcajeSalidaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Validar y Marcar Salida",
            hora = "5:30 p.m",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "4. Salida sin conexión")
@Composable
fun TarjetaMarcajeSalidaOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Marcar Salida sin conexion",
            hora = "5:30 p.m",
            sinConexion = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}