package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartvolt.ui.components.avisos.AvisosCard
import com.example.smartvolt.ui.components.botones.BotonRegistrarAsistencia
import com.example.smartvolt.ui.components.asistencia.EstadoAsistencia
import com.example.smartvolt.ui.components.asistencia.EstadoAsistenciaCard
import com.example.smartvolt.ui.components.encabezados.Header
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme

@Composable
fun InicioUsuarioView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Zona azul: Header + botón Asistencia
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 24.dp)
        ) {
            Header()
            BotonRegistrarAsistencia(
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            AvisosCard()
            TituloSeccion(texto = "Estado de asistencia")
            EstadoAsistenciaCard(estado = EstadoAsistencia.NO_REGISTRADO)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioUsuarioViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        InicioUsuarioView()
    }
}