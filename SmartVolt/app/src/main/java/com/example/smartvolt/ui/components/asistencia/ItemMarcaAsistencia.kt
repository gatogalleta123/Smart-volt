package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Login
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.MoreTime
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.TimerOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.model.EstadoMarca
import com.example.smartvolt.model.RegistroMarca
import com.example.smartvolt.model.TipoMarca
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoAdvertencia
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun ItemMarcaAsistencia(
    registro: RegistroMarca,
    modifier: Modifier = Modifier
) {
    // 1. Ícono de acompañamiento según el tipo de marca (tamaño discreto)
    val iconoTipoMarca: ImageVector = when (registro.tipo) {
        TipoMarca.ENTRADA -> Icons.AutoMirrored.Outlined.Login
        TipoMarca.SALIDA -> Icons.AutoMirrored.Outlined.Logout
        TipoMarca.ENTRADA_COLACION -> Icons.Outlined.Restaurant
        TipoMarca.SALIDA_COLACION -> Icons.Outlined.Coffee
        TipoMarca.ENTRADA_HORAS_EXTRA -> Icons.Outlined.MoreTime
        TipoMarca.SALIDA_HORAS_EXTRA -> Icons.Outlined.TimerOff
    }

    // 2. Estado visual: Rayo amarillo si está Validada / Rayo gris si está Pendiente
    val (colorRayo, colorFondoBadge, colorTextoBadge, etiquetaEstado) = when (registro.estado) {
        EstadoMarca.VALIDADA -> Quadruple(
            first = AmarilloPrincipal,                 // Rayo amarillo brillante
            second = FondoExito,
            third = Exito,
            fourth = "Validada"
        )
        EstadoMarca.PENDIENTE -> Quadruple(
            first = Color.Gray.copy(alpha = 0.5f),     // Rayo gris desaturado
            second = FondoAdvertencia,
            third = Advertencia,
            fourth = "Pendiente"
        )
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = AzulCorporativo
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row() {
            // Vector de rayo (cambia entre amarillo normal y gris según la validez)
            Icon(
                painter = painterResource(id = R.drawable.bolt_vector),
                contentDescription = "Estado marcaje",
                tint = colorRayo,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Secciones a la izquierda: Título con ícono representativo pequeño + Fecha y Faena
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Ícono discreto al lado del texto (no roba atención)
                    Icon(
                        imageVector = iconoTipoMarca,
                        contentDescription = null,
                        tint = Superficie,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = registro.tipo.tituloDisplay,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoSobreAzul
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${registro.fecha} • ${registro.ubicacionFaena}",
                    fontSize = 12.sp,
                    color = TextoSobreAzul
                )
            }

            // Secciones a la derecha: Hora de registro + Indicador con Rayo y Badge de estado
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = registro.hora,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoSobreAzul
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Chip / Badge de estado
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(colorFondoBadge)
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = etiquetaEstado,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorTextoBadge
                        )
                    }
                }
            }
        }
    }
}

// Estructura auxiliar para desestructurar las 4 variables del estado
private data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)

@Preview(showBackground = true, name = "1. Entrada Validada (Rayo Amarillo)")
@Composable
fun ItemEntradaValidadaPreview() {
    SmartVoltTheme {
        ItemMarcaAsistencia(
            registro = RegistroMarca(
                tipo = TipoMarca.ENTRADA,
                hora = "08:30 a.m.",
                fecha = "23 de octubre",
                ubicacionFaena = "Faena Central",
                estado = EstadoMarca.VALIDADA
            ),
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Inicio Colación Pendiente (Rayo Gris)")
@Composable
fun ItemColacionPendientePreview() {
    SmartVoltTheme {
        ItemMarcaAsistencia(
            registro = RegistroMarca(
                tipo = TipoMarca.ENTRADA_COLACION,
                hora = "13:05 p.m.",
                fecha = "23 de octubre",
                ubicacionFaena = "Comedor Faena Norte",
                estado = EstadoMarca.PENDIENTE
            ),
            modifier = Modifier.padding(12.dp)
        )
    }
}
