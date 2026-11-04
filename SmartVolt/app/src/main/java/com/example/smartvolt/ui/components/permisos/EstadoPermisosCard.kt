package com.example.smartvolt.ui.components.permisos


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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoPermisos
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoAdvertencia
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun EstadoPermisosCard(
    estadoPermisos: EstadoPermisos = EstadoPermisos(),
    modifier: Modifier = Modifier
) {
    // Estado global de la tarjeta (Badge del encabezado)
    val (colorFondoHeader, colorTextoHeader, textoHeader) = if (estadoPermisos.todosActivos) {
        Triple(FondoExito, Exito, "3/3 Listos")
    } else {
        Triple(FondoAdvertencia, Advertencia, "${estadoPermisos.totalActivos}/3 Pendientes")
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            // Encabezado principal del panel
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Permisos y sensores",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoPrincipal
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Requisitos anti-fraude de faena",
                        fontSize = 12.sp,
                        color = TextoSecundario
                    )
                }

                // Badge de resumen general
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(colorFondoHeader)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = textoHeader,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorTextoHeader
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            HorizontalDivider(color = Borde.copy(alpha = 0.4f), thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))

            // 1. Ítem Bluetooth (Tótems de faena)
            ItemPermisoSensor(
                icono = Icons.Outlined.Bluetooth,
                titulo = "Bluetooth",
                descripcion = "Detección de tótems cercanos",
                activo = estadoPermisos.bluetoothActivo
            )

            HorizontalDivider(
                color = Borde.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // 2. Ítem Ubicación / GPS
            ItemPermisoSensor(
                icono = Icons.Outlined.LocationOn,
                titulo = "Ubicación GPS",
                descripcion = "Verificación de presencia en faena",
                activo = estadoPermisos.gpsActivo
            )

            HorizontalDivider(
                color = Borde.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // 3. Ítem Cámara
            ItemPermisoSensor(
                icono = Icons.Outlined.PhotoCamera,
                titulo = "Cámara",
                descripcion = "Validación de identidad",
                activo = estadoPermisos.camaraPermiso
            )
        }
    }
}

/**
 * Fila individual para representar el estado de un permiso/sensor específico
 */
@Composable
private fun ItemPermisoSensor(
    icono: ImageVector,
    titulo: String,
    descripcion: String,
    activo: Boolean
) {
    val colorIconoBox = if (activo) AzulCorporativo else Advertencia
    val fondoIconoBox = if (activo) AzulCorporativo.copy(alpha = 0.1f) else FondoAdvertencia

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            // Contenedor del ícono del sensor
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(fondoIconoBox),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icono,
                    contentDescription = titulo,
                    tint = colorIconoBox,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = titulo,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )
                Text(
                    text = descripcion,
                    fontSize = 11.sp,
                    color = TextoSecundario
                )
            }
        }

        // Indicador de estado a la derecha (Checkmark verde o Alerta amarilla)
        if (activo) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Activo",
                tint = Exito,
                modifier = Modifier.size(22.dp)
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.ErrorOutline,
                    contentDescription = "Desactivado",
                    tint = Advertencia,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Requerido",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Advertencia
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "1. Todos los Permisos Activos")
@Composable
fun EstadoPermisosTodosActivosPreview() {
    SmartVoltTheme {
        EstadoPermisosCard(
            estadoPermisos = EstadoPermisos(
                bluetoothActivo = true,
                gpsActivo = true,
                camaraPermiso = true
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. GPS y Bluetooth Inactivos")
@Composable
fun EstadoPermisosPendientesPreview() {
    SmartVoltTheme {
        EstadoPermisosCard(
            estadoPermisos = EstadoPermisos(
                bluetoothActivo = false,
                gpsActivo = false,
                camaraPermiso = true
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Ningún Permiso Activo")
@Composable
fun EstadoPermisosSinPermisosPreview() {
    SmartVoltTheme {
        EstadoPermisosCard(
            estadoPermisos = EstadoPermisos(
                bluetoothActivo = false,
                gpsActivo = false,
                camaraPermiso = false
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}