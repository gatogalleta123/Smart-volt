package com.example.smartvolt.model.domain

/**
 * Datos personales que se muestran en el perfil (solo lectura).
 * Los valores por defecto son placeholders; usar siempre datos ficticios en el MVP.
 */
data class DatosPerfil(
    val nombre: String = "Nombre usuario",
    val apellido: String = "Apellido usuario",
    val rut: String = "Rut",
    val telefono: String = "Numero telefono",
    val correo: String = "Correo electronico"
)