package com.example.smartvolt.ui.components.perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.SuperficieSecundaria
import com.example.smartvolt.ui.theme.TextoSecundario

/**
 * Avatar circular con botón de edición (lápiz) en la esquina inferior derecha.
 * Si [imagen] es null se muestra un ícono de persona como placeholder.
 */
@Composable
fun AvatarPerfil(
    imagen: Painter? = null,
    onEditar: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(120.dp)) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(SuperficieSecundaria),
            contentAlignment = Alignment.Center
        ) {
            if (imagen != null) {
                Image(
                    painter = imagen,
                    contentDescription = "Foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(120.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Foto de perfil",
                    tint = TextoSecundario,
                    modifier = Modifier.size(72.dp)
                )
            }
        }

        // Botón lápiz
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(36.dp)
                .clip(CircleShape)
                .background(AzulCorporativo)
                .border(2.dp, Superficie, CircleShape)
                .clickable(onClick = onEditar),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Editar foto",
                tint = Superficie,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AvatarPerfilPreview() {
    SmartVoltTheme(dynamicColor = false) {
        AvatarPerfil(modifier = androidx.compose.ui.Modifier.size(140.dp))
    }
}