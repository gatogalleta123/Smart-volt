package com.example.smartvolt.ui.components.encabezados

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun HeaderSmartVolt(
    nombreUsuario: String = "Juan Pérez",
    cargoUsuario: String = "Operador de Faena",
    onPerfilClick: () -> Unit = {},
    onQrClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(AzulRey)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Lado Izquierdo: Avatar Circular + Nombre y Cargo
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .clickable { onPerfilClick() }
                .padding(vertical = 4.dp, horizontal = 4.dp)
        ) {
            // Contenedor del avatar circular de usuario
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(TextoSobreAzul.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Perfil del usuario",
                    tint = TextoSobreAzul,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Datos del Usuario
            Column {
                Text(
                    text = nombreUsuario,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoSobreAzul
                )
                Text(
                    text = cargoUsuario,
                    fontSize = 12.sp,
                    color = TextoSobreAzul.copy(alpha = 0.8f)
                )
            }
        }

        // Lado Derecho: Botón interactivo "Escanear QR"
        Surface(
            onClick = onQrClick,
            shape = RoundedCornerShape(20.dp),
            color = TextoSobreAzul.copy(alpha = 0.15f),
            contentColor = TextoSobreAzul
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.QrCodeScanner,
                    contentDescription = "Escanear código QR",
                    modifier = Modifier.size(18.dp),
                    tint = TextoSobreAzul
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Escanear QR",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoSobreAzul
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderSmartVoltPreview() {
    SmartVoltTheme {
        HeaderSmartVolt(
            nombreUsuario = "Carlos Mendoza",
            cargoUsuario = "Técnico Electricista"
        )
    }
}
