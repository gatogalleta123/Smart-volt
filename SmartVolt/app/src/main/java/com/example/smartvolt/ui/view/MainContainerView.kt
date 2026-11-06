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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smartvolt.model.navigation.Destinos
import com.example.smartvolt.model.navigation.destinosInferiores
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
                            if (rutaActual != destino.ruta) {
                                subNavController.navigate(destino.ruta) {
                                    popUpTo(subNavController.graph.findStartDestination().id) {
                                        saveState = false
                                    }
                                    launchSingleTop = true
                                    restoreState = false
                                }
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
            composable(Destinos.Inferior.InicioUsuario.ruta) {
                InicioUsuarioView(
                    onMarcarAsistencia = {
                        subNavController.navigate(Destinos.Inferior.Marcaje.ruta) {
                            launchSingleTop = true
                        }
                    },
                    onEscanearQr = {
                        subNavController.navigate(Destinos.EscanerQr.ruta) {
                            launchSingleTop = true
                        }
                    },
                    onPerfilClick = {
                        subNavController.navigate(Destinos.Inferior.Perfil.ruta) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(Destinos.Inferior.Calendario.ruta) {
                AsistenciaView(
                    onEscanearQr = {
                        subNavController.navigate(Destinos.EscanerQr.ruta) {
                            launchSingleTop = true
                        }
                    },
                    onPerfilClick = {
                        subNavController.navigate(Destinos.Inferior.Perfil.ruta) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(Destinos.Inferior.Marcaje.ruta) {
                MarcajeView(
                    onPerfilClick = {
                        subNavController.navigate(Destinos.Inferior.Perfil.ruta) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(Destinos.Inferior.Perfil.ruta) {
                PerfilTrabajadorView(
                    onEscanearQr = {
                        subNavController.navigate(Destinos.EscanerQr.ruta) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(Destinos.Inferior.Menu.ruta) { PantallaGenerica("Menú") }
            composable(Destinos.EscanerQr.ruta) {
                com.example.smartvolt.ui.components.marcaje.PantallaEscanerQr(
                    onVolver = { subNavController.popBackStack() }
                )
            }
        }
    }
}

@Composable
fun PantallaGenerica(texto: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = texto, fontSize = 25.sp)
    }
}