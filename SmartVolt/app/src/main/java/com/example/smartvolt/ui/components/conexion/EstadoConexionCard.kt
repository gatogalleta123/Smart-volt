package com.example.smartvolt.ui.components.conexion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun EstadoConexionCard(
    estaConectado: Boolean = true,
    modifier: Modifier = Modifier
) {
    // Definición condicional según los 2 estados del mockup
    val colorFondo = Superficie
    val icono = if (estaConectado) Icons.Outlined.Wifi else Icons.Outlined.WifiOff
    val texto = if (estaConectado) "Estás conectado" else "No tienes conexión"
    val colorIcono = if (estaConectado) Exito else Error

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorFondo
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icono,
                contentDescription = texto,
                tint = colorIcono,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = texto,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal
            )
        }
    }
}


@Preview(showBackground = true, name = "1. Estado Online (Verde)")
@Composable
fun EstadoConexionOnlinePreview() {
    SmartVoltTheme {
        EstadoConexionCard(
            estaConectado = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Estado Offline (Rojo)")
@Composable
fun EstadoConexionOfflinePreview() {
    SmartVoltTheme {
        EstadoConexionCard(
            estaConectado = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}