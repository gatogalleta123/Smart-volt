package com.example.smartvolt.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Assignment
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.outlined.Accessibility
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.FondoInformacion
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.Informacion
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

private const val AVISO_FUTURAS_VERSIONES =
    "Estas funcionalidades se implementarán en futuras versiones del MVP."

@Composable
fun MenuView() {
    var mostrarAviso by remember { mutableStateOf(false) }

    if (mostrarAviso) {
        AlertaLogin(
            titulo = "Próximamente",
            mensajes = listOf(AVISO_FUTURAS_VERSIONES),
            icono = Icons.Outlined.Info,
            colorIcono = Informacion,
            fondoIcono = FondoInformacion,
            textoBoton = "Entendido",
            onCerrar = { mostrarAviso = false }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            color = AzulCorporativo
        ) {
            Image(
                painter = painterResource(R.drawable.smartvoltlogo5),
                contentDescription = "Logo de SmartVolt",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .height(80.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = null,
                tint = AzulCorporativo,
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = "Configuración",
                color = TextoPrincipal,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        MenuOpcionCard(
            texto = "Realizar una solicitud",
            icono = Icons.AutoMirrored.Outlined.Assignment,
            onClick = { mostrarAviso = true }
        )
        MenuOpcionCard(
            texto = "Personalización y opciones de accesibilidad",
            icono = Icons.Outlined.Accessibility,
            onClick = { mostrarAviso = true }
        )
        MenuOpcionCard(
            texto = "Cerrar sesión",
            icono = Icons.AutoMirrored.Outlined.Logout,
            onClick = { mostrarAviso = true }
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
private fun MenuOpcionCard(
    texto: String,
    icono: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icono,
                contentDescription = null,
                tint = AzulCorporativo,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = texto,
                color = TextoPrincipal,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "›",
                color = TextoSecundario,
                fontSize = 24.sp
            )
        }
    }
}
