package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul
import kotlinx.coroutines.launch

/** Popup (bottom sheet) con las marcas del mes guardadas en Room. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleAsistenciasSheet(
    mes: String,
    ultimaActualizacion: String,
    marcas: List<RegistroMarca>,
    onDismiss: () -> Unit
) {
    val estadoSheet = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    fun cerrar() {
        scope.launch { estadoSheet.hide() }.invokeOnCompletion {
            if (!estadoSheet.isVisible) onDismiss()
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = estadoSheet,
        containerColor = Superficie
    ) {
        // Cabecera: "Detalle" + X
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Detalle", fontSize = 18.sp, color = TextoPrincipal)
            IconButton(onClick = { cerrar() }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Cerrar",
                    tint = TextoPrincipal
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp),
            color = Borde
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f, fill = false)
                .navigationBarsPadding(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Asistencias de $mes",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextoPrincipal,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Última actualización: $ultimaActualizacion",
                        fontSize = 14.sp,
                        color = TextoSecundario
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            if (marcas.isEmpty()) {
                item {
                    Text(
                        text = "Aún no tienes marcas este mes. Registra una desde la pestaña Marcaje.",
                        fontSize = 14.sp,
                        color = TextoSecundario,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )
                }
            } else {
                items(marcas, key = { it.id }) { marca ->
                    ItemDetalleMarca(marca)
                }
            }
        }
    }
}

@Composable
private fun ItemDetalleMarca(marca: RegistroMarca) {
    val (fondoBadge, textoBadge, etiqueta) = when (marca.estado) {
        EstadoMarca.VALIDADA -> Triple(Exito, TextoSobreAzul, "Validada")
        EstadoMarca.PENDIENTE -> Triple(AmarilloPrincipal, TextoSobreAmarillo, "Pendiente")
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        border = BorderStroke(1.dp, Borde),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = marca.tipo.tituloDisplay,
                    fontSize = 18.sp,
                    color = TextoPrincipal
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${marca.fecha} - ${marca.ubicacionFaena}",
                    fontSize = 16.sp,
                    color = TextoSecundario
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = marca.hora,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )
                Spacer(modifier = Modifier.height(6.dp))
                BadgeEstado(texto = etiqueta, fondo = fondoBadge, colorTexto = textoBadge)
            }
        }
    }
}