package com.example.smartvolt.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smartvolt.model.Destinos
import com.example.smartvolt.model.destinosInferiores
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun MainContainerView() {
    val subNavController = rememberNavController()
    val rutaActual = subNavController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            NavigationBar(containerColor = Superficie) {
                destinosInferiores.forEach { destino ->
                    NavigationBarItem(
                        selected = rutaActual == destino.ruta,
                        onClick = {
                            subNavController.navigate(destino.ruta) {
                                popUpTo(subNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = destino.etiqueta, fontSize = 10.sp) },
                        icon = { Icon(imageVector = destino.icono, contentDescription = destino.etiqueta) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = TextoPrincipal,
                            selectedTextColor = TextoPrincipal,
                            unselectedIconColor = TextoPrincipal,
                            unselectedTextColor = TextoPrincipal,
                            indicatorColor = FondoPrincipal
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = subNavController,
            startDestination = destinosInferiores.first().ruta,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Destinos.Inferior.InicioUsuario.ruta) { InicioUsuarioView() }
            composable(Destinos.Inferior.Calendario.ruta) { PantallaGenerica("Calendario") }
            composable(Destinos.Inferior.Marcaje.ruta) { PantallaGenerica("Marcaje") }
            composable(Destinos.Inferior.Perfil.ruta) { PantallaGenerica("Perfil") }
            composable(Destinos.Inferior.Menu.ruta) { PantallaGenerica("Menú") }
        }
    }
}

@Composable
fun PantallaGenerica(texto: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = texto, fontSize = 25.sp)
    }
}