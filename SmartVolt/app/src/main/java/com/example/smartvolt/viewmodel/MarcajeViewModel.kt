package com.example.smartvolt.viewmodel


import com.example.smartvolt.geo.UbicacionProvider
import com.example.smartvolt.model.domain.LecturaUbicacion
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.Totem
import kotlinx.coroutines.Job
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.model.domain.Totem
import com.example.smartvolt.model.local.database.SmartVoltDatabase
import com.example.smartvolt.model.local.temporal.FotoTemporalStorage
import com.example.smartvolt.model.repository.MarcaRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.File

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

    // Foto temporal tomada en este flujo
    private val _foto = MutableStateFlow<File?>(null)
    val foto: StateFlow<File?> = _foto.asStateFlow()

    // Hora en que se confirmó la marca (se muestra en "Buen turno" y se guarda en la marca)
    private val _horaMarca = MutableStateFlow("")
    val horaMarca: StateFlow<String> = _horaMarca.asStateFlow()

    // Datos ficticios (MVP). Luego vendrán del escaneo BLE real.
    val totemsDisponibles: List<Totem> = listOf(
        Totem("1", "Totem Obra 2"),
        Totem("2", "Totem Obra 3"),
        Totem("3", "Totem Obra 6")
    )

    private val ubicacionProvider = UbicacionProvider(application)

    private val _ubicacion = MutableStateFlow<LecturaUbicacion?>(null)
    val ubicacion: StateFlow<LecturaUbicacion?> = _ubicacion.asStateFlow()

    fun actualizarUbicacion() {
        viewModelScope.launch {
            _ubicacion.value = ubicacionProvider.obtenerUbicacion()
        }
    }

    private var jobBusqueda: Job? = null

    fun iniciarValidacion() {
        jobBusqueda?.cancel()
        _foto.value = null
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

    /** "Confirmar" en "A continuación tomaremos una foto": abre la cámara. */
    fun confirmarAvisoFoto() {
        _paso.value = PasoValidacion.CAMARA
    }

    /** La cámara guardó la foto: se deja como foto temporal vigente y se muestra para revisar. */
    fun fotoTomada(archivo: File) {
        FotoTemporalStorage.establecerFoto(archivo)
        _foto.value = archivo
        _paso.value = PasoValidacion.REVISAR_FOTO
    }

    /** "Reintentar": descarta la foto y vuelve a la cámara. */
    fun reintentarFoto() {
        _foto.value?.let { FotoTemporalStorage.eliminar(it) }
        _foto.value = null
        _paso.value = PasoValidacion.CAMARA
    }

    /** "Continuar" con la foto: muestra "Buen turno!". */
    fun continuarConFoto(hora: String) {
        _horaMarca.value = hora
        _paso.value = PasoValidacion.BUEN_TURNO
    }

    /** "Continuar" en "Buen turno!": guarda la marca en Room (PENDIENTE) y cierra el flujo. */
    fun finalizarMarca(tipo: TipoMarca, fecha: String, faena: String) {
        val hora = _horaMarca.value
        viewModelScope.launch {
            repository.registrarMarcaLocal(tipo, hora, fecha, faena)
        }
        // La foto NO se borra: queda temporal para la futura validación con admin
        _paso.value = PasoValidacion.INACTIVO
    }

    /** Cancelar a mitad del flujo: se descarta la foto de este intento. */
    fun cancelarValidacion() {
        jobBusqueda?.cancel()
        _foto.value?.let { FotoTemporalStorage.eliminar(it) }
        _foto.value = null
        _paso.value = PasoValidacion.INACTIVO
    }

    // ---------- Marcas ----------
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