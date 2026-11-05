package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material3.Icon
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
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.ErrorClaro
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.ExitoClaro
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Tarjeta de una marca: rayo + título + fecha/faena + badge a la izquierda,
 * hora + indicador (✓ / ! / ✗) a la derecha.
 * [colorFondo] permite usarla transparente dentro de la lista desplegable de horas extra.
 */
@Composable
fun MarcaAsistenciaCard(
    marca: MarcaDetalle,
    modifier: Modifier = Modifier,
    colorFondo: Color = AzulRey
) {
    val colorRayo = if (marca.estado == EstadoMarcaDetalle.VALIDADA) {
        AmarilloPrincipal
    } else {
        Color.Gray.copy(alpha = 0.7f)
    }
    val (fondoBadge, textoBadge) = when (marca.estado) {
        EstadoMarcaDetalle.VALIDADA -> Exito to TextoSobreAzul
        EstadoMarcaDetalle.PENDIENTE -> AmarilloPrincipal to TextoSobreAmarillo
        EstadoMarcaDetalle.SIN_REGISTRAR -> Error to TextoSobreAzul
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorFondo)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.bolt_vector),
            contentDescription = "Estado de la marca",
            tint = colorRayo,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = marca.titulo,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = TextoSobreAzul
            )
            Text(
                text = "${marca.fecha} - ${marca.faena}",
                fontSize = 11.sp,
                color = TextoSobreAzul.copy(alpha = 0.85f)
            )
            Spacer(modifier = Modifier.height(4.dp))
            BadgeEstado(
                texto = marca.estado.etiqueta,
                fondo = fondoBadge,
                colorTexto = textoBadge
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = marca.hora,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextoSobreAzul
            )
            Spacer(modifier = Modifier.height(4.dp))
            IndicadorEstadoMarca(marca.estado)
        }
    }
}

@Composable
private fun IndicadorEstadoMarca(estado: EstadoMarcaDetalle) {
    when (estado) {
        EstadoMarcaDetalle.VALIDADA -> Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Validada",
            tint = ExitoClaro,
            modifier = Modifier.size(30.dp)
        )

        EstadoMarcaDetalle.PENDIENTE -> Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(AmarilloPrincipal),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PriorityHigh,
                contentDescription = "Pendiente",
                tint = TextoSobreAmarillo,
                modifier = Modifier.size(18.dp)
            )
        }

        EstadoMarcaDetalle.SIN_REGISTRAR -> Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Sin registrar",
            tint = ErrorClaro,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFDCE5F1, name = "Estados de la marca")
@Composable
fun MarcaAsistenciaCardPreview() {
    SmartVoltTheme(dynamicColor = false) {
        Column(modifier = Modifier.padding(16.dp)) {
            EstadoMarcaDetalle.entries.forEach { estado ->
                MarcaAsistenciaCard(
                    marca = MarcaDetalle(
                        titulo = "Marca de entrada",
                        fecha = "23 de octubre",
                        faena = "Obra Norte",
                        hora = "9:31",
                        estado = estado
                    ),
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Sobre fondo AzulProfundo (lista desplegada)")
@Composable
fun MarcaAsistenciaCardTransparentePreview() {
    SmartVoltTheme(dynamicColor = false) {
        Box(modifier = Modifier.background(AzulProfundo)) {
            MarcaAsistenciaCard(
                marca = MarcaDetalle(
                    titulo = "Marca de salida",
                    fecha = "23 de octubre",
                    faena = "Obra Norte",
                    hora = "9:31",
                    estado = EstadoMarcaDetalle.VALIDADA
                ),
                colorFondo = Color.Transparent
            )
        }
    }
}