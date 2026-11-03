package com.example.smartvolt.ui.components.botones

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun BotonRegistrarAsistencia(
    texto: String = "Asistencia",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Superficie,
            contentColor = TextoPrincipal
        )
    ) {
        Text(text = texto, fontSize = 28.sp)
    }
}