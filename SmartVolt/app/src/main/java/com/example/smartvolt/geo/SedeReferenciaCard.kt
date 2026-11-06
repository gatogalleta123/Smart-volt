package com.example.smartvolt.geo

import com.example.smartvolt.ui.theme.Superficie

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SedeReferenciaCard(modifier: Modifier = Modifier) {
    val contexto = LocalContext.current

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = SedeFija.DIRECCION)
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                val consulta = Uri.encode(SedeFija.DIRECCION)
                val uri = Uri.parse("geo:0,0?q=$consulta")
                contexto.startActivity(Intent(Intent.ACTION_VIEW, uri))
            }) {
                Text(text = "Ver en mapa")
            }
        }
    }
}

//En MarcajeContent, se reemplaza el bloque del mapa por:
//TituloSeccion(texto = "Faena de referencia")
//SedeReferenciaCard()