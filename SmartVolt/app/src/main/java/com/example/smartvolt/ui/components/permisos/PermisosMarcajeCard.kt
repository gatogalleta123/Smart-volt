package com.example.smartvolt.ui.components.permisos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.TagFaces
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.smartvolt.model.domain.EstadoVerificacion
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

/**
 * Tarjeta "Estados de permiso" de la pantalla de marcaje.
 * Cada fila muestra: ícono del sensor + mensaje + indicador (✓ / ! / ✗).
 */
@Composable
fun PermisosMarcajeCard(
    estadoBluetooth: EstadoVerificacion = EstadoVerificacion.CORRECTO,
    estadoGps: EstadoVerificacion = EstadoVerificacion.ADVERTENCIA,
    estadoCamara: EstadoVerificacion = EstadoVerificacion.ERROR,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            ItemPermisoMarcaje(
                icono = Icons.Outlined.Bluetooth,
                estado = estadoBluetooth,
                textoBase = if (estadoBluetooth == EstadoVerificacion.CORRECTO)
                    "Validación del tótem (tu bluetooth está activado)"
                else "Validación del tótem pendiente, ",
                textoAccion = if (estadoBluetooth == EstadoVerificacion.CORRECTO)
                    null else "activa el bluetooth para seguir"
            )
            ItemPermisoMarcaje(
                icono = Icons.Filled.LocationOn,
                estado = estadoGps,
                textoBase = if (estadoGps == EstadoVerificacion.CORRECTO)
                    "Ubicación verificada en faena"
                else "Ubicación por verificar, ",
                textoAccion = if (estadoGps == EstadoVerificacion.CORRECTO)
                    null else "activa el gps para seguir"
            )
            ItemPermisoMarcaje(
                icono = Icons.Outlined.TagFaces,
                estado = estadoCamara,
                textoBase = if (estadoCamara == EstadoVerificacion.CORRECTO)
                    "Cámara lista para validar tu identidad"
                else "Activa los permisos para ",
                textoAccion = if (estadoCamara == EstadoVerificacion.CORRECTO)
                    null else "acceder a la cámara"
            )
        }
    }
}

@Composable
private fun ItemPermisoMarcaje(
    icono: ImageVector,
    estado: EstadoVerificacion,
    textoBase: String,
    textoAccion: String?
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            tint = TextoPrincipal,
            modifier = Modifier.size(28.dp)
        )

        Text(
            text = buildAnnotatedString {
                append(textoBase)
                if (textoAccion != null) {
                    withStyle(SpanStyle(color = AzulCorporativo)) { append(textoAccion) }
                }
            },
            fontSize = 12.sp,
            lineHeight = 15.sp,
            color = TextoPrincipal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        )

        IndicadorVerificacion(estado)
    }
}

@Composable
private fun IndicadorVerificacion(estado: EstadoVerificacion) {
    when (estado) {
        EstadoVerificacion.CORRECTO -> Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Correcto",
            tint = Exito,
            modifier = Modifier.size(26.dp)
        )

        EstadoVerificacion.ADVERTENCIA -> Box(
            modifier = Modifier
                .size(26.dp)
                .clip(CircleShape)
                .background(Advertencia),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PriorityHigh,
                contentDescription = "Advertencia",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

        EstadoVerificacion.ERROR -> Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Error",
            tint = Error,
            modifier = Modifier.size(26.dp)
        )
    }
}

@Preview(showBackground = true, name = "Como el mockup (✓ ! ✗)")
@Composable
fun PermisosMarcajeMockupPreview() {
    SmartVoltTheme(dynamicColor = false) {
        PermisosMarcajeCard(modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true, name = "Todo correcto")
@Composable
fun PermisosMarcajeCorrectoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        PermisosMarcajeCard(
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.CORRECTO,
            estadoCamara = EstadoVerificacion.CORRECTO,
            modifier = Modifier.padding(16.dp)
        )
    }
}