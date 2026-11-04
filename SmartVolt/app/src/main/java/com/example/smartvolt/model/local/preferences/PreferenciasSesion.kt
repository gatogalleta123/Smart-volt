package com.example.smartvolt.model.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "smartvolt_prefs")

class PreferenciasSesion(private val context: Context) {

    private companion object {
        val SESION_ACTIVA = booleanPreferencesKey("sesion_activa")
        val CORREO = stringPreferencesKey("correo")
    }

    val sesionActiva: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[SESION_ACTIVA] ?: false }

    val correo: Flow<String> = context.dataStore.data
        .map { prefs -> prefs[CORREO] ?: "" }

    suspend fun guardarSesion(correo: String) {
        context.dataStore.edit { prefs ->
            prefs[SESION_ACTIVA] = true
            prefs[CORREO] = correo
        }
    }

    suspend fun cerrarSesion() {
        context.dataStore.edit { it.clear() }
    }
}