package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.DatosPerfil
import com.example.smartvolt.ui.components.HeaderSmartVolt
import com.example.smartvolt.ui.components.perfil.AvatarPerfil
import com.example.smartvolt.ui.components.perfil.CampoDatoPerfil
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun PerfilView(
    datos: DatosPerfil = DatosPerfil(),
    onEditarFoto: () -> Unit = {},
    onEscanearQr: () -> Unit = {}
) {
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
                nombreUsuario = "${datos.nombre} ${datos.apellido}",
                onQrClick = onEscanearQr
            )
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
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
                        .padding(horizontal = 24.dp, vertical = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // TODO: pasar imagen = painterResource(R.drawable.tu_avatar) cuando agregues la imagen
                    AvatarPerfil(onEditar = onEditarFoto)

                    Text(
                        text = "Tus datos",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoPrincipal
                    )

                    CampoDatoPerfil(texto = datos.nombre)
                    CampoDatoPerfil(texto = datos.apellido)
                    CampoDatoPerfil(texto = datos.rut)
                    CampoDatoPerfil(texto = datos.telefono)
                    CampoDatoPerfil(texto = datos.correo)

                    Spacer(modifier = Modifier.height(8.dp))

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
                        color = TextoPrincipal
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        PerfilView()
    }
}