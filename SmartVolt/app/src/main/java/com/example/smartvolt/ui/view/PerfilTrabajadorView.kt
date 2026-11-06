package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.domain.DatosTrabajador
import com.example.smartvolt.model.domain.DiaSemana
import com.example.smartvolt.ui.components.HeaderSmartVolt
import com.example.smartvolt.ui.components.perfil.AvatarPerfil
import com.example.smartvolt.ui.components.perfil.BadgeAvisoFoto
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.SuperficieSecundaria
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAzul
import com.example.smartvolt.viewmodel.PerfilTrabajadorViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun PerfilTrabajadorView(
    viewModel: PerfilTrabajadorViewModel = viewModel(),
    onEditarFoto: () -> Unit = {},
    onEscanearQr: () -> Unit = {}
) {
    val datos by viewModel.datos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Encabezado
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 24.dp)
        ) {
            HeaderSmartVolt(
                nombreUsuario = datos.nombreCompleto,
                cargoUsuario = datos.cargo,
                onQrClick = onEscanearQr
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CabeceraTrabajador(datos = datos, onEditarFoto = onEditarFoto)

            TarjetaSeccion(titulo = "Datos personales") {
                FilaDato(etiqueta = "RUT", valor = datos.rut)
                FilaDato(etiqueta = "Nombre completo", valor = datos.nombreCompleto)
            }

            TarjetaSeccion(titulo = "Información laboral") {
                FilaDato(etiqueta = "Cargo", valor = datos.cargo)
                FilaDato(etiqueta = "Área de trabajo", valor = datos.areaTrabajo)
                FilaDato(etiqueta = "Tipo de contrato", valor = datos.tipoContrato)
                FilaDato(etiqueta = "Fecha de ingreso", valor = datos.fechaIngreso)
                Column {
                    Text(
                        text = "Jornada",
                        fontSize = 12.sp,
                        color = TextoSecundario
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${datos.horasSemanales} horas semanales",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoPrincipal
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SelectorDias(diasActivos = datos.diasJornada)
                }
            }

            TarjetaSeccion(titulo = "Remuneración") {
                FilaDato(
                    etiqueta = "Sueldo bruto",
                    valor = formatearPesos(datos.sueldoBruto)
                )
                FilaDato(
                    etiqueta = "Sueldo líquido",
                    valor = formatearPesos(datos.sueldoLiquido)
                )
            }

            Text(
                text = buildAnnotatedString {
                    append("Para cambiar tus datos personales,\n")
                    withStyle(SpanStyle(color = AzulCorporativo)) {
                        append("contacta al administrador")
                    }
                },
                fontSize = 13.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center,
                color = TextoPrincipal,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun CabeceraTrabajador(
    datos: DatosTrabajador,
    onEditarFoto: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AvatarPerfil(onEditar = onEditarFoto)

            BadgeAvisoFoto()

            Text(
                text = datos.nombreCompleto,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal,
                textAlign = TextAlign.Center
            )
            Text(
                text = datos.cargo,
                fontSize = 14.sp,
                color = TextoSecundario
            )
        }
    }
}

@Composable
private fun TarjetaSeccion(
    titulo: String,
    contenido: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = titulo,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = AzulCorporativo
            )
            HorizontalDivider(color = Borde.copy(alpha = 0.5f), thickness = 1.dp)
            contenido()
        }
    }
}

@Composable
private fun FilaDato(etiqueta: String, valor: String) {
    Column {
        Text(
            text = etiqueta,
            fontSize = 12.sp,
            color = TextoSecundario
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = valor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )
    }
}

/** Muestra L a D con los días de la jornada resaltados. */
@Composable
private fun SelectorDias(diasActivos: Set<DiaSemana>) {
    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        DiaSemana.entries.forEach { dia ->
            val activo = dia in diasActivos
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(if (activo) AzulCorporativo else SuperficieSecundaria),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = dia.abreviatura,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (activo) TextoSobreAzul else TextoSecundario
                )
            }
        }
    }
}

private fun formatearPesos(monto: Long): String =
    NumberFormat.getCurrencyInstance(Locale("es", "CL")).format(monto)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilTrabajadorViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        PerfilTrabajadorView()
    }
}