package com.example.smartvolt.ui.components

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
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.ui.theme.AmarilloCalido
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Representa los 3 estados posibles de la tarjeta según el flujo del mockup:
 * 1. NO_REGISTRADO: Barra amarilla, rayo opaco/gris.
 * 2. REGISTRADO: Barra azul, rayo amarillo brillante.
 * 3. PENDIENTE_CONEXION: Barra azul, rayo opaco/gris.
 */
enum class EstadoAsistencia {
    NO_REGISTRADO,
    REGISTRADO,
    PENDIENTE_CONEXION
}

@Composable
fun EstadoAsistenciaCard(
    fechaTurno: String = "Turno del 12 de octubre",
    horario: String = "8:30 a.m - 5 p.m",
    detalleColacion: String = "30 minutos de colación",
    estado: EstadoAsistencia = EstadoAsistencia.NO_REGISTRADO,
    modifier: Modifier = Modifier
) {
    // Configuración dinámica de colores y texto según el estado solicitado
    val (colorBarra, colorIconoRayo, colorTextoBarra, mensajeBarra) = when (estado) {
        EstadoAsistencia.NO_REGISTRADO -> Quadruple(
            first = AmarilloCalido,                             // Barra amarilla
            second = Color.Gray.copy(alpha = 0.6f),             // Rayo pierde opacidad (gris)
            third = TextoSobreAmarillo,                         // Texto oscuro
            fourth = "¡Aún no marcas tu asistencia!"
        )
        EstadoAsistencia.REGISTRADO -> Quadruple(
            first = AzulCorporativo,                            // Barra azul
            second = AmarilloPrincipal,                         // Rayo retoma su amarillo original
            third = TextoSobreAzul,                             // Texto blanco
            fourth = "¡Asistencia registrada con éxito!"
        )
        EstadoAsistencia.PENDIENTE_CONEXION -> Quadruple(
            first = AzulCorporativo,                            // Barra azul (sin preocupación)
            second = Color.LightGray.copy(alpha = 0.7f),        // Rayo opaco/gris
            third = TextoSobreAzul,                             // Texto blanco
            fourth = "Marca registrada sin conexión (pendiente)"
        )
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Título de la tarjeta
            Text(
                text = fechaTurno,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila central: Ícono de reloj + Horario de trabajo
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.Schedule,
                    contentDescription = "Horario de turno",
                    modifier = Modifier.size(44.dp),
                    tint = AzulCorporativo
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = horario,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = detalleColacion,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Barra / Contenedor inferior dinámico
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorBarra)
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    // Carga del vector bolt_vector.xml con el tinte dinámico
                    Icon(
                        painter = painterResource(id = R.drawable.bolt_vector),
                        contentDescription = "Ícono de estado",
                        modifier = Modifier.size(24.dp),
                        tint = colorIconoRayo
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = mensajeBarra,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorTextoBarra
                    )
                }
            }
        }
    }
}

// Estructura auxiliar simple para retornar los 4 valores de estilo sin crear clases complejas
private data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)


@Preview(showBackground = true, name = "1. No Registrado (Amarillo + Rayo Gris)")
@Composable
fun EstadoAsistenciaCardNoRegistradoPreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            estado = EstadoAsistencia.NO_REGISTRADO,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Registrado Exitoso (Azul + Rayo Amarillo)")
@Composable
fun EstadoAsistenciaCardRegistradoPreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            estado = EstadoAsistencia.REGISTRADO,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Pendiente Sin Conexión (Azul + Rayo Gris)")
@Composable
fun EstadoAsistenciaCardPendienteConexionPreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            estado = EstadoAsistencia.PENDIENTE_CONEXION,
            modifier = Modifier.padding(16.dp)
        )
    }
}
