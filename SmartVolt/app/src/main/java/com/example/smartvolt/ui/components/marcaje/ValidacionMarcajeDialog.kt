package com.example.smartvolt.ui.components.marcaje

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.Totem
import com.example.smartvolt.ui.theme.AmarilloOro
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.Pendiente
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

/**
 * Flujo de validación: buscando tótems -> elegir tótem -> aviso de foto
 * -> cámara -> revisar foto -> "Buen turno".
 * (El paso SOLICITANDO_CAMARA no dibuja nada: lo resuelve el permiso del sistema.)
 */
@Composable
fun ValidacionMarcajeDialog(
    paso: PasoValidacion,
    totems: List<Totem>,
    foto: File?,
    horaMarca: String,
    onSeleccionarTotem: (Totem) -> Unit,
    onConfirmarAviso: () -> Unit,
    onFotoTomada: (File) -> Unit,
    onContinuarFoto: () -> Unit,
    onReintentarFoto: () -> Unit,
    onContinuarBuenTurno: () -> Unit,
    onCancelar: () -> Unit,
    horaSalida: String = "5 p.m."
) {
    // La cámara va en su propia pantalla completa
    if (paso == PasoValidacion.CAMARA) {
        PantallaCamaraFrontal(onFotoTomada = onFotoTomada, onCancelar = onCancelar)
        return
    }

    val visible = paso == PasoValidacion.BUSCANDO_TOTEMS ||
            paso == PasoValidacion.SELECCION_TOTEM ||
            paso == PasoValidacion.CONFIRMAR_FOTO ||
            paso == PasoValidacion.REVISAR_FOTO ||
            paso == PasoValidacion.BUEN_TURNO
    if (!visible) return

    // En "Buen turno" no se puede cerrar tocando fuera ni con "atrás"
    val sePuedeCerrar = paso != PasoValidacion.BUEN_TURNO

    Dialog(
        onDismissRequest = onCancelar,
        properties = DialogProperties(
            dismissOnBackPress = sePuedeCerrar,
            dismissOnClickOutside = sePuedeCerrar,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Superficie),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (paso == PasoValidacion.BUEN_TURNO) {
                    PasoBuenTurno(
                        hora = horaMarca,
                        horaSalida = horaSalida,
                        onContinuar = onContinuarBuenTurno
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        when (paso) {
                            PasoValidacion.BUSCANDO_TOTEMS -> PasoBuscando()
                            PasoValidacion.SELECCION_TOTEM -> PasoSeleccion(totems, onSeleccionarTotem)
                            PasoValidacion.CONFIRMAR_FOTO -> PasoAvisoFoto(onConfirmarAviso, onCancelar)
                            PasoValidacion.REVISAR_FOTO -> PasoRevisarFoto(foto, onContinuarFoto, onReintentarFoto)
                            else -> Unit
                        }
                    }
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
private fun PasoAvisoFoto(
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
    BotonAzul(texto = "Confirmar", onClick = onConfirmar)
    Spacer(modifier = Modifier.height(12.dp))
    BotonAzul(texto = "Volver", onClick = onVolver)
}

@Composable
private fun PasoRevisarFoto(
    foto: File?,
    onContinuar: () -> Unit,
    onReintentar: () -> Unit
) {
    Text(
        text = "Confirma tu foto para continuar:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Se decodifica en segundo plano (reducida a la mitad para no gastar memoria)
    val imagen by produceState<ImageBitmap?>(initialValue = null, key1 = foto) {
        value = if (foto == null) null else withContext(Dispatchers.IO) {
            val opciones = BitmapFactory.Options().apply { inSampleSize = 2 }
            BitmapFactory.decodeFile(foto.absolutePath, opciones)?.asImageBitmap()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Pendiente.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        val bitmap = imagen
        if (bitmap != null) {
            Image(
                bitmap = bitmap,
                contentDescription = "Foto tomada",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                tint = TextoPrincipal,
                modifier = Modifier.size(96.dp)
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
    BotonAzul(texto = "Continuar", onClick = onContinuar)
    Spacer(modifier = Modifier.height(12.dp))
    BotonAzul(texto = "Reintentar", onClick = onReintentar)
}

@Composable
private fun PasoBuenTurno(
    hora: String,
    horaSalida: String,
    onContinuar: () -> Unit
) {
    // Franja amarilla superior
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(14.dp)
            .background(
                Brush.horizontalGradient(listOf(AmarilloOro, AmarilloPrincipal, AmarilloOro))
            )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Buen turno!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tu asistencia se registró con éxito a las $hora, recuerda marcar salida a las $horaSalida",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = TextoPrincipal
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(width = 4.dp, color = AmarilloPrincipal, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Asistencia registrada",
                tint = AmarilloPrincipal,
                modifier = Modifier.size(56.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(brush = SmartVoltGradients.YellowButton)
                .clickable(onClick = onContinuar),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Continuar",
                fontWeight = FontWeight.Bold,
                color = TextoSobreAmarillo
            )
        }
    }
}

@Composable
private fun BotonAzul(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AzulProfundo,
            contentColor = TextoSobreAzul
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = texto, fontWeight = FontWeight.Bold)
    }
}

private val totemsPreview = listOf(
    Totem("1", "Totem Obra 2"),
    Totem("2", "Totem Obra 3"),
    Totem("3", "Totem Obra 6")
)

@Composable
private fun DialogoPreview(paso: PasoValidacion) {
    SmartVoltTheme(dynamicColor = false) {
        ValidacionMarcajeDialog(
            paso = paso,
            totems = totemsPreview,
            foto = null,
            horaMarca = "8:31",
            onSeleccionarTotem = {},
            onConfirmarAviso = {},
            onFotoTomada = {},
            onContinuarFoto = {},
            onReintentarFoto = {},
            onContinuarBuenTurno = {},
            onCancelar = {}
        )
    }
}

@Preview(showBackground = true, name = "1. Buscando")
@Composable
fun ValidacionBuscandoPreview() = DialogoPreview(PasoValidacion.BUSCANDO_TOTEMS)

@Preview(showBackground = true, name = "2. Selección")
@Composable
fun ValidacionSeleccionPreview() = DialogoPreview(PasoValidacion.SELECCION_TOTEM)

@Preview(showBackground = true, name = "3. Aviso foto")
@Composable
fun ValidacionAvisoFotoPreview() = DialogoPreview(PasoValidacion.CONFIRMAR_FOTO)

@Preview(showBackground = true, name = "4. Revisar foto")
@Composable
fun ValidacionRevisarFotoPreview() = DialogoPreview(PasoValidacion.REVISAR_FOTO)

@Preview(showBackground = true, name = "5. Buen turno")
@Composable
fun ValidacionBuenTurnoPreview() = DialogoPreview(PasoValidacion.BUEN_TURNO)