package com.example.smartvolt.ui.components.perfil

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

/** Campo de solo lectura con borde redondeado para mostrar un dato del perfil. */
@Composable
fun CampoDatoPerfil(
    texto: String,
    modifier: Modifier = Modifier
) {
    val forma = RoundedCornerShape(8.dp)
    Box(
        modifier = modifier
            .widthIn(min = 150.dp)
            .border(width = 1.dp, color = TextoSecundario.copy(alpha = 0.6f), shape = forma)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = TextoPrincipal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CampoDatoPerfilPreview() {
    SmartVoltTheme(dynamicColor = false) {
        CampoDatoPerfil(texto = "Nombre usuario", modifier = Modifier.padding(16.dp))
    }
}