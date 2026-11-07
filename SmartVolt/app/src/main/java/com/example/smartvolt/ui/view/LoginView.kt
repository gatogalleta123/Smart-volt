package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Info
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.smartvolt.R
import com.example.smartvolt.model.navigation.Destinos
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.FondoError
import com.example.smartvolt.ui.theme.FondoInformacion
import com.example.smartvolt.ui.theme.Informacion
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.SuperficieSecundaria
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

// ---------- Datos de acceso (MVP con datos ficticios) ----------
private const val CORREO_VALIDO = "trabajador@smartvolt.cl"
private const val PASS_VALIDA = "Hola#1234"
private const val DOMINIO_PERMITIDO = "smartvolt.cl"
private val REGEX_CORREO = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$")

/** Resultado de validar el formulario: mensajes de error y qué campos marcar. */
data class ResultadoLogin(
    val mensajes: List<String> = emptyList(),
    val correoInvalido: Boolean = false,
    val passInvalida: Boolean = false
) {
    val esValido: Boolean get() = mensajes.isEmpty()
}

/** Valida formato, dominio, reglas de contraseña y credenciales exactas. */
fun validarLogin(correo: String, pass: String): ResultadoLogin {
    val mensajes = mutableListOf<String>()
    var correoMal = false
    var passMal = false
    val correoLimpio = correo.trim()

    // 1. Formato de correo (debe tener @ y un punto)
    if (!REGEX_CORREO.matches(correoLimpio)) {
        mensajes += "El correo no tiene un formato válido (debe incluir @ y un punto)."
        correoMal = true
    } else if (correoLimpio.substringAfter("@").lowercase() != DOMINIO_PERMITIDO) {
        // 2. Dominio corporativo
        mensajes += "El correo debe pertenecer al dominio @$DOMINIO_PERMITIDO."
        correoMal = true
    }

    // 3. Reglas de contraseña
    if (pass.length <= 8) {
        mensajes += "La contraseña debe tener más de 8 caracteres."
        passMal = true
    }
    if (pass.none { it.isUpperCase() }) {
        mensajes += "La contraseña debe incluir al menos una letra mayúscula."
        passMal = true
    }
    if (pass.none { !it.isLetterOrDigit() }) {
        mensajes += "La contraseña debe incluir al menos un símbolo (por ejemplo #, @ o !)."
        passMal = true
    }

    // 4. Credenciales exactas (solo si lo anterior está correcto)
    if (mensajes.isEmpty() &&
        (correoLimpio.lowercase() != CORREO_VALIDO || pass != PASS_VALIDA)
    ) {
        mensajes += "Correo o contraseña incorrectos."
        correoMal = true
        passMal = true
    }

    return ResultadoLogin(mensajes, correoMal, passMal)
}

@Composable
fun LoginView(navController: NavController) {
    var usuario by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var correoErroneo by remember { mutableStateOf(false) }
    var passErronea by remember { mutableStateOf(false) }
    var mensajesError by remember { mutableStateOf<List<String>>(emptyList()) }
    var mostrarAyudaContrasena by remember { mutableStateOf(false) }

    // Colores de los campos. El borde sin foco usa Borde (gris azulado) para que
    // se distinga del fondo blanco y la etiqueta flotante no se pierda al enfocar.
    val coloresCampo = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Superficie,
        unfocusedContainerColor = Superficie,
        disabledContainerColor = Superficie,
        errorContainerColor = Superficie,
        focusedTextColor = TextoPrincipal,
        unfocusedTextColor = TextoPrincipal,
        errorTextColor = TextoPrincipal,
        focusedLabelColor = AzulCorporativo,
        unfocusedLabelColor = TextoSecundario,
        errorLabelColor = Error,
        focusedLeadingIconColor = AzulCorporativo,
        unfocusedLeadingIconColor = TextoSecundario,
        errorLeadingIconColor = Error,
        cursorColor = AzulCorporativo,
        errorCursorColor = Error,
        focusedBorderColor = AmarilloPrincipal,
        unfocusedBorderColor = Borde,
        errorBorderColor = Error
    )

    // Estilo del texto escrito: color explícito para que nunca herede un gris
    val estiloTexto = TextStyle(color = TextoPrincipal, fontSize = 16.sp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = SmartVoltGradients.LoginBackground)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.smartvoltlogo5),
            contentDescription = "Logo de SmartVolt",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(280.dp)
                .height(76.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Portal Trabajador",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = TextoSobreAzul
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Correo electrónico",
            color = TextoSobreAzul,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = usuario,
            onValueChange = {
                usuario = it
                correoErroneo = false
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            singleLine = true,
            isError = correoErroneo,
            textStyle = estiloTexto,
            shape = RoundedCornerShape(12.dp),
            colors = coloresCampo,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Contraseña",
            color = TextoSobreAzul,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = {
                pass = it
                passErronea = false
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            singleLine = true,
            isError = passErronea,
            textStyle = estiloTexto,
            shape = RoundedCornerShape(12.dp),
            colors = coloresCampo,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val resultado = validarLogin(usuario, pass)
                correoErroneo = resultado.correoInvalido
                passErronea = resultado.passInvalida
                if (resultado.esValido) {
                    navController.navigate(route = Destinos.Home.ruta) {
                        popUpTo(route = Destinos.Login.ruta) { inclusive = true }
                    }
                } else {
                    mensajesError = resultado.mensajes
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

        TextButton(onClick = { mostrarAyudaContrasena = true }) {
            Text(
                text = "¿Olvidaste tu contraseña?",
                color = AmarilloPrincipal,
                fontSize = 12.sp
            )
        }
    }

    if (mensajesError.isNotEmpty()) {
        AlertaLogin(
            titulo = "No pudimos iniciar sesión",
            mensajes = mensajesError,
            icono = Icons.Outlined.ErrorOutline,
            colorIcono = Error,
            fondoIcono = FondoError,
            textoBoton = "Entendido",
            onCerrar = { mensajesError = emptyList() }
        )
    }

    if (mostrarAyudaContrasena) {
        AlertaLogin(
            titulo = "Cambio de contraseña",
            mensajes = listOf(
                "Para cambiar tu contraseña debes contactar a un administrador."
            ),
            icono = Icons.Outlined.Info,
            colorIcono = Informacion,
            fondoIcono = FondoInformacion,
            textoBoton = "Entendido",
            onCerrar = { mostrarAyudaContrasena = false }
        )
    }
}

/**
 * Alerta reutilizable con el estilo del mockup: tarjeta blanca, ícono sobre
 * círculo de color suave, panel de mensajes y botón amarillo tipo píldora.
 */
@Composable
fun AlertaLogin(
    titulo: String,
    mensajes: List<String>,
    icono: ImageVector,
    colorIcono: Color,
    fondoIcono: Color,
    textoBoton: String,
    onCerrar: () -> Unit
) {
    Dialog(
        onDismissRequest = onCerrar,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Superficie)
                .padding(horizontal = 24.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(fondoIcono),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icono,
                    contentDescription = titulo,
                    tint = colorIcono,
                    modifier = Modifier.size(34.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(SuperficieSecundaria)
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                mensajes.forEach { mensaje ->
                    Row(verticalAlignment = Alignment.Top) {
                        Box(
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(colorIcono)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = mensaje,
                            fontSize = 13.sp,
                            lineHeight = 18.sp,
                            color = TextoPrincipal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onCerrar,
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AmarilloPrincipal,
                    contentColor = TextoSobreAmarillo
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = textoBoton, fontWeight = FontWeight.Bold)
            }
        }
    }
}