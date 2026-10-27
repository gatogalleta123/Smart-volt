package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartvolt.model.Destinos
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun LoginView(navController: NavController) {
    var usuario by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    // Colores de los campos: fondo blanco como en el mockup
    val coloresCampo = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Superficie,
        unfocusedContainerColor = Superficie,
        focusedTextColor = TextoPrincipal,
        unfocusedTextColor = TextoPrincipal,
        focusedLabelColor = TextoSecundario,
        unfocusedLabelColor = TextoSecundario,
        focusedLeadingIconColor = TextoPrincipal,
        unfocusedLeadingIconColor = TextoPrincipal,
        focusedBorderColor = AmarilloPrincipal,
        unfocusedBorderColor = Superficie
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = SmartVoltGradients.LoginBackground) // degradado del mockup
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo SMART (blanco) + VOLT (amarillo)
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = TextoSobreAzul)) { append("SMART") }
                withStyle(SpanStyle(color = AmarilloPrincipal)) { append("VOLT") }
            },
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Portal Trabajador",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = TextoSobreAzul
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text(text = "Correo electrónico") },
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = coloresCampo,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text(text = "Contraseña") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = coloresCampo,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(route = Destinos.Home.ruta) {
                    popUpTo(route = Destinos.Login.ruta) { inclusive = true }
                }
            },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = AmarilloPrincipal,
                contentColor = TextoSobreAmarillo
            )
        ) {
            Text(text = "Iniciar Sesión", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(24.dp))

        TextButton(onClick = { /* pendiente: recuperar contraseña */ }) {
            Text(
                text = "¿Olvidaste tu contraseña?",
                color = AmarilloPrincipal,
                fontSize = 12.sp
            )
        }
    }
}