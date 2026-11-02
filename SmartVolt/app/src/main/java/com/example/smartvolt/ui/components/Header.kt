package com.example.smartvolt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun Header(
    saludo: String = "Hola Usuario!",
    fecha: String = "Lunes 12 de octubre",
    onClickNotificaciones: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = saludo,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextoSobreAzul
            )
            Text(
                text = fecha,
                fontSize = 14.sp,
                color = TextoSobreAzul.copy(alpha = 0.85f)
            )
        }
        IconButton(onClick = onClickNotificaciones) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notificaciones",
                tint = TextoSobreAzul,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}