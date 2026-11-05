package com.example.smartvolt.ui.components.marcaje

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.Totem
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Diálogo del flujo de validación: buscando tótems -> elegir tótem -> aviso de foto.
 * Solo se dibuja en los pasos BUSCANDO_TOTEMS, SELECCION_TOTEM y CONFIRMAR_FOTO.
 */
@Composable
fun ValidacionMarcajeDialog(
    paso: PasoValidacion,
    totems: List<Totem>,
    onSeleccionarTotem: (Totem) -> Unit,
    onConfirmarFoto: () -> Unit,
    onCancelar: () -> Unit
) {
    val visible = paso == PasoValidacion.BUSCANDO_TOTEMS ||
            paso == PasoValidacion.SELECCION_TOTEM ||
            paso == PasoValidacion.CONFIRMAR_FOTO
    if (!visible) return

    Dialog(
        onDismissRequest = onCancelar,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Superficie)
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (paso) {
                    PasoValidacion.BUSCANDO_TOTEMS -> PasoBuscando()
                    PasoValidacion.SELECCION_TOTEM -> PasoSeleccion(totems, onSeleccionarTotem)
                    PasoValidacion.CONFIRMAR_FOTO -> PasoFoto(onConfirmarFoto, onCancelar)
                    else -> Unit
                }
            }
        }
    }
}

@Composable
private fun PasoBuscando() {
    Text(
        text = "Buscando tótems cercanos",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(text = "Por favor espera...", fontSize = 12.sp, color = TextoSecundario)
    Spacer(modifier = Modifier.height(32.dp))
    CircularProgressIndicator(
        modifier = Modifier.size(90.dp),
        color = AzulCorporativo,
        trackColor = AzulCorporativo.copy(alpha = 0.2f),
        strokeWidth = 10.dp,
        strokeCap = StrokeCap.Round
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
private fun PasoSeleccion(
    totems: List<Totem>,
    onSeleccionarTotem: (Totem) -> Unit
) {
    Text(
        text = "Escoge un tótem para marcar tu asistencia:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(24.dp))
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        totems.forEach { totem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onSeleccionarTotem(totem) }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(AzulCorporativo),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Bluetooth,
                        contentDescription = null,
                        tint = TextoSobreAzul,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = totem.nombre, fontSize = 14.sp, color = TextoPrincipal)
            }
        }
    }
}

@Composable
private fun PasoFoto(
    onConfirmar: () -> Unit,
    onVolver: () -> Unit
) {
    Text(
        text = "A continuación tomaremos una foto",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(text = "Para confirmar tu identidad...", fontSize = 12.sp, color = TextoPrincipal)
    Spacer(modifier = Modifier.height(24.dp))

    val colores = ButtonDefaults.buttonColors(
        containerColor = AzulProfundo,
        contentColor = TextoSobreAzul
    )
    Button(
        onClick = onConfirmar,
        shape = RoundedCornerShape(6.dp),
        colors = colores,
        modifier = Modifier.fillMaxWidth()
    ) { Text(text = "Confirmar", fontWeight = FontWeight.Bold) }

    Spacer(modifier = Modifier.height(12.dp))

    Button(
        onClick = onVolver,
        shape = RoundedCornerShape(6.dp),
        colors = colores,
        modifier = Modifier.fillMaxWidth()
    ) { Text(text = "Volver", fontWeight = FontWeight.Bold) }
}

private val totemsPreview = listOf(
    Totem("1", "Totem Obra 2"),
    Totem("2", "Totem Obra 3"),
    Totem("3", "Totem Obra 6")
)

@Preview(showBackground = true, name = "1. Buscando")
@Composable
fun ValidacionBuscandoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ValidacionMarcajeDialog(PasoValidacion.BUSCANDO_TOTEMS, totemsPreview, {}, {}, {})
    }
}

@Preview(showBackground = true, name = "2. Selección")
@Composable
fun ValidacionSeleccionPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ValidacionMarcajeDialog(PasoValidacion.SELECCION_TOTEM, totemsPreview, {}, {}, {})
    }
}

@Preview(showBackground = true, name = "3. Foto")
@Composable
fun ValidacionFotoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ValidacionMarcajeDialog(PasoValidacion.CONFIRMAR_FOTO, totemsPreview, {}, {}, {})
    }
}