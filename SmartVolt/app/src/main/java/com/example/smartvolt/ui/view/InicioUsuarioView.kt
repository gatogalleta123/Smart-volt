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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.ui.components.avisos.AvisosCard
import com.example.smartvolt.ui.components.botones.BotonRegistrarAsistencia
import com.example.smartvolt.ui.components.asistencia.EstadoAsistencia
import com.example.smartvolt.ui.components.asistencia.EstadoAsistenciaCard
import com.example.smartvolt.ui.components.HeaderSmartVolt
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.viewmodel.AsistenciaViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun InicioUsuarioView(
    onMarcarAsistencia: () -> Unit = {},
    onEscanearQr: () -> Unit = {},
    viewModel: AsistenciaViewModel = viewModel(),
    onPerfilClick: () -> Unit = {}
) {
    val marcas by viewModel.marcasDelMes.collectAsState()
    val marcaActual = marcas.firstOrNull { it.fecha == fechaActual() }
    val estadoActual = when {
        marcaActual == null -> EstadoAsistencia.NO_REGISTRADO
        marcaActual.estado == EstadoMarca.PENDIENTE -> EstadoAsistencia.PENDIENTE_CONEXION
        else -> EstadoAsistencia.REGISTRADO
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Header y acción principal
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 24.dp)
        ) {
            HeaderSmartVolt(
                onPerfilClick = onPerfilClick,
                onQrClick = onEscanearQr
            )
            BotonRegistrarAsistencia(
                texto = "Marcar",
                onClick = onMarcarAsistencia,
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
            EstadoAsistenciaCard(estado = estadoActual)
        }
    }
}

private fun fechaActual(): String =
    SimpleDateFormat("d 'de' MMMM", Locale("es")).format(Date())

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioUsuarioViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        InicioUsuarioView()
    }
}