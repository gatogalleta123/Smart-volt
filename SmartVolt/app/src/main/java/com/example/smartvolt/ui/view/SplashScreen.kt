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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartvolt.model.Destinos
import com.example.smartvolt.ui.theme.AzulCorporativo
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
            .background(color = AzulCorporativo), // Color corporativo del proyecto
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "SMARTVOLT",
                fontSize = 36.sp,
                color = TextoSobreAzul,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Bienvenido a smartvolt",
                fontSize = 18.sp,
                color = TextoSobreAzul
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Tu control de asistencia preferido",
                fontSize = 14.sp,
                color = TextoSobreAzul.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(32.dp))
            CircularProgressIndicator(
                color = TextoSobreAzul
            )
        }
    }
}
