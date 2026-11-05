package com.example.smartvolt.model.local.temporal

import android.content.Context
import java.io.File

/**
 * Almacén TEMPORAL de la foto de validación.
 * - Los archivos viven en cacheDir/fotos_temporales.
 * - Se borran al iniciar la app (ver MainActivity), por lo que no sobreviven al cierre.
 * - Solo guarda UNA foto: la última tomada.
 */
object FotoTemporalStorage {

    private const val CARPETA = "fotos_temporales"

    @Volatile
    private var fotoActual: File? = null

    /** Crea un archivo vacío (aún sin guardar como foto actual) dentro de la carpeta temporal. */
    fun crearArchivo(context: Context): File {
        val carpeta = File(context.cacheDir, CARPETA).apply { mkdirs() }
        return File(carpeta, "foto_${System.currentTimeMillis()}.jpg")
    }

    /** Define la foto vigente. Si había otra distinta, la elimina. */
    fun establecerFoto(archivo: File) {
        val anterior = fotoActual
        if (anterior != null && anterior.absolutePath != archivo.absolutePath) {
            anterior.delete()
        }
        fotoActual = archivo
    }

    fun obtenerFoto(): File? = fotoActual?.takeIf { it.exists() }

    /** Elimina una foto concreta (por ejemplo, al reintentar o cancelar). */
    fun eliminar(archivo: File) {
        archivo.delete()
        if (fotoActual?.absolutePath == archivo.absolutePath) fotoActual = null
    }

    /** Borra todo el contenido temporal. Se llama al arrancar la app. */
    fun limpiarTodo(context: Context) {
        File(context.cacheDir, CARPETA).deleteRecursively()
        fotoActual = null
    }
}