package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Etiqueta pequeña redondeada ("Validada", "Pendiente", "Aprobadas"...). */
@Composable
fun BadgeEstado(
    texto: String,
    fondo: Color,
    colorTexto: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(fondo)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = texto,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = colorTexto
        )
    }
}