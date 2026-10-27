package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartvolt.model.Destinos
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.TextoSobreAzul
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Temporizador de 3 segundos antes de navegar al Login
    LaunchedEffect(key1 = true) {
        delay(3000) // 3000 ms (3 segundos)
        navController.navigate(route = Destinos.Login.ruta) {
            // Elimina la pantalla de Splash/Inicio del historial para no volver a ella con el botón "Atrás"
            popUpTo(route = Destinos.Inicio.ruta) { inclusive = true }
        }
    }

    // Diseño del Splash basado en el mockup y la estructura de la clase
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = SmartVoltGradients.LoginBackground), // Color corporativo del proyecto
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            // Logo SMART (blanco) + VOLT (amarillo)
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = TextoSobreAzul)) { append("SMART") }
                    withStyle(SpanStyle(color = AmarilloPrincipal)) { append("VOLT") }
                },
                fontSize = 44.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(72.dp))
            Text(
                text = "Bienvenido a SmartVolt",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = TextoSobreAzul
            )
            Spacer(modifier = Modifier.height(72.dp))
            Text(
                text = "~Tu control de\nasistencia preferido~",
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = TextoSobreAzul.copy(alpha = 0.8f)
            )
            // El mockup no muestra indicador de carga. Si lo quieren, descomenten:
            Spacer(modifier = Modifier.height(32.dp))
            CircularProgressIndicator(color = TextoSobreAzul)
        }
    }
}