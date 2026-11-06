package com.example.smartvolt.ui.components.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.FondoAdvertencia
import com.example.smartvolt.ui.theme.SmartVoltTheme

/** Badge informativo (sin lógica) que invita a subir una foto de perfil. */
@Composable
fun BadgeAvisoFoto(
    texto: String = "¡Agregar una foto ayuda a tus jefes a identificarte!",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(FondoAdvertencia)
            .border(1.dp, Advertencia.copy(alpha = 0.4f), RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = null,
            tint = Advertencia,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = texto,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Advertencia
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BadgeAvisoFotoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        BadgeAvisoFoto(modifier = Modifier.padding(16.dp))
    }
}