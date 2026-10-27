package com.example.smartvolt.model

sealed class Destinos(val ruta: String) {
    object Inicio : Destinos("inicio")
    object Login : Destinos("login")
    object Home : Destinos ("home")
}