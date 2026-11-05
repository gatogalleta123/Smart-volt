package com.example.smartvolt.viewmodel

import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.Totem
import kotlinx.coroutines.Job
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartvolt.model.local.database.SmartVoltDatabase
import com.example.smartvolt.model.repository.MarcaRepository
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MarcajeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MarcaRepository(
        SmartVoltDatabase.getInstance(application).marcaDao()
    )

    val marcas: StateFlow<List<RegistroMarca>> = repository.observarMarcas()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _sincronizando = MutableStateFlow(false)
    val sincronizando: StateFlow<Boolean> = _sincronizando.asStateFlow()

    // ---------- Flujo de validación de entrada ----------
    private val _paso = MutableStateFlow(PasoValidacion.INACTIVO)
    val paso: StateFlow<PasoValidacion> = _paso.asStateFlow()

    private val _totemSeleccionado = MutableStateFlow<Totem?>(null)
    val totemSeleccionado: StateFlow<Totem?> = _totemSeleccionado.asStateFlow()

    // Datos ficticios (MVP). Luego vendrán del escaneo BLE real.
    val totemsDisponibles: List<Totem> = listOf(
        Totem("1", "Totem Obra 2"),
        Totem("2", "Totem Obra 3"),
        Totem("3", "Totem Obra 6")
    )

    private var jobBusqueda: Job? = null

    fun iniciarValidacion() {
        jobBusqueda?.cancel()
        jobBusqueda = viewModelScope.launch {
            _paso.value = PasoValidacion.BUSCANDO_TOTEMS
            delay(2000) // simula la búsqueda de tótems
            _paso.value = PasoValidacion.SELECCION_TOTEM
        }
    }

    fun seleccionarTotem(totem: Totem) {
        _totemSeleccionado.value = totem
        _paso.value = PasoValidacion.SOLICITANDO_CAMARA
    }

    fun camaraResuelta(concedido: Boolean) {
        _paso.value = if (concedido) PasoValidacion.CONFIRMAR_FOTO else PasoValidacion.INACTIVO
    }

    fun cancelarValidacion() {
        jobBusqueda?.cancel()
        _paso.value = PasoValidacion.INACTIVO
    }

    fun registrarMarca(tipo: TipoMarca, hora: String, fecha: String, faena: String) {
        viewModelScope.launch {
            repository.registrarMarcaLocal(tipo, hora, fecha, faena)
        }
    }

    fun sincronizar() {
        viewModelScope.launch {
            _sincronizando.value = true
            try {
                repository.sincronizarPendientes { marca -> enviarAlServidor(marca) }
            } finally {
                _sincronizando.value = false
            }
        }
    }

    // SIMULACIÓN PARA PRUEBAS: espera 1,5 s y responde OK.
    // TODO: reemplazar por la llamada real a tu API (Retrofit, etc.).
    private suspend fun enviarAlServidor(marca: RegistroMarca): Boolean {
        delay(1500)
        return true
    }
}