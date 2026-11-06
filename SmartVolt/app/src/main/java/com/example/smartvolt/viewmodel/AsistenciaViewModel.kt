package com.example.smartvolt.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.model.local.database.SmartVoltDatabase
import com.example.smartvolt.model.repository.MarcaRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.stateIn

class AsistenciaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MarcaRepository(
        SmartVoltDatabase.getInstance(application).marcaDao()
    )

    /** Marcas del mes guardadas en Room (las mismas que crea la pantalla Marcaje). */
    val marcasDelMes: StateFlow<List<RegistroMarca>> = repository.observarMarcasDelMes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    /** Todas las marcas, en orden de más reciente a más antigua. */
    val marcasGuardadas: StateFlow<List<RegistroMarca>> = repository.observarMarcas()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    /** Días distintos del mes con marca de entrada = asistencias. */
    val asistenciasDelMes: StateFlow<Int> = marcasDelMes
        .map { lista ->
            lista.filter { it.tipo == TipoMarca.ENTRADA }
                .map { it.fecha }
                .distinct()
                .size
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    private val _sincronizando = MutableStateFlow(false)
    val sincronizando: StateFlow<Boolean> = _sincronizando.asStateFlow()

    fun sincronizar() {
        viewModelScope.launch {
            _sincronizando.value = true
            try {
                repository.sincronizarPendientes {
                    delay(1500)
                    true
                }
            } finally {
                _sincronizando.value = false
            }
        }
    }
}