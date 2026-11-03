package com.example.smartvolt.model

/**
 * Representa el estado actual de los permisos y sensores requeridos por la app
 */
data class EstadoPermisos(
    val bluetoothActivo: Boolean = true,
    val gpsActivo: Boolean = true,
    val camaraPermiso: Boolean = true
) {
    /**
     * Retorna verdadero únicamente si los 3 requisitos están concedidos/activos
     */
    val todosActivos: Boolean
        get() = bluetoothActivo && gpsActivo && camaraPermiso

    /**
     * Cuenta cuántos permisos de los 3 requeridos están listos
     */
    val totalActivos: Int
        get() = (if (bluetoothActivo) 1 else 0) +
                (if (gpsActivo) 1 else 0) +
                (if (camaraPermiso) 1 else 0)
}