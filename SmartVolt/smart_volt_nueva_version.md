# Consolidación de código Kotlin

- **Proyecto:** `SmartVolt`
- **Total de archivos:** 64

## Índice

- `app/src/main/java/com/example/smartvolt/MainActivity.kt`
- `app/src/main/java/com/example/smartvolt/geo/Geocerca.kt`
- `app/src/main/java/com/example/smartvolt/geo/MapaOpen.kt`
- `app/src/main/java/com/example/smartvolt/geo/UbicacionProvider.kt`
- `app/src/main/java/com/example/smartvolt/geo/ValidadorUbicacion.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/AsistenciaUsuario.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/DatosPerfil.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/DetalleHorasExtra.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/EstadoDiaAsistencia.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/EstadoPermisos.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/EstadoVerificacion.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/LecturaUbicacion.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/RegistroMarca.kt`
- `app/src/main/java/com/example/smartvolt/model/domain/Totem.kt`
- `app/src/main/java/com/example/smartvolt/model/local/dao/MarcaDAO.kt`
- `app/src/main/java/com/example/smartvolt/model/local/database/SmartVoltDatabase.kt`
- `app/src/main/java/com/example/smartvolt/model/local/entity/MarcaEntity.kt`
- `app/src/main/java/com/example/smartvolt/model/local/preferences/PreferenciasSesion.kt`
- `app/src/main/java/com/example/smartvolt/model/local/temporal/FotoTemporalStorage.kt`
- `app/src/main/java/com/example/smartvolt/model/navigation/Destinos.kt`
- `app/src/main/java/com/example/smartvolt/model/repository/MarcaRepository.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/BadgeEstado.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/DetalleAsistenciasSheet.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/EstadoAsistenciaCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ItemMarcaAsistencia.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/MarcaAsistenciaCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ResumenAsistenciaAzulCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ResumenAsistenciaMensual.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ResumenAsistenciasMesCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/asistencia/TarjetaMarcaje.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/avisos/AvisosCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/botones/BotonAccionGradiente.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/botones/BotonRegistrarAsistencia.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/calendario/CalendarioAsistenciaDialog.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/conexion/EstadoConexionCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/conexion/FaenaActualCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/encabezados/Header.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/encabezados/TituloSeccion.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/horasextra/HorasExtraMesCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/horasextra/ItemHorasExtraDesplegable.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/horasextra/JornadaHorasExtraItem.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/horasextra/ResumenHorasExtrasCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/marcaje/PantallaCamaraFrontal.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/marcaje/ValidacionMarcajeDialog.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/perfil/AvatarPerfil.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/perfil/CampoDatoPerfil.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/permisos/EstadoPermisosCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/permisos/PermisosMarcajeCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/ubicacion/AlertaAnomaliaUbicacion.kt`
- `app/src/main/java/com/example/smartvolt/ui/components/ubicacion/MapaUbicacionCard.kt`
- `app/src/main/java/com/example/smartvolt/ui/theme/Color.kt`
- `app/src/main/java/com/example/smartvolt/ui/theme/SmartVoltGradients.kt`
- `app/src/main/java/com/example/smartvolt/ui/theme/Theme.kt`
- `app/src/main/java/com/example/smartvolt/ui/theme/Type.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/AsistenciaView.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/InicioSupervisorView.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/InicioUsuarioView.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/LoginView.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/MainContainerView.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/MarcajeView.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/PerfilView.kt`
- `app/src/main/java/com/example/smartvolt/ui/view/SplashScreen.kt`
- `app/src/main/java/com/example/smartvolt/viewmodel/AsistenciaViewModel.kt`
- `app/src/main/java/com/example/smartvolt/viewmodel/MarcajeViewModel.kt`

---

## `app/src/main/java/com/example/smartvolt/MainActivity.kt`

```kotlin
package com.example.smartvolt

import com.example.smartvolt.model.local.temporal.FotoTemporalStorage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartvolt.model.navigation.Destinos
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.view.LoginView
import com.example.smartvolt.ui.view.MainContainerView
import com.example.smartvolt.ui.view.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        // La foto temporal no sobrevive al cierre de la app: se limpia en cada arranque nuevo
        if (savedInstanceState == null) {
            FotoTemporalStorage.limpiarTodo(applicationContext)
        }
        enableEdgeToEdge()
        setContent {
            SmartVoltTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Destinos.Inicio.ruta
                    ) {
                        composable(route = Destinos.Inicio.ruta) {
                            SplashScreen(navController = navController)
                        }
                        composable(route = Destinos.Login.ruta) {
                            LoginView(navController)
                        }
                        composable (route = Destinos.Home.ruta) {
                            MainContainerView()
                        }
                    }
                }
            }
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/geo/Geocerca.kt`

```kotlin
package com.example.smartvolt.geo

import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/** Perímetro circular de una faena (datos sintéticos en el MVP). */
data class Perimetro(
    val nombre: String,
    val latCentro: Double,
    val lonCentro: Double,
    val radioMetros: Double
)

object Geocerca {

    private const val RADIO_TIERRA_METROS = 6_371_000.0

    /** Distancia en metros entre dos coordenadas (fórmula de Haversine). */
    fun distanciaMetros(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat / 2).pow(2) +
                cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * sin(dLon / 2).pow(2)
        return 2 * RADIO_TIERRA_METROS * asin(sqrt(a))
    }

    fun estaDentro(latitud: Double, longitud: Double, perimetro: Perimetro): Boolean =
        distanciaMetros(latitud, longitud, perimetro.latCentro, perimetro.lonCentro) <= perimetro.radioMetros
}
```

---

## `app/src/main/java/com/example/smartvolt/geo/MapaOpen.kt`

```kotlin
package com.example.smartvolt.geo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapaOpen(){
    val locationPermission = rememberPermissionState(
        permission = android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    Box(modifier = Modifier.fillMaxSize().padding(15.dp)){
        Text(text = "Para mostrar el mapa necesitamos de su permiso")
        Button(onClick = {locationPermission.launchPermissionRequest()}) {
            Text(text = "Pínchame")
        }
    }
}

@Composable
fun osm_mapa(){
    val contexto = LocalContext.current

    val mapaView = remember { MapView(contexto) }
    val myLocation = remember {
        val provider = GpsMyLocationProvider(contexto)
        MyLocationNewOverlay(provider, mapaView).apply{
            enableFollowLocation()
            isDrawAccuracyEnabled = true
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/geo/UbicacionProvider.kt`

```kotlin
package com.example.smartvolt.geo

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import androidx.core.content.ContextCompat
import com.example.smartvolt.model.domain.EstadoUbicacion
import com.example.smartvolt.model.domain.LecturaUbicacion
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Obtiene una única lectura de ubicación en el momento de marcar.
 * No hace seguimiento en segundo plano.
 */
class UbicacionProvider(private val context: Context) {

    private val cliente = LocationServices.getFusedLocationProviderClient(context)

    fun tienePermiso(): Boolean =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    suspend fun obtenerUbicacion(): LecturaUbicacion {
        if (!tienePermiso()) return LecturaUbicacion(EstadoUbicacion.SIN_PERMISO)

        // Si el GPS está apagado o no hay lectura, llega null
        val location = obtenerLocalizacionActual()
            ?: return LecturaUbicacion(EstadoUbicacion.SIN_SENAL)

        val simulada = location.esSimulada()

        return LecturaUbicacion(
            estado = if (simulada) EstadoUbicacion.SIMULADA else EstadoUbicacion.VERIFICADA,
            latitud = location.latitude,
            longitud = location.longitude,
            precisionMetros = if (location.hasAccuracy()) location.accuracy else null,
            esMock = simulada
        )
    }

    @SuppressLint("MissingPermission")
    private suspend fun obtenerLocalizacionActual(): Location? {
        val actual = suspendCancellableCoroutine<Location?> { continuacion ->
            val cancelacion = CancellationTokenSource()
            cliente.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, cancelacion.token)
                .addOnSuccessListener { location ->
                    if (continuacion.isActive) continuacion.resume(location)
                }
                .addOnFailureListener {
                    if (continuacion.isActive) continuacion.resume(null)
                }
            continuacion.invokeOnCancellation { cancelacion.cancel() }
        }

        if (actual != null) return actual

        return suspendCancellableCoroutine { continuacion ->
            cliente.lastLocation
                .addOnSuccessListener { location ->
                    if (continuacion.isActive) continuacion.resume(location)
                }
                .addOnFailureListener {
                    if (continuacion.isActive) continuacion.resume(null)
                }
        }
    }

    // Location.isMock existe desde API 31; antes se usaba isFromMockProvider
    @Suppress("DEPRECATION")
    private fun Location.esSimulada(): Boolean =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) isMock else isFromMockProvider
}
```

---

## `app/src/main/java/com/example/smartvolt/geo/ValidadorUbicacion.kt`

```kotlin
package com.example.smartvolt.geo

import com.example.smartvolt.model.domain.EstadoUbicacion
import com.example.smartvolt.model.domain.LecturaUbicacion

enum class ResultadoUbicacion {
    VALIDA,
    FUERA_DE_PERIMETRO,
    PRECISION_INSUFICIENTE,
    SIMULADA,
    SIN_LECTURA
}

object ValidadorUbicacion {

    /** Precisión mínima aceptable, en metros. Es un parámetro a calibrar en terreno. */
    const val PRECISION_MAXIMA_METROS = 30f

    fun evaluar(lectura: LecturaUbicacion, perimetro: Perimetro): ResultadoUbicacion {
        val lat = lectura.latitud
        val lon = lectura.longitud
        return when {
            lectura.estado == EstadoUbicacion.SIMULADA -> ResultadoUbicacion.SIMULADA
            lat == null || lon == null -> ResultadoUbicacion.SIN_LECTURA
            (lectura.precisionMetros ?: Float.MAX_VALUE) > PRECISION_MAXIMA_METROS ->
                ResultadoUbicacion.PRECISION_INSUFICIENTE
            !Geocerca.estaDentro(lat, lon, perimetro) -> ResultadoUbicacion.FUERA_DE_PERIMETRO
            else -> ResultadoUbicacion.VALIDA
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/AsistenciaUsuario.kt`

```kotlin
package com.example.smartvolt.model.domain

/** Estado visual de una marca dentro de la pantalla Asistencia. */
enum class EstadoMarcaDetalle(val etiqueta: String) {
    VALIDADA("Validada"),
    PENDIENTE("Pendiente"),
    SIN_REGISTRAR("Sin registrar")
}

/** Estado de aprobación de una jornada con horas extra. */
enum class EstadoJornadaExtra(val etiqueta: String) {
    APROBADAS("Aprobadas"),
    PENDIENTE("Pendiente"),
    RECHAZADAS("Rechazadas")
}

/** Marca mostrada en las listas de la pantalla Asistencia (usar datos ficticios en el MVP). */
data class MarcaDetalle(
    val id: String = "",
    val titulo: String,
    val fecha: String,
    val faena: String,
    val hora: String,
    val estado: EstadoMarcaDetalle
)

/** Jornada con horas extra y las marcas asociadas (entrada / salida). */
data class JornadaHorasExtra(
    val id: String,
    val fecha: String,
    val horario: String,
    val estado: EstadoJornadaExtra,
    val marcas: List<MarcaDetalle>
)
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/DatosPerfil.kt`

```kotlin
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
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/DetalleHorasExtra.kt`

```kotlin
package com.example.smartvolt.model.domain

data class DetalleHorasExtra(
    val id: String = "",
    val fecha: String = "23 de octubre",
    val horaEntrada: String = "17:30 p.m.",
    val horaSalida: String = "19:30 p.m.",
    val totalHoras: String = "2h 00m",
    val faena: String = "Subestación Norte",
    val estado: EstadoMarca = EstadoMarca.VALIDADA,
    val marcaEntrada: RegistroMarca = RegistroMarca(
        tipo = TipoMarca.ENTRADA_HORAS_EXTRA,
        hora = horaEntrada,
        fecha = fecha,
        ubicacionFaena = faena,
        estado = estado
    ),
    val marcaSalida: RegistroMarca = RegistroMarca(
        tipo = TipoMarca.SALIDA_HORAS_EXTRA,
        hora = horaSalida,
        fecha = fecha,
        ubicacionFaena = faena,
        estado = estado
    )
)
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/EstadoDiaAsistencia.kt`

```kotlin
package com.example.smartvolt.model.domain

/**
 * Estado de un día en el calendario de asistencia.
 * Los colores de cada estado se definen en un solo lugar:
 * CalendarioAsistenciaDialog.kt -> colorFondoDia().
 */
enum class EstadoDiaAsistencia {
    ASISTIDO,    // azul
    AUSENTE,     // rojo
    NO_LABORAL,  // gris
    HOY          // celeste
}
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/EstadoPermisos.kt`

```kotlin
package com.example.smartvolt.model.domain

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
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/EstadoVerificacion.kt`

```kotlin
package com.example.smartvolt.model.domain

/** Estado de verificación de un permiso o sensor en la pantalla de marcaje */
enum class EstadoVerificacion {
    CORRECTO,     // ✓ verde
    ADVERTENCIA,  // ! naranja
    ERROR         // ✗ rojo
}
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/LecturaUbicacion.kt`

```kotlin
package com.example.smartvolt.model.domain

enum class EstadoUbicacion {
    VERIFICADA,
    SIMULADA,
    SIN_SENAL,
    SIN_PERMISO
}

data class LecturaUbicacion(
    val estado: EstadoUbicacion,
    val latitud: Double? = null,
    val longitud: Double? = null,
    val precisionMetros: Float? = null,
    val esMock: Boolean = false
)

// Traduce la ubicación al estado visual que ya usa PermisosMarcajeCard
fun EstadoUbicacion.toEstadoVerificacion(): EstadoVerificacion = when (this) {
    EstadoUbicacion.VERIFICADA -> EstadoVerificacion.CORRECTO
    EstadoUbicacion.SIN_SENAL -> EstadoVerificacion.ADVERTENCIA
    EstadoUbicacion.SIMULADA,
    EstadoUbicacion.SIN_PERMISO -> EstadoVerificacion.ERROR
}
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/RegistroMarca.kt`

```kotlin
package com.example.smartvolt.model.domain

/**
 * Los 6 tipos de marca según el flujo de la aplicación :
 * - ENTRADA: Inicio de la jornada laboral.
 * - SALIDA: Término de la jornada laboral.
 * - ENTRADA_COLACION: Inicio del periodo de colación.
 * - SALIDA_COLACION: Término del periodo de colación y regreso al trabajo.
 * - ENTRADA_HORAS_EXTRA: Inicio de horas extraordinarias.
 * - SALIDA_HORAS_EXTRA: Término de horas extraordinarias.
 */
enum class TipoMarca(val tituloDisplay: String) {
    ENTRADA("Marca de entrada"),
    SALIDA("Marca de salida"),
    ENTRADA_COLACION("Inicio de colación"),
    SALIDA_COLACION("Término de colación"),
    ENTRADA_HORAS_EXTRA("Inicio horas extra"),
    SALIDA_HORAS_EXTRA("Término horas extra")
}

/**
 * Estados de validación de la marca de asistencia
 */
enum class EstadoMarca {
    VALIDADA,
    PENDIENTE
}

data class RegistroMarca(
    val id: String = "",
    val tipo: TipoMarca = TipoMarca.ENTRADA,
    val hora: String = "08:30 a.m.",
    val fecha: String = "23 de octubre",
    val ubicacionFaena: String = "Faena Obra Norte",
    val estado: EstadoMarca = EstadoMarca.VALIDADA
)
```

---

## `app/src/main/java/com/example/smartvolt/model/domain/Totem.kt`

```kotlin
package com.example.smartvolt.model.domain

/** Baliza BLE de faena (datos ficticios en el MVP). */
data class Totem(
    val id: String,
    val nombre: String
)

/** Pasos del flujo de validación al marcar entrada. */
enum class PasoValidacion {
    INACTIVO,
    BUSCANDO_TOTEMS,
    SELECCION_TOTEM,
    SOLICITANDO_CAMARA,   // permiso del sistema
    CONFIRMAR_FOTO,       // "A continuación tomaremos una foto"
    CAMARA,               // cámara frontal
    REVISAR_FOTO,         // "Confirma tu foto para continuar" (Continuar / Reintentar)
    BUEN_TURNO            // "Buen turno!" y guardado de la marca
}
```

---

## `app/src/main/java/com/example/smartvolt/model/local/dao/MarcaDAO.kt`

```kotlin
package com.example.smartvolt.model.local.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartvolt.model.local.entity.MarcaEntity
import com.example.smartvolt.model.domain.EstadoMarca
import kotlinx.coroutines.flow.Flow

@Dao
interface MarcaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(marca: MarcaEntity)

    @Query("SELECT * FROM marcas ORDER BY creadoEn DESC")
    fun observarTodas(): Flow<List<MarcaEntity>>

    @Query("SELECT * FROM marcas WHERE sincronizada = 0 ORDER BY creadoEn ASC")
    suspend fun pendientesDeSincronizar(): List<MarcaEntity>

    @Query("UPDATE marcas SET sincronizada = 1, estado = :estado WHERE id = :id")
    suspend fun marcarComoSincronizada(id: String, estado: EstadoMarca)

    @Query("SELECT * FROM marcas WHERE creadoEn >= :desde AND creadoEn < :hasta ORDER BY creadoEn DESC")
    fun observarEntre(desde: Long, hasta: Long): Flow<List<MarcaEntity>>
}
```

---

## `app/src/main/java/com/example/smartvolt/model/local/database/SmartVoltDatabase.kt`

```kotlin
package com.example.smartvolt.model.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smartvolt.model.local.dao.MarcaDao
import com.example.smartvolt.model.local.entity.MarcaEntity

@Database(entities = [MarcaEntity::class], version = 1, exportSchema = false)
abstract class SmartVoltDatabase : RoomDatabase() {

    abstract fun marcaDao(): MarcaDao

    companion object {
        @Volatile
        private var INSTANCIA: SmartVoltDatabase? = null

        fun getInstance(context: Context): SmartVoltDatabase {
            return INSTANCIA ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    SmartVoltDatabase::class.java,
                    "smartvolt.db"
                ).build().also { INSTANCIA = it }
            }
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/model/local/entity/MarcaEntity.kt`

```kotlin
package com.example.smartvolt.model.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca

/**
 * Tabla local de marcas de asistencia.
 * Room guarda los enums por su nombre (p. ej. "ENTRADA") sin necesidad de TypeConverter.
 */
@Entity(tableName = "marcas")
data class MarcaEntity(
    @PrimaryKey val id: String,
    val tipo: TipoMarca,
    val hora: String,
    val fecha: String,
    val ubicacionFaena: String,
    val estado: EstadoMarca,
    val sincronizada: Boolean,
    val creadoEn: Long
)

// Conversión entre el modelo de dominio y la entidad de base de datos
fun MarcaEntity.toModel(): RegistroMarca = RegistroMarca(
    id = id,
    tipo = tipo,
    hora = hora,
    fecha = fecha,
    ubicacionFaena = ubicacionFaena,
    estado = estado
)

fun RegistroMarca.toEntity(sincronizada: Boolean, creadoEn: Long): MarcaEntity = MarcaEntity(
    id = id,
    tipo = tipo,
    hora = hora,
    fecha = fecha,
    ubicacionFaena = ubicacionFaena,
    estado = estado,
    sincronizada = sincronizada,
    creadoEn = creadoEn
)
```

---

## `app/src/main/java/com/example/smartvolt/model/local/preferences/PreferenciasSesion.kt`

```kotlin
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
```

---

## `app/src/main/java/com/example/smartvolt/model/local/temporal/FotoTemporalStorage.kt`

```kotlin
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
```

---

## `app/src/main/java/com/example/smartvolt/model/navigation/Destinos.kt`

```kotlin
package com.example.smartvolt.model.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinos(val ruta: String) {
    object Inicio : Destinos("inicio")
    object Login : Destinos("login")
    object Home : Destinos("home") // contenedor con la barra inferior

    // Pestañas de la barra inferior
    sealed class Inferior(
        ruta: String,
        val etiqueta: String,
        val icono: ImageVector
    ) : Destinos(ruta) {
        object InicioUsuario : Inferior("inicio_usuario", "Inicio", Icons.Filled.Home)
        object Calendario : Inferior("asistencia", "Asistencia", Icons.Filled.CalendarMonth)
        object Marcaje : Inferior("marcaje", "Marcaje", Icons.Filled.AccessTimeFilled)
        object Perfil : Inferior("perfil", "Perfil", Icons.Filled.AccountCircle)
        object Menu : Inferior("menu", "Menú", Icons.Filled.Menu)
    }
}

val destinosInferiores = listOf(
    Destinos.Inferior.InicioUsuario,
    Destinos.Inferior.Calendario,
    Destinos.Inferior.Marcaje,
    Destinos.Inferior.Perfil,
    Destinos.Inferior.Menu
)
```

---

## `app/src/main/java/com/example/smartvolt/model/repository/MarcaRepository.kt`

```kotlin
package com.example.smartvolt.model.repository

import java.util.Calendar
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.model.local.dao.MarcaDao
import com.example.smartvolt.model.local.entity.MarcaEntity
import com.example.smartvolt.model.local.entity.toEntity
import com.example.smartvolt.model.local.entity.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import kotlin.collections.forEach

class MarcaRepository(private val dao: MarcaDao) {

    fun observarMarcas(): Flow<List<RegistroMarca>> =
        dao.observarTodas().map { lista -> lista.map(MarcaEntity::toModel) }

    /**
     * Guarda la marca localmente como PENDIENTE. Queda pendiente de sincronizar
     * hasta que el servidor la confirme.
     */
    suspend fun registrarMarcaLocal(
        tipo: TipoMarca,
        hora: String,
        fecha: String,
        ubicacionFaena: String
    ): RegistroMarca {
        val marca = RegistroMarca(
            id = UUID.randomUUID().toString(),
            tipo = tipo,
            hora = hora,
            fecha = fecha,
            ubicacionFaena = ubicacionFaena,
            estado = EstadoMarca.PENDIENTE
        )
        dao.insertar(marca.toEntity(sincronizada = false, creadoEn = System.currentTimeMillis()))
        return marca
    }

    /**
     * Envía las marcas pendientes usando la función [enviar] (por ejemplo, una llamada
     * Retrofit). Si [enviar] devuelve true, la marca pasa a VALIDADA y sincronizada.
     * Devuelve la cantidad de marcas enviadas con éxito.
     */
    suspend fun sincronizarPendientes(enviar: suspend (RegistroMarca) -> Boolean): Int {
        var enviadas = 0
        dao.pendientesDeSincronizar().forEach { entity: MarcaEntity ->
            if (enviar(entity.toModel())) {
                dao.marcarComoSincronizada(entity.id, EstadoMarca.VALIDADA)
                enviadas++
            }
        }
        return enviadas
    }

    /** Marcas del mes en curso, de la más reciente a la más antigua. */
    fun observarMarcasDelMes(): Flow<List<RegistroMarca>> {
        val inicio = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_MONTH, 1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        val fin = (inicio.clone() as Calendar).apply { add(Calendar.MONTH, 1) }

        return dao.observarEntre(inicio.timeInMillis, fin.timeInMillis)
            .map { lista -> lista.map(MarcaEntity::toModel) }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/BadgeEstado.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Etiqueta pequeña redondeada ("Validada", "Pendiente", "Aprobadas"...). */
@Composable
fun BadgeEstado(
    texto: String,
    fondo: Color,
    colorTexto: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(fondo)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = texto,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = colorTexto
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/DetalleAsistenciasSheet.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul
import kotlinx.coroutines.launch

/** Popup (bottom sheet) con las marcas del mes guardadas en Room. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleAsistenciasSheet(
    mes: String,
    ultimaActualizacion: String,
    marcas: List<RegistroMarca>,
    onDismiss: () -> Unit
) {
    val estadoSheet = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    fun cerrar() {
        scope.launch { estadoSheet.hide() }.invokeOnCompletion {
            if (!estadoSheet.isVisible) onDismiss()
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = estadoSheet,
        containerColor = Superficie
    ) {
        // Cabecera: "Detalle" + X
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Detalle", fontSize = 18.sp, color = TextoPrincipal)
            IconButton(onClick = { cerrar() }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Cerrar",
                    tint = TextoPrincipal
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp),
            color = Borde
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f, fill = false)
                .navigationBarsPadding(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Asistencias de $mes",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextoPrincipal,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Última actualización: $ultimaActualizacion",
                        fontSize = 14.sp,
                        color = TextoSecundario
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            if (marcas.isEmpty()) {
                item {
                    Text(
                        text = "Aún no tienes marcas este mes. Registra una desde la pestaña Marcaje.",
                        fontSize = 14.sp,
                        color = TextoSecundario,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )
                }
            } else {
                items(marcas, key = { it.id }) { marca ->
                    ItemDetalleMarca(marca)
                }
            }
        }
    }
}

@Composable
private fun ItemDetalleMarca(marca: RegistroMarca) {
    val (fondoBadge, textoBadge, etiqueta) = when (marca.estado) {
        EstadoMarca.VALIDADA -> Triple(Exito, TextoSobreAzul, "Validada")
        EstadoMarca.PENDIENTE -> Triple(AmarilloPrincipal, TextoSobreAmarillo, "Pendiente")
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        border = BorderStroke(1.dp, Borde),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = marca.tipo.tituloDisplay,
                    fontSize = 18.sp,
                    color = TextoPrincipal
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${marca.fecha} - ${marca.ubicacionFaena}",
                    fontSize = 16.sp,
                    color = TextoSecundario
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = marca.hora,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )
                Spacer(modifier = Modifier.height(6.dp))
                BadgeEstado(texto = etiqueta, fondo = fondoBadge, colorTexto = textoBadge)
            }
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/EstadoAsistenciaCard.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.ui.theme.AmarilloCalido
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Representa los 3 estados posibles de la tarjeta según el flujo del mockup:
 * 1. NO_REGISTRADO: Barra amarilla, rayo opaco/gris.
 * 2. REGISTRADO: Barra azul, rayo amarillo brillante.
 * 3. PENDIENTE_CONEXION: Barra azul, rayo opaco/gris.
 */
enum class EstadoAsistencia {
    NO_REGISTRADO,
    REGISTRADO,
    PENDIENTE_CONEXION
}

@Composable
fun EstadoAsistenciaCard(
    fechaTurno: String = "Turno del 12 de octubre",
    horario: String = "8:30 a.m - 5 p.m",
    detalleColacion: String = "30 minutos de colación",
    estado: EstadoAsistencia = EstadoAsistencia.NO_REGISTRADO,
    modifier: Modifier = Modifier
) {
    // 1. Usamos la nueva clase aquí para desestructurar las propiedades
    val (colorBarra, colorIconoRayo, colorTextoBarra, mensajeBarra) = when (estado) {
        EstadoAsistencia.NO_REGISTRADO -> CardStyleConfig(
            colorBarra = AmarilloCalido,
            colorIconoRayo = Color.Gray.copy(alpha = 0.6f),
            colorTextoBarra = TextoSobreAmarillo,
            mensajeBarra = "¡Aún no marcas tu asistencia!"
        )
        EstadoAsistencia.REGISTRADO -> CardStyleConfig(
            colorBarra = AzulCorporativo,
            colorIconoRayo = AmarilloPrincipal,
            colorTextoBarra = TextoSobreAzul,
            mensajeBarra = "¡Asistencia registrada con éxito!"
        )
        EstadoAsistencia.PENDIENTE_CONEXION -> CardStyleConfig(
            colorBarra = AzulCorporativo,
            colorIconoRayo = Color.LightGray.copy(alpha = 0.7f),
            colorTextoBarra = TextoSobreAzul,
            mensajeBarra = "Marca registrada sin conexión"
        )
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = fechaTurno,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Outlined.Schedule,
                    contentDescription = "Horario de turno",
                    modifier = Modifier.size(44.dp),
                    tint = AzulCorporativo
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = horario,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = detalleColacion,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorBarra)
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bolt_vector),
                        contentDescription = "Ícono de estado",
                        modifier = Modifier.size(24.dp),
                        tint = colorIconoRayo
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = mensajeBarra,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorTextoBarra
                    )
                }
            }
        }
    }
}

// 2. Definimos una clase con nombre representativo y legible
private data class CardStyleConfig(
    val colorBarra: Color,
    val colorIconoRayo: Color,
    val colorTextoBarra: Color,
    val mensajeBarra: String
)


@Preview(showBackground = true, name = "1. No Registrado (Amarillo + Rayo Gris)")
@Composable
fun EstadoAsistenciaCardNoRegistradoPreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            estado = EstadoAsistencia.NO_REGISTRADO,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Registrado Exitoso (Azul + Rayo Amarillo)")
@Composable
fun EstadoAsistenciaCardRegistradoPreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            estado = EstadoAsistencia.REGISTRADO,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Pendiente Sin Conexión (Azul + Rayo Gris)")
@Composable
fun EstadoAsistenciaCardPendienteConexionPreview() {
    SmartVoltTheme {
        EstadoAsistenciaCard(
            estado = EstadoAsistencia.PENDIENTE_CONEXION,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ItemMarcaAsistencia.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Login
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.MoreTime
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.TimerOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoAdvertencia
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun ItemMarcaAsistencia(
    registro: RegistroMarca,
    modifier: Modifier = Modifier
) {
    // 1. Ícono de acompañamiento según el tipo de marca (tamaño discreto)
    val iconoTipoMarca: ImageVector = when (registro.tipo) {
        TipoMarca.ENTRADA -> Icons.AutoMirrored.Outlined.Login
        TipoMarca.SALIDA -> Icons.AutoMirrored.Outlined.Logout
        TipoMarca.ENTRADA_COLACION -> Icons.Outlined.Restaurant
        TipoMarca.SALIDA_COLACION -> Icons.Outlined.Coffee
        TipoMarca.ENTRADA_HORAS_EXTRA -> Icons.Outlined.MoreTime
        TipoMarca.SALIDA_HORAS_EXTRA -> Icons.Outlined.TimerOff
    }

    // 2. Estado visual: Rayo amarillo si está Validada / Rayo gris si está Pendiente
    val (colorRayo, colorFondoBadge, colorTextoBadge, etiquetaEstado) = when (registro.estado) {
        EstadoMarca.VALIDADA -> Quadruple(
            first = AmarilloPrincipal,                 // Rayo amarillo brillante
            second = Exito,
            third = TextoSobreAzul,
            fourth = "Validada"
        )
        EstadoMarca.PENDIENTE -> Quadruple(
            first = Color.Gray.copy(alpha = 0.5f),     // Rayo gris desaturado
            second = Advertencia,
            third = TextoSobreAzul,
            fourth = "Pendiente"
        )
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = AzulCorporativo
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //Icono de rayo interactivo
            Row(
            ) {
                // Vector de rayo (cambia entre amarillo normal y gris según la validez)
                Icon(
                    painter = painterResource(id = R.drawable.bolt_vector),
                    contentDescription = "Estado marcaje",
                    tint = colorRayo,
                    modifier = Modifier.size(34.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            // Secciones a la izquierda: Título con ícono representativo pequeño + Fecha y Faena
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Ícono discreto al lado del texto (no roba atención)
                    Icon(
                        imageVector = iconoTipoMarca,
                        contentDescription = null,
                        tint = Superficie,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = registro.tipo.tituloDisplay,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoSobreAzul
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${registro.fecha} • ${registro.ubicacionFaena}",
                    fontSize = 12.sp,
                    color = TextoSobreAzul
                )
            }

            // Secciones a la derecha: Hora de registro + Indicador con Rayo y Badge de estado
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = registro.hora,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoSobreAzul
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Chip / Badge de estado
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(colorFondoBadge)
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = etiquetaEstado,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorTextoBadge
                        )
                    }
                }
            }
        }
    }
}

// Estructura auxiliar para desestructurar las 4 variables del estado
private data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)

@Preview(showBackground = true, name = "1. Entrada Validada (Rayo Amarillo)")
@Composable
fun ItemEntradaValidadaPreview() {
    SmartVoltTheme {
        ItemMarcaAsistencia(
            registro = RegistroMarca(
                tipo = TipoMarca.ENTRADA,
                hora = "08:30 a.m.",
                fecha = "23 de octubre",
                ubicacionFaena = "Faena Central",
                estado = EstadoMarca.VALIDADA
            ),
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Inicio Colación Pendiente (Rayo Gris)")
@Composable
fun ItemColacionPendientePreview() {
    SmartVoltTheme {
        ItemMarcaAsistencia(
            registro = RegistroMarca(
                tipo = TipoMarca.ENTRADA_COLACION,
                hora = "13:05 p.m.",
                fecha = "23 de octubre",
                ubicacionFaena = "Comedor Faena Norte",
                estado = EstadoMarca.PENDIENTE
            ),
            modifier = Modifier.padding(12.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/MarcaAsistenciaCard.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.ErrorClaro
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.ExitoClaro
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Tarjeta de una marca: rayo + título + fecha/faena + badge a la izquierda,
 * hora + indicador (✓ / ! / ✗) a la derecha.
 * [colorFondo] permite usarla transparente dentro de la lista desplegable de horas extra.
 */
@Composable
fun MarcaAsistenciaCard(
    marca: MarcaDetalle,
    modifier: Modifier = Modifier,
    colorFondo: Color = AzulRey
) {
    val colorRayo = if (marca.estado == EstadoMarcaDetalle.VALIDADA) {
        AmarilloPrincipal
    } else {
        Color.Gray.copy(alpha = 0.7f)
    }
    val (fondoBadge, textoBadge) = when (marca.estado) {
        EstadoMarcaDetalle.VALIDADA -> Exito to TextoSobreAzul
        EstadoMarcaDetalle.PENDIENTE -> AmarilloPrincipal to TextoSobreAmarillo
        EstadoMarcaDetalle.SIN_REGISTRAR -> Error to TextoSobreAzul
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorFondo)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.bolt_vector),
            contentDescription = "Estado de la marca",
            tint = colorRayo,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = marca.titulo,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = TextoSobreAzul
            )
            Text(
                text = "${marca.fecha} - ${marca.faena}",
                fontSize = 11.sp,
                color = TextoSobreAzul.copy(alpha = 0.85f)
            )
            Spacer(modifier = Modifier.height(4.dp))
            BadgeEstado(
                texto = marca.estado.etiqueta,
                fondo = fondoBadge,
                colorTexto = textoBadge
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = marca.hora,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextoSobreAzul
            )
            Spacer(modifier = Modifier.height(4.dp))
            IndicadorEstadoMarca(marca.estado)
        }
    }
}

@Composable
private fun IndicadorEstadoMarca(estado: EstadoMarcaDetalle) {
    when (estado) {
        EstadoMarcaDetalle.VALIDADA -> Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Validada",
            tint = ExitoClaro,
            modifier = Modifier.size(30.dp)
        )

        EstadoMarcaDetalle.PENDIENTE -> Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(AmarilloPrincipal),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PriorityHigh,
                contentDescription = "Pendiente",
                tint = TextoSobreAmarillo,
                modifier = Modifier.size(18.dp)
            )
        }

        EstadoMarcaDetalle.SIN_REGISTRAR -> Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Sin registrar",
            tint = ErrorClaro,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFDCE5F1, name = "Estados de la marca")
@Composable
fun MarcaAsistenciaCardPreview() {
    SmartVoltTheme(dynamicColor = false) {
        Column(modifier = Modifier.padding(16.dp)) {
            EstadoMarcaDetalle.entries.forEach { estado ->
                MarcaAsistenciaCard(
                    marca = MarcaDetalle(
                        titulo = "Marca de entrada",
                        fecha = "23 de octubre",
                        faena = "Obra Norte",
                        hora = "9:31",
                        estado = estado
                    ),
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Sobre fondo AzulProfundo (lista desplegada)")
@Composable
fun MarcaAsistenciaCardTransparentePreview() {
    SmartVoltTheme(dynamicColor = false) {
        Box(modifier = Modifier.background(AzulProfundo)) {
            MarcaAsistenciaCard(
                marca = MarcaDetalle(
                    titulo = "Marca de salida",
                    fecha = "23 de octubre",
                    faena = "Obra Norte",
                    hora = "9:31",
                    estado = EstadoMarcaDetalle.VALIDADA
                ),
                colorFondo = Color.Transparent
            )
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ResumenAsistenciaAzulCard.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulElectrico
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAzul

/** Resumen mensual con fondo azul degradado y gráfico circular sobre panel blanco. */
@Composable
fun ResumenAsistenciaAzulCard(
    mes: String = "Octubre",
    asistenciasMarcadas: Int = 15,
    asistenciasTotales: Int = 30,
    modifier: Modifier = Modifier
) {
    val progreso = if (asistenciasTotales > 0) {
        (asistenciasMarcadas.toFloat() / asistenciasTotales.toFloat()).coerceIn(0f, 1f)
    } else 0f
    val porcentaje = (progreso * 100).toInt()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Brush.verticalGradient(listOf(AzulElectrico, AzulProfundo)))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Asistencias de $mes",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextoSobreAzul
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Panel blanco con el gráfico circular
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Superficie)
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(150.dp)) {
                CircularProgressIndicator(
                    progress = { progreso },
                    modifier = Modifier.fillMaxSize(),
                    color = AzulCorporativo,
                    strokeWidth = 12.dp,
                    trackColor = AzulCorporativo.copy(alpha = 0.12f),
                    strokeCap = StrokeCap.Round
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$asistenciasMarcadas/$asistenciasTotales",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextoPrincipal
                    )
                    Text(text = "asistencias", fontSize = 13.sp, color = TextoSecundario)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = TextoSobreAzul)) { append("Total: ") }
                withStyle(SpanStyle(color = AmarilloPrincipal)) { append("$porcentaje%") }
            },
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Tienes $asistenciasMarcadas asistencias marcadas de los $asistenciasTotales turnos que te fueron asignados",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextoSobreAzul,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, name = "50%")
@Composable
fun ResumenAsistenciaAzulCardPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ResumenAsistenciaAzulCard(modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true, name = "0%")
@Composable
fun ResumenAsistenciaAzulCardVacioPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ResumenAsistenciaAzulCard(
            mes = "Noviembre",
            asistenciasMarcadas = 0,
            asistenciasTotales = 20,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ResumenAsistenciaMensual.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun ResumenAsistenciaMensualCard(
    mes: String = "Octubre",
    asistenciasMarcadas: Int = 15,
    asistenciasTotales: Int = 30,
    modifier: Modifier = Modifier
) {
    // Cálculo automático del porcentaje de cumplimiento (0% - 100%)
    val porcentajeCalculado = if (asistenciasTotales > 0) {
        ((asistenciasMarcadas.toFloat() / asistenciasTotales.toFloat()) * 100).toInt()
    } else {
        0
    }

    // Progreso normalizado entre 0.0f y 1.0f para el indicador circular
    val progresoFloat = if (asistenciasTotales > 0) {
        (asistenciasMarcadas.toFloat() / asistenciasTotales.toFloat()).coerceIn(0f, 1f)
    } else {
        0f
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título superior de la sección
            Text(
                text = "Asistencias de $mes",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Gráfico Circular de Progreso con texto en el centro
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(150.dp)
            ) {
                // Indicador circular de Material Design 3
                CircularProgressIndicator(
                    progress = { progresoFloat },
                    modifier = Modifier.fillMaxSize(),
                    color = AzulCorporativo,
                    strokeWidth = 12.dp,
                    trackColor = AzulCorporativo.copy(alpha = 0.12f),
                    strokeCap = StrokeCap.Round
                )

                // Texto interno: "15/30" y "asistencias"
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$asistenciasMarcadas/$asistenciasTotales",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextoPrincipal
                    )
                    Text(
                        text = "asistencias",
                        fontSize = 13.sp,
                        color = TextoSecundario
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Porcentaje Total destacado
            Text(
                text = "Total: $porcentajeCalculado%",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AzulCorporativo
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Leyenda explicativa en el pie de la tarjeta
            Text(
                text = "Tienes $asistenciasMarcadas asistencias marcadas de los $asistenciasTotales turnos que te fueron asignados",
                fontSize = 13.sp,
                color = TextoSecundario,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        }
    }
}

@Preview(showBackground = true, name = "1. Mitad del Mes (50%)")
@Composable
fun ResumenAsistencia50PercentPreview() {
    SmartVoltTheme {
        ResumenAsistenciaMensualCard(
            mes = "Octubre",
            asistenciasMarcadas = 15,
            asistenciasTotales = 30,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Mes Completo (100%)")
@Composable
fun ResumenAsistencia100PercentPreview() {
    SmartVoltTheme {
        ResumenAsistenciaMensualCard(
            mes = "Octubre",
            asistenciasMarcadas = 22,
            asistenciasTotales = 22,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Inicio de Mes (0%)")
@Composable
fun ResumenAsistencia0PercentPreview() {
    SmartVoltTheme {
        ResumenAsistenciaMensualCard(
            mes = "Noviembre",
            asistenciasMarcadas = 0,
            asistenciasTotales = 20,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/ResumenAsistenciasMesCard.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

/** Tarjeta resumen: título, cantidad de asistencias del mes y enlace "Ver detalle". */
@Composable
fun ResumenAsistenciasMesCard(
    cantidad: Int,
    onVerDetalle: () -> Unit,
    modifier: Modifier = Modifier,
    titulo: String = "Asistencias del mes"
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = titulo,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = cantidad.toString(),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Normal,
                    color = AzulCorporativo
                )
                Text(
                    text = "Ver detalle",
                    fontSize = 18.sp,
                    color = AzulCorporativo,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable(onClick = onVerDetalle)
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumenAsistenciasMesCardPreview() {
    SmartVoltTheme(dynamicColor = false) {
        ResumenAsistenciasMesCard(
            cantidad = 23,
            onVerDetalle = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/asistencia/TarjetaMarcaje.kt`

```kotlin
package com.example.smartvolt.ui.components.asistencia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.R
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Tarjeta grande de marcaje (entrada o salida).
 * - sinConexion = false -> degradado azul, texto blanco
 * - sinConexion = true  -> degradado amarillo, texto oscuro
 */
@Composable
fun TarjetaMarcaje(
    titulo: String,
    hora: String,
    sinConexion: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val fondo = if (sinConexion) SmartVoltGradients.MarcajeOffline else SmartVoltGradients.MarcajeOnline
    val colorTexto = if (sinConexion) TextoSobreAmarillo else TextoSobreAzul

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(brush = fondo)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            // Imagen del badge (reemplaza al círculo azul + rayo)
            Image(
                painter = painterResource(id = R.drawable.badge_asistencia_foto),
                contentDescription = "Marcar asistencia",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(56.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = titulo,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = colorTexto
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = hora, fontSize = 14.sp, color = colorTexto)
        }
    }
}

@Preview(showBackground = true, name = "1. Entrada (online)")
@Composable
fun TarjetaMarcajeEntradaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Validar y marcar entrada",
            hora = "08:30 a.m",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Entrada sin conexión")
@Composable
fun TarjetaMarcajeEntradaOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Validar y marcar entrada sin conexión",
            hora = "08:30 a.m",
            sinConexion = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Salida (online)")
@Composable
fun TarjetaMarcajeSalidaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Validar y Marcar Salida",
            hora = "5:30 p.m",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "4. Salida sin conexión")
@Composable
fun TarjetaMarcajeSalidaOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        TarjetaMarcaje(
            titulo = "Marcar Salida sin conexion",
            hora = "5:30 p.m",
            sinConexion = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/avisos/AvisosCard.kt`

```kotlin
package com.example.smartvolt.ui.components.avisos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun AvisosCard(
    mensaje: String = "Estimados empleados, debido a las dificultades que han causado las fuertes lluvias, las operaciones están canceladas mañana",
    autor: String = "Martín Villablanca",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Avisos",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = mensaje, fontSize = 13.sp, color = TextoPrincipal)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = autor,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = TextoSecundario,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/botones/BotonAccionGradiente.kt`

```kotlin
package com.example.smartvolt.ui.components.botones

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun BotonAccionGradiente(
    texto: String,
    icono: ImageVector,
    fondo: Brush,
    colorContenido: Color,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(brush = fondo)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            tint = colorContenido,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = texto,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = colorContenido
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BotonesAccionPreview() {
    SmartVoltTheme(dynamicColor = false) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            BotonAccionGradiente(
                texto = "Escanear QR supervisor",
                icono = Icons.Outlined.QrCodeScanner,
                fondo = SmartVoltGradients.SecondaryButton,
                colorContenido = TextoSobreAzul
            )
            BotonAccionGradiente(
                texto = "Modo Offline",
                icono = Icons.Outlined.WifiOff,
                fondo = SmartVoltGradients.MarcajeOffline,
                colorContenido = TextoSobreAmarillo
            )
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/botones/BotonRegistrarAsistencia.kt`

```kotlin
package com.example.smartvolt.ui.components.botones

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun BotonRegistrarAsistencia(
    texto: String = "Asistencia",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Superficie,
            contentColor = TextoPrincipal
        )
    ) {
        Text(text = texto, fontSize = 28.sp)
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/calendario/CalendarioAsistenciaDialog.kt`

```kotlin
package com.example.smartvolt.ui.components.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.smartvolt.model.domain.EstadoDiaAsistencia
import com.example.smartvolt.ui.theme.AzulBrillante
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulElectrico
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.Pendiente
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import java.util.Calendar

private val NOMBRES_MES = listOf(
    "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"
)
private val DIAS_SEMANA = listOf("Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa")

/** ÚNICO lugar donde se definen los colores de los días. */
private fun colorFondoDia(estado: EstadoDiaAsistencia): Color = when (estado) {
    EstadoDiaAsistencia.ASISTIDO -> AzulCorporativo
    EstadoDiaAsistencia.AUSENTE -> Error
    EstadoDiaAsistencia.NO_LABORAL -> Pendiente
    EstadoDiaAsistencia.HOY -> AzulBrillante
}

/**
 * Calendario emergente. [estadoDia] recibe (año, mes 0-11, día) y devuelve el estado
 * a pintar, o null si el día no lleva color.
 */
@Composable
fun CalendarioAsistenciaDialog(
    onDismiss: () -> Unit,
    estadoDia: (anio: Int, mes: Int, dia: Int) -> EstadoDiaAsistencia? = ::estadoDiaEjemplo
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(modifier = Modifier.padding(horizontal = 24.dp)) {
            CalendarioAsistenciaContenido(onSalir = onDismiss, estadoDia = estadoDia)
        }
    }
}

@Composable
fun CalendarioAsistenciaContenido(
    onSalir: () -> Unit,
    modifier: Modifier = Modifier,
    estadoDia: (anio: Int, mes: Int, dia: Int) -> EstadoDiaAsistencia? = ::estadoDiaEjemplo
) {
    val hoy = remember { Calendar.getInstance() }
    val anioActual = hoy.get(Calendar.YEAR)
    var anio by remember { mutableIntStateOf(anioActual) }
    var mes by remember { mutableIntStateOf(hoy.get(Calendar.MONTH)) } // 0..11

    val anios = (minOf(anioActual - 5, anio)..maxOf(anioActual + 1, anio)).toList()
    val celdas = remember(anio, mes) { construirCeldas(anio, mes) }

    fun cambiarMes(delta: Int) {
        var nuevoMes = mes + delta
        var nuevoAnio = anio
        if (nuevoMes < 0) { nuevoMes = 11; nuevoAnio-- }
        if (nuevoMes > 11) { nuevoMes = 0; nuevoAnio++ }
        mes = nuevoMes
        anio = nuevoAnio
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Superficie)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Selector de mes / año
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { cambiarMes(-1) }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Mes anterior",
                    tint = TextoPrincipal
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SelectorDesplegable(
                    textoActual = NOMBRES_MES[mes],
                    opciones = NOMBRES_MES,
                    onSeleccion = { indice -> mes = indice }
                )
                SelectorDesplegable(
                    textoActual = anio.toString(),
                    opciones = anios.map { it.toString() },
                    onSeleccion = { indice -> anio = anios[indice] }
                )
            }
            IconButton(onClick = { cambiarMes(1) }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Mes siguiente",
                    tint = TextoPrincipal
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Cabecera de días de la semana
        Row(modifier = Modifier.fillMaxWidth()) {
            DIAS_SEMANA.forEach { dia ->
                Text(
                    text = dia,
                    fontSize = 12.sp,
                    color = TextoSecundario,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Grilla de días
        celdas.chunked(7).forEach { semana ->
            Row(modifier = Modifier.fillMaxWidth()) {
                semana.forEach { celda ->
                    CeldaDiaCalendario(
                        celda = celda,
                        estado = if (celda.delMes) estadoDia(anio, mes, celda.dia) else null,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSalir,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulElectrico,
                contentColor = Color.White
            )
        ) {
            Text(text = "Salir", fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun SelectorDesplegable(
    textoActual: String,
    opciones: List<String>,
    onSeleccion: (Int) -> Unit
) {
    var abierto by remember { mutableStateOf(false) }
    val forma = RoundedCornerShape(6.dp)

    Box {
        Row(
            modifier = Modifier
                .clip(forma)
                .border(width = 1.dp, color = Borde, shape = forma)
                .clickable { abierto = true }
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = textoActual, fontSize = 14.sp, color = TextoPrincipal)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                tint = TextoPrincipal,
                modifier = Modifier.size(18.dp)
            )
        }
        DropdownMenu(expanded = abierto, onDismissRequest = { abierto = false }) {
            opciones.forEachIndexed { indice, opcion ->
                DropdownMenuItem(
                    text = { Text(text = opcion) },
                    onClick = {
                        onSeleccion(indice)
                        abierto = false
                    }
                )
            }
        }
    }
}

@Composable
private fun CeldaDiaCalendario(
    celda: CeldaDia,
    estado: EstadoDiaAsistencia?,
    modifier: Modifier = Modifier
) {
    val (fondo, colorTexto) = when {
        celda.dia == 0 -> Color.Transparent to Color.Transparent
        !celda.delMes -> Color.Transparent to TextoSecundario.copy(alpha = 0.4f)
        estado == null -> Color.Transparent to TextoPrincipal
        else -> colorFondoDia(estado) to Color.White
    }

    Box(
        modifier = modifier
            .padding(2.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(6.dp))
            .background(fondo),
        contentAlignment = Alignment.Center
    ) {
        if (celda.dia != 0) {
            Text(text = celda.dia.toString(), fontSize = 14.sp, color = colorTexto)
        }
    }
}

// ---------- Lógica de calendario (java.util.Calendar: funciona con minSdk 24 sin desugaring) ----------

/** dia = 0 -> celda vacía antes del día 1. delMes = false -> días del mes siguiente (en gris). */
private data class CeldaDia(val dia: Int, val delMes: Boolean)

private fun construirCeldas(anio: Int, mes: Int): List<CeldaDia> {
    val primerDia = Calendar.getInstance().apply {
        clear()
        set(anio, mes, 1)
    }
    val vaciasInicio = primerDia.get(Calendar.DAY_OF_WEEK) - 1 // domingo = 0
    val diasDelMes = primerDia.getActualMaximum(Calendar.DAY_OF_MONTH)

    val celdas = mutableListOf<CeldaDia>()
    repeat(vaciasInicio) { celdas.add(CeldaDia(0, false)) }
    for (dia in 1..diasDelMes) celdas.add(CeldaDia(dia, true))
    val relleno = (7 - celdas.size % 7) % 7
    for (dia in 1..relleno) celdas.add(CeldaDia(dia, false))
    return celdas
}

/** Datos de ejemplo mientras no haya datos reales: hoy celeste, sábados grises, pasados azules. */
fun estadoDiaEjemplo(anio: Int, mes: Int, dia: Int): EstadoDiaAsistencia? {
    val hoy = Calendar.getInstance()
    val clave = anio * 10000 + mes * 100 + dia
    val claveHoy = hoy.get(Calendar.YEAR) * 10000 + hoy.get(Calendar.MONTH) * 100 + hoy.get(Calendar.DAY_OF_MONTH)
    val diaSemana = Calendar.getInstance().apply {
        clear()
        set(anio, mes, dia)
    }.get(Calendar.DAY_OF_WEEK)

    return when {
        clave == claveHoy -> EstadoDiaAsistencia.HOY
        clave > claveHoy -> null
        diaSemana == Calendar.SATURDAY -> EstadoDiaAsistencia.NO_LABORAL
        dia == 8 -> EstadoDiaAsistencia.AUSENTE
        else -> EstadoDiaAsistencia.ASISTIDO
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF8A94A6, name = "Calendario")
@Composable
fun CalendarioAsistenciaContenidoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        CalendarioAsistenciaContenido(
            onSalir = {},
            modifier = Modifier.padding(24.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/conexion/EstadoConexionCard.kt`

```kotlin
package com.example.smartvolt.ui.components.conexion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun EstadoConexionCard(
    estaConectado: Boolean = true,
    modifier: Modifier = Modifier
) {
    // Definición condicional según los 2 estados del mockup
    val colorFondo = Superficie
    val icono = if (estaConectado) Icons.Outlined.Wifi else Icons.Outlined.WifiOff
    val texto = if (estaConectado) "Estás conectado" else "No tienes conexión"
    val colorIcono = if (estaConectado) Exito else Error

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorFondo
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icono,
                contentDescription = texto,
                tint = colorIcono,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = texto,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal
            )
        }
    }
}


@Preview(showBackground = true, name = "1. Estado Online (Verde)")
@Composable
fun EstadoConexionOnlinePreview() {
    SmartVoltTheme {
        EstadoConexionCard(
            estaConectado = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Estado Offline (Rojo)")
@Composable
fun EstadoConexionOfflinePreview() {
    SmartVoltTheme {
        EstadoConexionCard(
            estaConectado = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/conexion/FaenaActualCard.kt`

```kotlin
package com.example.smartvolt.ui.components.conexion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun FaenaActualCard(
    nombreFaena: String = "Obra frente 2",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.LocalShipping,
                contentDescription = "Faena asignada",
                tint = TextoPrincipal,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = nombreFaena, fontSize = 22.sp, color = TextoPrincipal)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FaenaActualCardPreview() {
    SmartVoltTheme(dynamicColor = false) {
        FaenaActualCard(modifier = Modifier.padding(16.dp))
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/encabezados/Header.kt`

```kotlin
package com.example.smartvolt.ui.components.encabezados

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.TextoSobreAzul

@Composable
fun Header(
    saludo: String = "Hola Usuario!",
    fecha: String? = "Lunes 12 de octubre",
    onClickNotificaciones: () -> Unit = {},
    mostrarNotificaciones: Boolean = true,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = saludo,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextoSobreAzul
            )
            if (fecha != null) {
                Text(
                    text = fecha,
                    fontSize = 14.sp,
                    color = TextoSobreAzul.copy(alpha = 0.85f)
                )
            }
        }
        if (mostrarNotificaciones) {
            IconButton(onClick = onClickNotificaciones) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notificaciones",
                    tint = TextoSobreAzul,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/encabezados/TituloSeccion.kt`

```kotlin
package com.example.smartvolt.ui.components.encabezados

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun TituloSeccion(
    texto: String,
    icono: ImageVector = Icons.Outlined.ContentPaste,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            tint = TextoPrincipal,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = texto,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/horasextra/HorasExtraMesCard.kt`

```kotlin
package com.example.smartvolt.ui.components.horasextra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoJornadaExtra
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.JornadaHorasExtra
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulElectrico
import com.example.smartvolt.ui.theme.AzulMarino
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAzul

/** Tarjeta oscura "Horas extra del mes" con botón de período y detalle por jornada. */
@Composable
fun HorasExtraMesCard(
    horasFormateadas: String,
    periodo: String,
    jornadas: List<JornadaHorasExtra>,
    modifier: Modifier = Modifier,
    onCambiarPeriodo: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AzulMarino)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Horas extra del mes",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextoSobreAzul
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = horasFormateadas,
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
            color = AzulElectrico
        )
        Text(text = periodo, fontSize = 12.sp, color = TextoSobreAzul)

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onCambiarPeriodo,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulCorporativo,
                contentColor = TextoSobreAzul
            )
        ) {
            Text(text = "Cambiar periodo", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 24.dp),
            color = TextoSobreAzul.copy(alpha = 0.6f)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Detalle de las horas extra:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TextoSobreAzul,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (jornadas.isEmpty()) {
            Text(
                text = "No hay horas extra registradas en este período",
                fontSize = 13.sp,
                color = TextoSobreAzul.copy(alpha = 0.8f)
            )
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                jornadas.forEachIndexed { indice, jornada ->
                    // key evita que el estado desplegado se mezcle entre ítems
                    key(jornada.id) {
                        JornadaHorasExtraItem(
                            jornada = jornada,
                            inicialmenteExpandido = indice == 0
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Con jornadas")
@Composable
fun HorasExtraMesCardPreview() {
    val marcas = listOf(
        MarcaDetalle(
            titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        ),
        MarcaDetalle(
            titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        )
    )
    SmartVoltTheme(dynamicColor = false) {
        HorasExtraMesCard(
            horasFormateadas = "12h 30 min",
            periodo = "Octubre 2026",
            jornadas = listOf(
                JornadaHorasExtra("1", "23 de Octubre", "16:00 p.m. - 18:00 p.m. (2horas)", EstadoJornadaExtra.APROBADAS, marcas),
                JornadaHorasExtra("2", "23 de Octubre", "16:00 p.m. - 18:00 p.m. (2horas)", EstadoJornadaExtra.PENDIENTE, marcas)
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Sin jornadas")
@Composable
fun HorasExtraMesCardVaciaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        HorasExtraMesCard(
            horasFormateadas = "0h 00 min",
            periodo = "Noviembre 2026",
            jornadas = emptyList(),
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/horasextra/ItemHorasExtraDesplegable.kt`

```kotlin
package com.example.smartvolt.ui.components.horasextra

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.MoreTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.DetalleHorasExtra
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.ui.components.asistencia.ItemMarcaAsistencia
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoAdvertencia
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun ItemHorasExtraDesplegable(
    detalle: DetalleHorasExtra,
    modifier: Modifier = Modifier,
    inicialmenteExpandido: Boolean = false
) {
    // Estado interno para alternar la visibilidad de los detalles
    var expandido by remember { mutableStateOf(inicialmenteExpandido) }

    // Colores del badge según el estado de aprobación
    val (colorFondoBadge, colorTextoBadge, etiquetaEstado) = when (detalle.estado) {
        EstadoMarca.VALIDADA -> Triple(FondoExito, Exito, "Aprobadas")
        EstadoMarca.PENDIENTE -> Triple(FondoAdvertencia, Advertencia, "Pendientes")
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { expandido = !expandido }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // === VISTA SIN DESPLEGAR (RESUMEN) ===
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Izquierda: Ícono + Fecha y horario de entrada/salida
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(AzulCorporativo.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.MoreTime,
                            contentDescription = "Horas Extra",
                            tint = AzulCorporativo,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = detalle.fecha,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextoPrincipal
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "${detalle.horaEntrada} - ${detalle.horaSalida} (${detalle.totalHoras})",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AzulCorporativo
                        )
                    }
                }

                // Derecha: Badge de estado + Flecha de desplegado
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(colorFondoBadge)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = etiquetaEstado,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorTextoBadge
                        )
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    Icon(
                        imageVector = if (expandido) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (expandido) "Colapsar" else "Desplegar",
                        tint = TextoSecundario,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // === VISTA DESPLEGADA (DETALLE DE MARCAS) ===
            AnimatedVisibility(
                visible = expandido,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(14.dp))

                    HorizontalDivider(
                        color = Borde.copy(alpha = 0.5f),
                        thickness = 1.dp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Marcas asociadas a la jornada",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoSecundario,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // Marca 1: Inicio de Horas Extra
                    ItemMarcaAsistencia(
                        registro = detalle.marcaEntrada,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

                    // Marca 2: Término de Horas Extra
                    ItemMarcaAsistencia(
                        registro = detalle.marcaSalida,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, name = "1. Colapsado (Sin desplegar)")
@Composable
fun ItemHorasExtrasColapsadoPreview() {
    SmartVoltTheme {
        ItemHorasExtraDesplegable(
            detalle = DetalleHorasExtra(
                fecha = "23 de octubre",
                horaEntrada = "17:30 p.m.",
                horaSalida = "19:30 p.m.",
                totalHoras = "2h 00m",
                estado = EstadoMarca.VALIDADA
            ),
            inicialmenteExpandido = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Desplegado (Mostrando marcas)")
@Composable
fun ItemHorasExtrasDesplegadoPreview() {
    SmartVoltTheme {
        ItemHorasExtraDesplegable(
            detalle = DetalleHorasExtra(
                fecha = "23 de octubre",
                horaEntrada = "17:30 p.m.",
                horaSalida = "19:30 p.m.",
                totalHoras = "2h 00m",
                estado = EstadoMarca.VALIDADA
            ),
            inicialmenteExpandido = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/horasextra/JornadaHorasExtraItem.kt`

```kotlin
package com.example.smartvolt.ui.components.horasextra

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoJornadaExtra
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.JornadaHorasExtra
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.ui.components.asistencia.BadgeEstado
import com.example.smartvolt.ui.components.asistencia.MarcaAsistenciaCard
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.ErrorClaro
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.ExitoClaro
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

/**
 * Jornada con horas extra: cabecera (reloj de color según estado, fecha, horario, badge, flecha)
 * y, al desplegar, las marcas asociadas.
 */
@Composable
fun JornadaHorasExtraItem(
    jornada: JornadaHorasExtra,
    modifier: Modifier = Modifier,
    inicialmenteExpandido: Boolean = false
) {
    var expandido by remember { mutableStateOf(inicialmenteExpandido) }

    val colorReloj = when (jornada.estado) {
        EstadoJornadaExtra.APROBADAS -> ExitoClaro
        EstadoJornadaExtra.PENDIENTE -> AmarilloPrincipal
        EstadoJornadaExtra.RECHAZADAS -> ErrorClaro
    }
    val (fondoBadge, textoBadge) = when (jornada.estado) {
        EstadoJornadaExtra.APROBADAS -> Exito to TextoSobreAzul
        EstadoJornadaExtra.PENDIENTE -> AmarilloPrincipal to TextoSobreAmarillo
        EstadoJornadaExtra.RECHAZADAS -> Error to TextoSobreAzul
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(AzulProfundo)
    ) {
        // Cabecera (siempre visible)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulCorporativo)
                .clickable { expandido = !expandido }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Schedule,
                contentDescription = "Horas extra",
                tint = colorReloj,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = jornada.fecha,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoSobreAzul
                )
                Text(
                    text = jornada.horario,
                    fontSize = 11.sp,
                    color = TextoSobreAzul.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                BadgeEstado(
                    texto = jornada.estado.etiqueta,
                    fondo = fondoBadge,
                    colorTexto = textoBadge
                )
            }
            Icon(
                imageVector = if (expandido) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expandido) "Colapsar" else "Desplegar",
                tint = TextoSobreAzul,
                modifier = Modifier.size(28.dp)
            )
        }

        // Detalle desplegable
        AnimatedVisibility(
            visible = expandido,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                jornada.marcas.forEachIndexed { indice, marca ->
                    if (indice > 0) {
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            color = TextoSobreAzul.copy(alpha = 0.5f)
                        )
                    }
                    MarcaAsistenciaCard(marca = marca, colorFondo = Color.Transparent)
                }
            }
        }
    }
}

private fun jornadaEjemplo(estado: EstadoJornadaExtra) = JornadaHorasExtra(
    id = "1",
    fecha = "23 de Octubre",
    horario = "16:00 p.m. - 18:00 p.m. (2horas)",
    estado = estado,
    marcas = listOf(
        MarcaDetalle(
            titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        ),
        MarcaDetalle(
            titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte",
            hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA
        )
    )
)

@Preview(showBackground = true, name = "Aprobadas - desplegada")
@Composable
fun JornadaHorasExtraAprobadaPreview() {
    SmartVoltTheme(dynamicColor = false) {
        JornadaHorasExtraItem(
            jornada = jornadaEjemplo(EstadoJornadaExtra.APROBADAS),
            inicialmenteExpandido = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Pendiente - colapsada")
@Composable
fun JornadaHorasExtraPendientePreview() {
    SmartVoltTheme(dynamicColor = false) {
        JornadaHorasExtraItem(
            jornada = jornadaEjemplo(EstadoJornadaExtra.PENDIENTE),
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/horasextra/ResumenHorasExtrasCard.kt`

```kotlin
package com.example.smartvolt.ui.components.horasextra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun ResumenHorasExtrasCard(
    mes: String = "Octubre",
    horasFormateadas: String = "12h 30m",
    jornadasConExtra: Int = 4,
    estadoAprobacion: String = "Aprobadas",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Cabecera: Título y Badge de estado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Horas extras de $mes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                // Chip indicador de estado
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(FondoExito)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = estadoAprobacion,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Exito
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sección Central: Ícono + Total de horas acumuladas
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ícono destacado de Horas Extra (MoreTime)
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(AzulCorporativo.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.MoreTime,
                        contentDescription = "Horas Extraordinarias",
                        tint = AzulCorporativo,
                        modifier = Modifier.size(26.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = horasFormateadas,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = AzulCorporativo
                    )
                    Text(
                        text = "Acumuladas en $jornadasConExtra jornadas laborales",
                        fontSize = 12.sp,
                        color = TextoSecundario
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "1. Con Horas Extras Acumuladas")
@Composable
fun ResumenHorasExtrasConHorasPreview() {
    SmartVoltTheme {
        ResumenHorasExtrasCard(
            mes = "Octubre",
            horasFormateadas = "12h 30m",
            jornadasConExtra = 4,
            estadoAprobacion = "Aprobadas",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. Sin Horas Extras Registradas")
@Composable
fun ResumenHorasExtrasCeroPreview() {
    SmartVoltTheme {
        ResumenHorasExtrasCard(
            mes = "Noviembre",
            horasFormateadas = "0h 00m",
            jornadasConExtra = 0,
            estadoAprobacion = "Sin registros",
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/marcaje/PantallaCamaraFrontal.kt`

```kotlin
package com.example.smartvolt.ui.components.marcaje

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.Matrix
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import com.example.smartvolt.model.local.temporal.FotoTemporalStorage
import com.example.smartvolt.ui.theme.AzulCorporativo
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.Executors

/**
 * Pantalla completa con la cámara frontal y el botón para tomar la foto.
 * Al capturar, guarda un JPEG en la carpeta temporal y entrega el archivo en [onFotoTomada].
 */
@Composable
fun PantallaCamaraFrontal(
    onFotoTomada: (File) -> Unit,
    onCancelar: () -> Unit
) {
    val context = LocalContext.current
    val actividad = remember(context) { context.buscarActividad() }
    val ejecutorPrincipal = remember { ContextCompat.getMainExecutor(context) }
    val ejecutorFondo = remember { Executors.newSingleThreadExecutor() }
    val imageCapture = remember {
        ImageCapture.Builder()
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
            .build()
    }
    var proveedor by remember { mutableStateOf<ProcessCameraProvider?>(null) }
    var capturando by remember { mutableStateOf(false) }

    // Al salir de la pantalla: soltar la cámara y cerrar el hilo de fondo
    DisposableEffect(Unit) {
        onDispose {
            proveedor?.unbindAll()
            ejecutorFondo.shutdown()
        }
    }

    fun tomarFoto() {
        if (capturando) return
        capturando = true
        imageCapture.takePicture(ejecutorFondo, object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {
                try {
                    val rotacion = image.imageInfo.rotationDegrees.toFloat()
                    val original = image.toBitmap()
                    // Corrige la rotación y refleja la imagen (efecto selfie, como la vista previa)
                    val matriz = Matrix().apply {
                        postRotate(rotacion)
                        postScale(-1f, 1f)
                    }
                    val corregida = Bitmap.createBitmap(
                        original, 0, 0, original.width, original.height, matriz, true
                    )
                    val archivo = FotoTemporalStorage.crearArchivo(context)
                    FileOutputStream(archivo).use { salida ->
                        corregida.compress(Bitmap.CompressFormat.JPEG, 90, salida)
                    }
                    ejecutorPrincipal.execute {
                        capturando = false
                        onFotoTomada(archivo)
                    }
                } catch (e: Exception) {
                    ejecutorPrincipal.execute {
                        capturando = false
                        Toast.makeText(context, "No se pudo guardar la foto", Toast.LENGTH_SHORT).show()
                    }
                } finally {
                    image.close()
                }
            }

            override fun onError(exception: ImageCaptureException) {
                ejecutorPrincipal.execute {
                    capturando = false
                    Toast.makeText(context, "Error al tomar la foto", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    Dialog(
        onDismissRequest = onCancelar,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false,
            dismissOnClickOutside = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    PreviewView(ctx).apply {
                        // COMPATIBLE usa TextureView: funciona bien dentro de un Dialog
                        implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                        scaleType = PreviewView.ScaleType.FILL_CENTER

                        val futuro = ProcessCameraProvider.getInstance(ctx)
                        futuro.addListener({
                            try {
                                val camara = futuro.get()
                                val preview = Preview.Builder().build().also {
                                    it.setSurfaceProvider(surfaceProvider)
                                }
                                camara.unbindAll()
                                camara.bindToLifecycle(
                                    actividad!!,
                                    CameraSelector.DEFAULT_FRONT_CAMERA,
                                    preview,
                                    imageCapture
                                )
                                proveedor = camara
                            } catch (e: Exception) {
                                Toast.makeText(ctx, "No se pudo abrir la cámara frontal", Toast.LENGTH_LONG).show()
                                onCancelar()
                            }
                        }, ejecutorPrincipal)
                    }
                }
            )

            // Botón cerrar (arriba a la izquierda)
            IconButton(
                onClick = onCancelar,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .statusBarsPadding()
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Cancelar",
                    tint = Color.White
                )
            }

            // Botón para tomar la foto (abajo al centro)
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 48.dp)
                    .size(76.dp)
                    .clip(CircleShape)
                    .background(AzulCorporativo)
                    .border(3.dp, Color.White, CircleShape)
                    .clickable(enabled = !capturando) { tomarFoto() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.PhotoCamera,
                    contentDescription = "Tomar foto",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

private fun Context.buscarActividad(): ComponentActivity? {
    var ctx: Context? = this
    while (ctx is ContextWrapper) {
        if (ctx is ComponentActivity) return ctx
        ctx = ctx.baseContext
    }
    return null
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/marcaje/ValidacionMarcajeDialog.kt`

```kotlin
package com.example.smartvolt.ui.components.marcaje

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.Totem
import com.example.smartvolt.ui.theme.AmarilloOro
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulProfundo
import com.example.smartvolt.ui.theme.Pendiente
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

/**
 * Flujo de validación: buscando tótems -> elegir tótem -> aviso de foto
 * -> cámara -> revisar foto -> "Buen turno".
 * (El paso SOLICITANDO_CAMARA no dibuja nada: lo resuelve el permiso del sistema.)
 */
@Composable
fun ValidacionMarcajeDialog(
    paso: PasoValidacion,
    totems: List<Totem>,
    foto: File?,
    horaMarca: String,
    onSeleccionarTotem: (Totem) -> Unit,
    onConfirmarAviso: () -> Unit,
    onFotoTomada: (File) -> Unit,
    onContinuarFoto: () -> Unit,
    onReintentarFoto: () -> Unit,
    onContinuarBuenTurno: () -> Unit,
    onCancelar: () -> Unit,
    horaSalida: String = "5 p.m."
) {
    // La cámara va en su propia pantalla completa
    if (paso == PasoValidacion.CAMARA) {
        PantallaCamaraFrontal(onFotoTomada = onFotoTomada, onCancelar = onCancelar)
        return
    }

    val visible = paso == PasoValidacion.BUSCANDO_TOTEMS ||
            paso == PasoValidacion.SELECCION_TOTEM ||
            paso == PasoValidacion.CONFIRMAR_FOTO ||
            paso == PasoValidacion.REVISAR_FOTO ||
            paso == PasoValidacion.BUEN_TURNO
    if (!visible) return

    // En "Buen turno" no se puede cerrar tocando fuera ni con "atrás"
    val sePuedeCerrar = paso != PasoValidacion.BUEN_TURNO

    Dialog(
        onDismissRequest = onCancelar,
        properties = DialogProperties(
            dismissOnBackPress = sePuedeCerrar,
            dismissOnClickOutside = sePuedeCerrar,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Superficie),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (paso == PasoValidacion.BUEN_TURNO) {
                    PasoBuenTurno(
                        hora = horaMarca,
                        horaSalida = horaSalida,
                        onContinuar = onContinuarBuenTurno
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        when (paso) {
                            PasoValidacion.BUSCANDO_TOTEMS -> PasoBuscando()
                            PasoValidacion.SELECCION_TOTEM -> PasoSeleccion(totems, onSeleccionarTotem)
                            PasoValidacion.CONFIRMAR_FOTO -> PasoAvisoFoto(onConfirmarAviso, onCancelar)
                            PasoValidacion.REVISAR_FOTO -> PasoRevisarFoto(foto, onContinuarFoto, onReintentarFoto)
                            else -> Unit
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PasoBuscando() {
    Text(
        text = "Buscando tótems cercanos",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(text = "Por favor espera...", fontSize = 12.sp, color = TextoSecundario)
    Spacer(modifier = Modifier.height(32.dp))
    CircularProgressIndicator(
        modifier = Modifier.size(90.dp),
        color = AzulCorporativo,
        trackColor = AzulCorporativo.copy(alpha = 0.2f),
        strokeWidth = 10.dp,
        strokeCap = StrokeCap.Round
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
private fun PasoSeleccion(
    totems: List<Totem>,
    onSeleccionarTotem: (Totem) -> Unit
) {
    Text(
        text = "Escoge un tótem para marcar tu asistencia:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(24.dp))
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        totems.forEach { totem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onSeleccionarTotem(totem) }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(AzulCorporativo),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Bluetooth,
                        contentDescription = null,
                        tint = TextoSobreAzul,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = totem.nombre, fontSize = 14.sp, color = TextoPrincipal)
            }
        }
    }
}

@Composable
private fun PasoAvisoFoto(
    onConfirmar: () -> Unit,
    onVolver: () -> Unit
) {
    Text(
        text = "A continuación tomaremos una foto",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(text = "Para confirmar tu identidad...", fontSize = 12.sp, color = TextoPrincipal)
    Spacer(modifier = Modifier.height(24.dp))
    BotonAzul(texto = "Confirmar", onClick = onConfirmar)
    Spacer(modifier = Modifier.height(12.dp))
    BotonAzul(texto = "Volver", onClick = onVolver)
}

@Composable
private fun PasoRevisarFoto(
    foto: File?,
    onContinuar: () -> Unit,
    onReintentar: () -> Unit
) {
    Text(
        text = "Confirma tu foto para continuar:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = TextoPrincipal
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Se decodifica en segundo plano (reducida a la mitad para no gastar memoria)
    val imagen by produceState<ImageBitmap?>(initialValue = null, key1 = foto) {
        value = if (foto == null) null else withContext(Dispatchers.IO) {
            val opciones = BitmapFactory.Options().apply { inSampleSize = 2 }
            BitmapFactory.decodeFile(foto.absolutePath, opciones)?.asImageBitmap()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Pendiente.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        val bitmap = imagen
        if (bitmap != null) {
            Image(
                bitmap = bitmap,
                contentDescription = "Foto tomada",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                tint = TextoPrincipal,
                modifier = Modifier.size(96.dp)
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
    BotonAzul(texto = "Continuar", onClick = onContinuar)
    Spacer(modifier = Modifier.height(12.dp))
    BotonAzul(texto = "Reintentar", onClick = onReintentar)
}

@Composable
private fun PasoBuenTurno(
    hora: String,
    horaSalida: String,
    onContinuar: () -> Unit
) {
    // Franja amarilla superior
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(14.dp)
            .background(
                Brush.horizontalGradient(listOf(AmarilloOro, AmarilloPrincipal, AmarilloOro))
            )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Buen turno!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tu asistencia se registró con éxito a las $hora, recuerda marcar salida a las $horaSalida",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = TextoPrincipal
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(width = 4.dp, color = AmarilloPrincipal, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Asistencia registrada",
                tint = AmarilloPrincipal,
                modifier = Modifier.size(56.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(brush = SmartVoltGradients.YellowButton)
                .clickable(onClick = onContinuar),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Continuar",
                fontWeight = FontWeight.Bold,
                color = TextoSobreAmarillo
            )
        }
    }
}

@Composable
private fun BotonAzul(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AzulProfundo,
            contentColor = TextoSobreAzul
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = texto, fontWeight = FontWeight.Bold)
    }
}

private val totemsPreview = listOf(
    Totem("1", "Totem Obra 2"),
    Totem("2", "Totem Obra 3"),
    Totem("3", "Totem Obra 6")
)

@Composable
private fun DialogoPreview(paso: PasoValidacion) {
    SmartVoltTheme(dynamicColor = false) {
        ValidacionMarcajeDialog(
            paso = paso,
            totems = totemsPreview,
            foto = null,
            horaMarca = "8:31",
            onSeleccionarTotem = {},
            onConfirmarAviso = {},
            onFotoTomada = {},
            onContinuarFoto = {},
            onReintentarFoto = {},
            onContinuarBuenTurno = {},
            onCancelar = {}
        )
    }
}

@Preview(showBackground = true, name = "1. Buscando")
@Composable
fun ValidacionBuscandoPreview() = DialogoPreview(PasoValidacion.BUSCANDO_TOTEMS)

@Preview(showBackground = true, name = "2. Selección")
@Composable
fun ValidacionSeleccionPreview() = DialogoPreview(PasoValidacion.SELECCION_TOTEM)

@Preview(showBackground = true, name = "3. Aviso foto")
@Composable
fun ValidacionAvisoFotoPreview() = DialogoPreview(PasoValidacion.CONFIRMAR_FOTO)

@Preview(showBackground = true, name = "4. Revisar foto")
@Composable
fun ValidacionRevisarFotoPreview() = DialogoPreview(PasoValidacion.REVISAR_FOTO)

@Preview(showBackground = true, name = "5. Buen turno")
@Composable
fun ValidacionBuenTurnoPreview() = DialogoPreview(PasoValidacion.BUEN_TURNO)
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/perfil/AvatarPerfil.kt`

```kotlin
package com.example.smartvolt.ui.components.perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.SuperficieSecundaria
import com.example.smartvolt.ui.theme.TextoSecundario

/**
 * Avatar circular con botón de edición (lápiz) en la esquina inferior derecha.
 * Si [imagen] es null se muestra un ícono de persona como placeholder.
 */
@Composable
fun AvatarPerfil(
    imagen: Painter? = null,
    onEditar: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(120.dp)) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(SuperficieSecundaria),
            contentAlignment = Alignment.Center
        ) {
            if (imagen != null) {
                Image(
                    painter = imagen,
                    contentDescription = "Foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(120.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Foto de perfil",
                    tint = TextoSecundario,
                    modifier = Modifier.size(72.dp)
                )
            }
        }

        // Botón lápiz
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(36.dp)
                .clip(CircleShape)
                .background(AzulCorporativo)
                .border(2.dp, Superficie, CircleShape)
                .clickable(onClick = onEditar),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Editar foto",
                tint = Superficie,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AvatarPerfilPreview() {
    SmartVoltTheme(dynamicColor = false) {
        AvatarPerfil(modifier = androidx.compose.ui.Modifier.size(140.dp))
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/perfil/CampoDatoPerfil.kt`

```kotlin
package com.example.smartvolt.ui.components.perfil

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

/** Campo de solo lectura con borde redondeado para mostrar un dato del perfil. */
@Composable
fun CampoDatoPerfil(
    texto: String,
    modifier: Modifier = Modifier
) {
    val forma = RoundedCornerShape(8.dp)
    Box(
        modifier = modifier
            .widthIn(min = 150.dp)
            .border(width = 1.dp, color = TextoSecundario.copy(alpha = 0.6f), shape = forma)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = TextoPrincipal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CampoDatoPerfilPreview() {
    SmartVoltTheme(dynamicColor = false) {
        CampoDatoPerfil(texto = "Nombre usuario", modifier = Modifier.padding(16.dp))
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/permisos/EstadoPermisosCard.kt`

```kotlin
package com.example.smartvolt.ui.components.permisos


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.EstadoPermisos
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.FondoAdvertencia
import com.example.smartvolt.ui.theme.FondoExito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario

@Composable
fun EstadoPermisosCard(
    estadoPermisos: EstadoPermisos = EstadoPermisos(),
    modifier: Modifier = Modifier
) {
    // Estado global de la tarjeta (Badge del encabezado)
    val (colorFondoHeader, colorTextoHeader, textoHeader) = if (estadoPermisos.todosActivos) {
        Triple(FondoExito, Exito, "3/3 Listos")
    } else {
        Triple(FondoAdvertencia, Advertencia, "${estadoPermisos.totalActivos}/3 Pendientes")
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            // Encabezado principal del panel
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Permisos y sensores",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoPrincipal
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Requisitos anti-fraude de faena",
                        fontSize = 12.sp,
                        color = TextoSecundario
                    )
                }

                // Badge de resumen general
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(colorFondoHeader)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = textoHeader,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorTextoHeader
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            HorizontalDivider(color = Borde.copy(alpha = 0.4f), thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))

            // 1. Ítem Bluetooth (Tótems de faena)
            ItemPermisoSensor(
                icono = Icons.Outlined.Bluetooth,
                titulo = "Bluetooth",
                descripcion = "Detección de tótems cercanos",
                activo = estadoPermisos.bluetoothActivo
            )

            HorizontalDivider(
                color = Borde.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // 2. Ítem Ubicación / GPS
            ItemPermisoSensor(
                icono = Icons.Outlined.LocationOn,
                titulo = "Ubicación GPS",
                descripcion = "Verificación de presencia en faena",
                activo = estadoPermisos.gpsActivo
            )

            HorizontalDivider(
                color = Borde.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // 3. Ítem Cámara
            ItemPermisoSensor(
                icono = Icons.Outlined.PhotoCamera,
                titulo = "Cámara",
                descripcion = "Validación de identidad",
                activo = estadoPermisos.camaraPermiso
            )
        }
    }
}

/**
 * Fila individual para representar el estado de un permiso/sensor específico
 */
@Composable
private fun ItemPermisoSensor(
    icono: ImageVector,
    titulo: String,
    descripcion: String,
    activo: Boolean
) {
    val colorIconoBox = if (activo) AzulCorporativo else Advertencia
    val fondoIconoBox = if (activo) AzulCorporativo.copy(alpha = 0.1f) else FondoAdvertencia

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            // Contenedor del ícono del sensor
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(fondoIconoBox),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icono,
                    contentDescription = titulo,
                    tint = colorIconoBox,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = titulo,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )
                Text(
                    text = descripcion,
                    fontSize = 11.sp,
                    color = TextoSecundario
                )
            }
        }

        // Indicador de estado a la derecha (Checkmark verde o Alerta amarilla)
        if (activo) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Activo",
                tint = Exito,
                modifier = Modifier.size(22.dp)
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.ErrorOutline,
                    contentDescription = "Desactivado",
                    tint = Advertencia,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Requerido",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Advertencia
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "1. Todos los Permisos Activos")
@Composable
fun EstadoPermisosTodosActivosPreview() {
    SmartVoltTheme {
        EstadoPermisosCard(
            estadoPermisos = EstadoPermisos(
                bluetoothActivo = true,
                gpsActivo = true,
                camaraPermiso = true
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "2. GPS y Bluetooth Inactivos")
@Composable
fun EstadoPermisosPendientesPreview() {
    SmartVoltTheme {
        EstadoPermisosCard(
            estadoPermisos = EstadoPermisos(
                bluetoothActivo = false,
                gpsActivo = false,
                camaraPermiso = true
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "3. Ningún Permiso Activo")
@Composable
fun EstadoPermisosSinPermisosPreview() {
    SmartVoltTheme {
        EstadoPermisosCard(
            estadoPermisos = EstadoPermisos(
                bluetoothActivo = false,
                gpsActivo = false,
                camaraPermiso = false
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/permisos/PermisosMarcajeCard.kt`

```kotlin
package com.example.smartvolt.ui.components.permisos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.TagFaces
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.smartvolt.model.domain.EstadoVerificacion
import com.example.smartvolt.ui.theme.Advertencia
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.Exito
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

/**
 * Tarjeta "Estados de permiso" de la pantalla de marcaje.
 * Cada fila muestra: ícono del sensor + mensaje + indicador (✓ / ! / ✗).
 */
@Composable
fun PermisosMarcajeCard(
    estadoBluetooth: EstadoVerificacion = EstadoVerificacion.CORRECTO,
    estadoGps: EstadoVerificacion = EstadoVerificacion.ADVERTENCIA,
    estadoCamara: EstadoVerificacion = EstadoVerificacion.ERROR,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Superficie),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            ItemPermisoMarcaje(
                icono = Icons.Outlined.Bluetooth,
                estado = estadoBluetooth,
                textoBase = if (estadoBluetooth == EstadoVerificacion.CORRECTO)
                    "Validación del tótem (tu bluetooth está activado)"
                else "Validación del tótem pendiente, ",
                textoAccion = if (estadoBluetooth == EstadoVerificacion.CORRECTO)
                    null else "activa el bluetooth para seguir"
            )
            ItemPermisoMarcaje(
                icono = Icons.Filled.LocationOn,
                estado = estadoGps,
                textoBase = if (estadoGps == EstadoVerificacion.CORRECTO)
                    "Ubicación verificada en faena"
                else "Ubicación por verificar, ",
                textoAccion = if (estadoGps == EstadoVerificacion.CORRECTO)
                    null else "activa el gps para seguir"
            )
            ItemPermisoMarcaje(
                icono = Icons.Outlined.TagFaces,
                estado = estadoCamara,
                textoBase = if (estadoCamara == EstadoVerificacion.CORRECTO)
                    "Cámara lista para validar tu identidad"
                else "Activa los permisos para ",
                textoAccion = if (estadoCamara == EstadoVerificacion.CORRECTO)
                    null else "acceder a la cámara"
            )
        }
    }
}

@Composable
private fun ItemPermisoMarcaje(
    icono: ImageVector,
    estado: EstadoVerificacion,
    textoBase: String,
    textoAccion: String?
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            tint = TextoPrincipal,
            modifier = Modifier.size(28.dp)
        )

        Text(
            text = buildAnnotatedString {
                append(textoBase)
                if (textoAccion != null) {
                    withStyle(SpanStyle(color = AzulCorporativo)) { append(textoAccion) }
                }
            },
            fontSize = 12.sp,
            lineHeight = 15.sp,
            color = TextoPrincipal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        )

        IndicadorVerificacion(estado)
    }
}

@Composable
private fun IndicadorVerificacion(estado: EstadoVerificacion) {
    when (estado) {
        EstadoVerificacion.CORRECTO -> Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Correcto",
            tint = Exito,
            modifier = Modifier.size(26.dp)
        )

        EstadoVerificacion.ADVERTENCIA -> Box(
            modifier = Modifier
                .size(26.dp)
                .clip(CircleShape)
                .background(Advertencia),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PriorityHigh,
                contentDescription = "Advertencia",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

        EstadoVerificacion.ERROR -> Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Error",
            tint = Error,
            modifier = Modifier.size(26.dp)
        )
    }
}

@Preview(showBackground = true, name = "Como el mockup (✓ ! ✗)")
@Composable
fun PermisosMarcajeMockupPreview() {
    SmartVoltTheme(dynamicColor = false) {
        PermisosMarcajeCard(modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true, name = "Todo correcto")
@Composable
fun PermisosMarcajeCorrectoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        PermisosMarcajeCard(
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.CORRECTO,
            estadoCamara = EstadoVerificacion.CORRECTO,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/ubicacion/AlertaAnomaliaUbicacion.kt`

```kotlin
package com.example.smartvolt.ui.components.ubicacion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.FondoError
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal

/** Aviso que se muestra cuando el GPS reporta una ubicación simulada. */
@Composable
fun AlertaAnomaliaUbicacion(
    visible: Boolean,
    onCerrar: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(visible = visible, modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = FondoError),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 4.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Filled.Warning,
                    contentDescription = null,
                    tint = Error,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Anomalía en tu ubicación",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Error
                    )
                    Spacer(modifier = Modifier.width(0.dp))
                    Text(
                        text = "El GPS de este dispositivo parece simulado (Fake GPS o ubicación de prueba). " +
                                "Tu marca quedará pendiente de revisión por tu supervisor.",
                        fontSize = 13.sp,
                        color = TextoPrincipal
                    )
                }
                IconButton(onClick = onCerrar) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Cerrar alerta",
                        tint = TextoPrincipal
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Alerta de anomalía")
@Composable
fun AlertaAnomaliaUbicacionPreview() {
    SmartVoltTheme(dynamicColor = false) {
        AlertaAnomaliaUbicacion(
            visible = true,
            onCerrar = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/components/ubicacion/MapaUbicacionCard.kt`

```kotlin
package com.example.smartvolt.ui.components.ubicacion

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

/**
 * Muestra la posición del dispositivo sobre un mapa OpenStreetMap.
 * Requiere conexión para descargar los tiles del mapa.
 */
@Composable
fun MapaUbicacionCard(
    latitud: Double,
    longitud: Double,
    modifier: Modifier = Modifier
) {
    val contexto = LocalContext.current
    val ciclo = LocalLifecycleOwner.current

    val mapa = remember {
        // OSM exige identificar la app en las peticiones de tiles
        Configuration.getInstance().userAgentValue = contexto.packageName
        MapView(contexto).apply {
            setTileSource(TileSourceFactory.MAPNIK)
            setMultiTouchControls(true)
            controller.setZoom(17.0)
        }
    }

    // El MapView debe recibir los eventos de ciclo de vida de la Activity
    DisposableEffect(ciclo) {
        val observador = LifecycleEventObserver { _, evento ->
            when (evento) {
                Lifecycle.Event.ON_RESUME -> mapa.onResume()
                Lifecycle.Event.ON_PAUSE -> mapa.onPause()
                else -> Unit
            }
        }
        ciclo.lifecycle.addObserver(observador)
        onDispose {
            ciclo.lifecycle.removeObserver(observador)
            mapa.onDetach()
        }
    }

    AndroidView(
        factory = { mapa },
        update = { vista ->
            val punto = GeoPoint(latitud, longitud)
            vista.controller.setCenter(punto)
            vista.overlays.clear()
            vista.overlays.add(
                Marker(vista).apply {
                    position = punto
                    setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    title = "Tu ubicación"
                }
            )
            vista.invalidate()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/theme/Color.kt`

```kotlin
package com.example.smartvolt.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


// ========================================
// COLORES PRINCIPALES (degradado del diseño)
// ========================================

val AzulNoche = Color(0xFF000814)      // 100% del degradado (sin cambio)
val AzulMarino = Color(0xFF001C47)     // 77%
val AzulProfundo = Color(0xFF002965)   // 25%
val AzulBase = Color(0xFF00317A)       // 0% (nuevo, el más claro del degradado)

// Colores de acento (no aparecen en la imagen, se mantienen)
val AzulBrillante = Color(0xFF007BFF)
val AzulRey = Color(0xFF003F88)
val AzulCorporativo = Color(0xFF00509D)
val AzulIntermedio = Color(0xFF0066CC)
val AzulElectrico = Color(0xFF0878F9)
val AzulCeleste = Color(0xFF64D2FF)

// ========================================
// AMARILLOS
// ========================================
val AmarilloPrincipal = Color(0xFFFFD500)
val AmarilloCalido = Color(0xFFFFC400)
val AmarilloOro = Color(0xFFFFB300)   // NUEVO: inicio del degradado amarillo (gold-900)

// ========================================
// FONDOS Y SUPERFICIES
// ========================================

val FondoPrincipal = Color(0xFFDCE5F1)
val FondoClaro = Color(0xFFF5FAFF)

val Superficie = Color(0xFFFFFFFF)
val SuperficieSecundaria = Color(0xFFEDF3FA)
val SuperficieOscura = Color(0xFF000000)

val Borde = Color(0xFFC7D3E2)

// ========================================
// TEXTOS
// ========================================

val TextoPrincipal = Color(0xFF101828)
val TextoSecundario = Color(0xFF526174)
val TextoSobreAzul = Color(0xFFFFFFFF)
val TextoSobreAmarillo = Color(0xFF001A37)

// ========================================
// COLORES OPERACIONALES
// ========================================

val Exito = Color(0xFF238653)
val FondoExito = Color(0xFFE8F5EC)

val Error = Color(0xFFBA1A1A)
val FondoError = Color(0xFFFCE8E6)

// colores para el boton de la toolbar asistencia
val ExitoClaro = Color(0xFF3DDC84)
val ErrorClaro = Color(0xFFFF4D4D)

val Advertencia = Color(0xFF9A5700)
val FondoAdvertencia = Color(0xFFFFF0CC)

val Informacion = Color(0xFF00509D)
val FondoInformacion = Color(0xFFE3F2FD)

val Pendiente = Color(0xFF607D8B)
val FondoPendiente = Color(0xFFEAF0F4)
```

---

## `app/src/main/java/com/example/smartvolt/ui/theme/SmartVoltGradients.kt`

```kotlin
package com.example.smartvolt.ui.theme

import androidx.compose.ui.graphics.Brush

object SmartVoltGradients {

    // ========================================
    // INICIO DE SESIÓN
    // Azul luminoso hacia azul profundo
    // ========================================

    val LoginBackground = Brush.verticalGradient(
        colorStops = arrayOf(
            0.00f to AzulBase,
            0.25f to AzulProfundo,
            0.77f to AzulMarino,
            1.00f to AzulNoche
        )
    )

    // ========================================
    // BOTÓN PRINCIPAL DE ASISTENCIA
    // ========================================

    val AttendanceButton = Brush.verticalGradient(
        colors = listOf(
            AzulCorporativo,
            AzulProfundo
        )
    )

    // ========================================
    // BOTONES SECUNDARIOS
    // ========================================

    val SecondaryButton = Brush.verticalGradient(
        colors = listOf(
            AzulProfundo,
            AzulMarino
        )
    )

    // ========================================
    // DECORACIÓN AZUL LUMINOSA
    // ========================================

    val BlueDecoration = Brush.linearGradient(
        colors = listOf(
            AzulProfundo,
            AzulCorporativo,
            AzulElectrico
        )
    )

    // ========================================
    // BOTÓN AMARILLO
    // ========================================

    val YellowButton = Brush.verticalGradient(
        colors = listOf(
            AmarilloPrincipal,
            AmarilloCalido
        )
    )

    // ========================================
    // TARJETA DE MARCAJE
    // ========================================

    // Online: azul noche (navy-900, 0%) -> azul brillante (blue-900, 100%)
    val MarcajeOnline = Brush.verticalGradient(
        colors = listOf(
            AzulNoche,
            AzulElectrico
        )
    )

    // Sin conexión: dorado (gold-900, 0%) -> amarillo (gold-400, 100%)
    val MarcajeOffline = Brush.verticalGradient(
        colors = listOf(
            AmarilloOro,
            AmarilloPrincipal
        )
    )
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/theme/Theme.kt`

```kotlin
package com.example.smartvolt.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun SmartVoltTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/theme/Type.kt`

```kotlin
package com.example.smartvolt.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/AsistenciaView.kt`

```kotlin
package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.domain.EstadoJornadaExtra
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.EstadoMarcaDetalle
import com.example.smartvolt.model.domain.JornadaHorasExtra
import com.example.smartvolt.model.domain.MarcaDetalle
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.ui.components.asistencia.DetalleAsistenciasSheet
import com.example.smartvolt.ui.components.asistencia.ResumenAsistenciaAzulCard
import com.example.smartvolt.ui.components.asistencia.ResumenAsistenciasMesCard
import com.example.smartvolt.ui.components.calendario.CalendarioAsistenciaDialog
import com.example.smartvolt.ui.components.encabezados.Header
import com.example.smartvolt.ui.components.horasextra.HorasExtraMesCard
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.viewmodel.AsistenciaViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Versión con estado: lee las marcas del mes desde Room (vía ViewModel)
 * y delega la parte visual en [AsistenciaContent].
 */
@Composable
fun AsistenciaView(
    viewModel: AsistenciaViewModel = viewModel()
) {
    val marcasDelMes by viewModel.marcasDelMes.collectAsState()
    val asistenciasDelMes by viewModel.asistenciasDelMes.collectAsState()

    AsistenciaContent(
        marcasDelMes = marcasDelMes,
        asistenciasDelMes = asistenciasDelMes
    )
}

/**
 * Pestaña "Asistencia": resumen de asistencias del mes (con popup de detalle),
 * resumen mensual y horas extra del mes.
 */
@Composable
fun AsistenciaContent(
    marcasDelMes: List<RegistroMarca>,
    asistenciasDelMes: Int,
    mes: String = nombreMesActual(),
    asistenciasMarcadas: Int = 15,
    asistenciasTotales: Int = 30,
    horasExtraFormateadas: String = "12h 30 min",
    periodoHorasExtra: String = "Octubre 2026",
    jornadasHorasExtra: List<JornadaHorasExtra> = jornadasEjemplo,
    onVerCalendario: () -> Unit = {},
    onCambiarPeriodo: () -> Unit = {}
) {
    var mostrarCalendario by remember { mutableStateOf(false) }
    var mostrarDetalle by remember { mutableStateOf(false) }

    if (mostrarCalendario) {
        CalendarioAsistenciaDialog(onDismiss = { mostrarCalendario = false })
    }

    if (mostrarDetalle) {
        DetalleAsistenciasSheet(
            mes = mes,
            ultimaActualizacion = fechaHoy(),
            marcas = marcasDelMes,
            onDismiss = { mostrarDetalle = false }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Zona azul: mismo Header de las demás pantallas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 16.dp)
        ) {
            Header()
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tus asistencias:",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                Button(
                    onClick = {
                        mostrarCalendario = true
                        onVerCalendario()
                    },
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AmarilloPrincipal,
                        contentColor = TextoSobreAmarillo
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.CalendarMonth,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "Ver calendario", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                }
            }

            // Reemplaza la lista de tarjetas azules por la tarjeta resumen + popup
            ResumenAsistenciasMesCard(
                cantidad = asistenciasDelMes,
                onVerDetalle = { mostrarDetalle = true }
            )

            ResumenAsistenciaAzulCard(
                mes = mes,
                asistenciasMarcadas = asistenciasMarcadas,
                asistenciasTotales = asistenciasTotales
            )

            HorasExtraMesCard(
                horasFormateadas = horasExtraFormateadas,
                periodo = periodoHorasExtra,
                jornadas = jornadasHorasExtra,
                onCambiarPeriodo = onCambiarPeriodo
            )
        }
    }
}

// ---------- Utilidades ----------

private fun nombreMesActual(): String =
    SimpleDateFormat("MMMM", Locale("es")).format(Date())
        .replaceFirstChar { it.uppercase() }

private fun fechaHoy(): String =
    SimpleDateFormat("d/M/yyyy", Locale.getDefault()).format(Date())

// ---------- Datos ficticios para previews ----------

private val marcasEjemplo = listOf(
    RegistroMarca("1", TipoMarca.ENTRADA, "08:31", "4 de noviembre", "Obra frente 2", EstadoMarca.VALIDADA),
    RegistroMarca("2", TipoMarca.ENTRADA, "08:29", "3 de noviembre", "Obra frente 2", EstadoMarca.PENDIENTE)
)

private val jornadasEjemplo = listOf(
    JornadaHorasExtra(
        id = "1", fecha = "23 de Octubre", horario = "16:00 p.m. - 18:00 p.m. (2horas)",
        estado = EstadoJornadaExtra.APROBADAS,
        marcas = listOf(
            MarcaDetalle(titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA),
            MarcaDetalle(titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.VALIDADA)
        )
    ),
    JornadaHorasExtra(
        id = "2", fecha = "23 de Octubre", horario = "16:00 p.m. - 18:00 p.m. (2horas)",
        estado = EstadoJornadaExtra.PENDIENTE,
        marcas = listOf(
            MarcaDetalle(titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.PENDIENTE),
            MarcaDetalle(titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.PENDIENTE)
        )
    ),
    JornadaHorasExtra(
        id = "3", fecha = "23 de Octubre", horario = "16:00 p.m. - 18:00 p.m. (2horas)",
        estado = EstadoJornadaExtra.RECHAZADAS,
        marcas = listOf(
            MarcaDetalle(titulo = "Marca de salida", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.SIN_REGISTRAR),
            MarcaDetalle(titulo = "Marca de entrada", fecha = "23 de octubre", faena = "Obra Norte", hora = "9:31", estado = EstadoMarcaDetalle.PENDIENTE)
        )
    )
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AsistenciaViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        AsistenciaContent(
            marcasDelMes = marcasEjemplo,
            asistenciasDelMes = 23
        )
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/InicioSupervisorView.kt`

```kotlin
package com.example.smartvolt.ui.view

import androidx.compose.runtime.Composable

@Composable
fun InicioSupervisorView() {
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/InicioUsuarioView.kt`

```kotlin
package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartvolt.ui.components.avisos.AvisosCard
import com.example.smartvolt.ui.components.botones.BotonRegistrarAsistencia
import com.example.smartvolt.ui.components.asistencia.EstadoAsistencia
import com.example.smartvolt.ui.components.asistencia.EstadoAsistenciaCard
import com.example.smartvolt.ui.components.encabezados.Header
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme

@Composable
fun InicioUsuarioView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Zona azul: Header + botón Asistencia
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 24.dp)
        ) {
            Header()
            BotonRegistrarAsistencia(
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            AvisosCard()
            TituloSeccion(texto = "Estado de asistencia")
            EstadoAsistenciaCard(estado = EstadoAsistencia.NO_REGISTRADO)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioUsuarioViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        InicioUsuarioView()
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/LoginView.kt`

```kotlin
package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.smartvolt.model.navigation.Destinos
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.Borde
import com.example.smartvolt.ui.theme.Error
import com.example.smartvolt.ui.theme.FondoError
import com.example.smartvolt.ui.theme.FondoInformacion
import com.example.smartvolt.ui.theme.Informacion
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.SuperficieSecundaria
import com.example.smartvolt.ui.theme.TextoPrincipal
import com.example.smartvolt.ui.theme.TextoSecundario
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul

// ---------- Datos de acceso (MVP con datos ficticios) ----------
private const val CORREO_VALIDO = "trabajador@smartvolt.cl"
private const val PASS_VALIDA = "Hola#1234"
private const val DOMINIO_PERMITIDO = "smartvolt.cl"
private val REGEX_CORREO = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$")

/** Resultado de validar el formulario: mensajes de error y qué campos marcar. */
data class ResultadoLogin(
    val mensajes: List<String> = emptyList(),
    val correoInvalido: Boolean = false,
    val passInvalida: Boolean = false
) {
    val esValido: Boolean get() = mensajes.isEmpty()
}

/** Valida formato, dominio, reglas de contraseña y credenciales exactas. */
fun validarLogin(correo: String, pass: String): ResultadoLogin {
    val mensajes = mutableListOf<String>()
    var correoMal = false
    var passMal = false
    val correoLimpio = correo.trim()

    // 1. Formato de correo (debe tener @ y un punto)
    if (!REGEX_CORREO.matches(correoLimpio)) {
        mensajes += "El correo no tiene un formato válido (debe incluir @ y un punto)."
        correoMal = true
    } else if (correoLimpio.substringAfter("@").lowercase() != DOMINIO_PERMITIDO) {
        // 2. Dominio corporativo
        mensajes += "El correo debe pertenecer al dominio @$DOMINIO_PERMITIDO."
        correoMal = true
    }

    // 3. Reglas de contraseña
    if (pass.length <= 8) {
        mensajes += "La contraseña debe tener más de 8 caracteres."
        passMal = true
    }
    if (pass.none { it.isUpperCase() }) {
        mensajes += "La contraseña debe incluir al menos una letra mayúscula."
        passMal = true
    }
    if (pass.none { !it.isLetterOrDigit() }) {
        mensajes += "La contraseña debe incluir al menos un símbolo (por ejemplo #, @ o !)."
        passMal = true
    }

    // 4. Credenciales exactas (solo si lo anterior está correcto)
    if (mensajes.isEmpty() &&
        (correoLimpio.lowercase() != CORREO_VALIDO || pass != PASS_VALIDA)
    ) {
        mensajes += "Correo o contraseña incorrectos."
        correoMal = true
        passMal = true
    }

    return ResultadoLogin(mensajes, correoMal, passMal)
}

@Composable
fun LoginView(navController: NavController) {
    var usuario by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var correoErroneo by remember { mutableStateOf(false) }
    var passErronea by remember { mutableStateOf(false) }
    var mensajesError by remember { mutableStateOf<List<String>>(emptyList()) }
    var mostrarAyudaContrasena by remember { mutableStateOf(false) }

    // Colores de los campos. El borde sin foco usa Borde (gris azulado) para que
    // se distinga del fondo blanco y la etiqueta flotante no se pierda al enfocar.
    val coloresCampo = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Superficie,
        unfocusedContainerColor = Superficie,
        disabledContainerColor = Superficie,
        errorContainerColor = Superficie,
        focusedTextColor = TextoPrincipal,
        unfocusedTextColor = TextoPrincipal,
        errorTextColor = TextoPrincipal,
        focusedLabelColor = AzulCorporativo,
        unfocusedLabelColor = TextoSecundario,
        errorLabelColor = Error,
        focusedLeadingIconColor = AzulCorporativo,
        unfocusedLeadingIconColor = TextoSecundario,
        errorLeadingIconColor = Error,
        cursorColor = AzulCorporativo,
        errorCursorColor = Error,
        focusedBorderColor = AmarilloPrincipal,
        unfocusedBorderColor = Borde,
        errorBorderColor = Error
    )

    // Estilo del texto escrito: color explícito para que nunca herede un gris
    val estiloTexto = TextStyle(color = TextoPrincipal, fontSize = 16.sp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = SmartVoltGradients.LoginBackground)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo SMART (blanco) + VOLT (amarillo)
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = TextoSobreAzul)) { append("SMART") }
                withStyle(SpanStyle(color = AmarilloPrincipal)) { append("VOLT") }
            },
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Portal Trabajador",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = TextoSobreAzul
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Correo electrónico",
            color = TextoSobreAzul,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = usuario,
            onValueChange = {
                usuario = it
                correoErroneo = false
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            singleLine = true,
            isError = correoErroneo,
            textStyle = estiloTexto,
            shape = RoundedCornerShape(12.dp),
            colors = coloresCampo,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Contraseña",
            color = TextoSobreAzul,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = {
                pass = it
                passErronea = false
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            singleLine = true,
            isError = passErronea,
            textStyle = estiloTexto,
            shape = RoundedCornerShape(12.dp),
            colors = coloresCampo,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val resultado = validarLogin(usuario, pass)
                correoErroneo = resultado.correoInvalido
                passErronea = resultado.passInvalida
                if (resultado.esValido) {
                    navController.navigate(route = Destinos.Home.ruta) {
                        popUpTo(route = Destinos.Login.ruta) { inclusive = true }
                    }
                } else {
                    mensajesError = resultado.mensajes
                }
            },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = AmarilloPrincipal,
                contentColor = TextoSobreAmarillo
            )
        ) {
            Text(text = "Iniciar Sesión", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(24.dp))

        TextButton(onClick = { mostrarAyudaContrasena = true }) {
            Text(
                text = "¿Olvidaste tu contraseña?",
                color = AmarilloPrincipal,
                fontSize = 12.sp
            )
        }
    }

    if (mensajesError.isNotEmpty()) {
        AlertaLogin(
            titulo = "No pudimos iniciar sesión",
            mensajes = mensajesError,
            icono = Icons.Outlined.ErrorOutline,
            colorIcono = Error,
            fondoIcono = FondoError,
            textoBoton = "Entendido",
            onCerrar = { mensajesError = emptyList() }
        )
    }

    if (mostrarAyudaContrasena) {
        AlertaLogin(
            titulo = "Cambio de contraseña",
            mensajes = listOf(
                "Para cambiar tu contraseña debes contactar a un administrador."
            ),
            icono = Icons.Outlined.Info,
            colorIcono = Informacion,
            fondoIcono = FondoInformacion,
            textoBoton = "Entendido",
            onCerrar = { mostrarAyudaContrasena = false }
        )
    }
}

/**
 * Alerta reutilizable con el estilo del mockup: tarjeta blanca, ícono sobre
 * círculo de color suave, panel de mensajes y botón amarillo tipo píldora.
 */
@Composable
fun AlertaLogin(
    titulo: String,
    mensajes: List<String>,
    icono: ImageVector,
    colorIcono: Color,
    fondoIcono: Color,
    textoBoton: String,
    onCerrar: () -> Unit
) {
    Dialog(
        onDismissRequest = onCerrar,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Superficie)
                .padding(horizontal = 24.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(fondoIcono),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icono,
                    contentDescription = titulo,
                    tint = colorIcono,
                    modifier = Modifier.size(34.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(SuperficieSecundaria)
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                mensajes.forEach { mensaje ->
                    Row(verticalAlignment = Alignment.Top) {
                        Box(
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(colorIcono)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = mensaje,
                            fontSize = 13.sp,
                            lineHeight = 18.sp,
                            color = TextoPrincipal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onCerrar,
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AmarilloPrincipal,
                    contentColor = TextoSobreAmarillo
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = textoBoton, fontWeight = FontWeight.Bold)
            }
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/MainContainerView.kt`

```kotlin
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
            composable(Destinos.Inferior.Calendario.ruta) { AsistenciaView() }
            composable(Destinos.Inferior.Marcaje.ruta) { MarcajeView() }
            composable(Destinos.Inferior.Perfil.ruta) { PerfilView() }
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
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/MarcajeView.kt`

```kotlin
package com.example.smartvolt.ui.view


import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.smartvolt.model.domain.EstadoUbicacion
import com.example.smartvolt.model.domain.LecturaUbicacion
import com.example.smartvolt.model.domain.toEstadoVerificacion
import com.example.smartvolt.ui.components.ubicacion.AlertaAnomaliaUbicacion
import com.example.smartvolt.ui.components.ubicacion.MapaUbicacionCard
import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartvolt.model.domain.EstadoMarca
import com.example.smartvolt.model.domain.EstadoVerificacion
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.ui.components.asistencia.ItemMarcaAsistencia
import com.example.smartvolt.ui.components.asistencia.TarjetaMarcaje
import com.example.smartvolt.ui.components.botones.BotonAccionGradiente
import com.example.smartvolt.ui.components.conexion.EstadoConexionCard
import com.example.smartvolt.ui.components.conexion.FaenaActualCard
import com.example.smartvolt.ui.components.encabezados.TituloSeccion
import com.example.smartvolt.ui.components.marcaje.ValidacionMarcajeDialog
import com.example.smartvolt.ui.components.permisos.PermisosMarcajeCard
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.TextoSobreAmarillo
import com.example.smartvolt.ui.theme.TextoSobreAzul
import com.example.smartvolt.viewmodel.MarcajeViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Versión con estado: obtiene los datos del ViewModel y delega la UI en [MarcajeContent].
 */
@Composable
fun MarcajeView(
    estaConectado: Boolean = true,
    nombreFaena: String = "Obra frente 2",
    tipoMarca: TipoMarca = TipoMarca.ENTRADA,
    estadoBluetooth: EstadoVerificacion = EstadoVerificacion.CORRECTO,
    estadoGps: EstadoVerificacion = EstadoVerificacion.ADVERTENCIA,
    estadoCamara: EstadoVerificacion = EstadoVerificacion.ERROR,
    viewModel: MarcajeViewModel = viewModel()
) {
    val marcas by viewModel.marcas.collectAsState()
    val sincronizando by viewModel.sincronizando.collectAsState()
    val paso by viewModel.paso.collectAsState()
    val ubicacion by viewModel.ubicacion.collectAsState()
    val foto by viewModel.foto.collectAsState()
    val horaMarca by viewModel.horaMarca.collectAsState()
    val context = LocalContext.current

    // Lanzador del permiso de cámara (sin cambios)
    val lanzadorCamara = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { concedido ->
        viewModel.camaraResuelta(concedido)
        if (!concedido) {
            Toast.makeText(
                context,
                "Se necesita el permiso de cámara para validar tu identidad",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // Lanzador del permiso de ubicación
    val lanzadorUbicacion = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { viewModel.actualizarUbicacion() }

    // Al entrar a la pantalla, pedimos el permiso si falta
    LaunchedEffect(Unit) {
        val concedido = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        if (concedido) viewModel.actualizarUbicacion()
        else lanzadorUbicacion.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    // Cuando el flujo llega al paso de cámara (sin cambios)
    // Cuando el flujo llega al paso de permiso, lo pedimos (o seguimos si ya está concedido)
    LaunchedEffect(paso) {
        if (paso == PasoValidacion.SOLICITANDO_CAMARA) {
            val yaConcedido = ContextCompat.checkSelfPermission(
                context, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
            if (yaConcedido) viewModel.camaraResuelta(true)
            else lanzadorCamara.launch(Manifest.permission.CAMERA)
        }
    }

    MarcajeContent(
        estaConectado = estaConectado,
        nombreFaena = nombreFaena,
        tipoMarca = tipoMarca,
        estadoBluetooth = estadoBluetooth,
        // El GPS ahora refleja la verificación real; si aún no hay lectura, usa el valor recibido
        estadoGps = ubicacion?.estado?.toEstadoVerificacion() ?: estadoGps,
        estadoCamara = estadoCamara,
        horaTarjeta = horaActual(),
        marcas = marcas,
        sincronizando = sincronizando,
        onIniciarValidacion = { viewModel.iniciarValidacion() },
        onSincronizar = { viewModel.sincronizar() },
        ubicacion = ubicacion
    )

    ValidacionMarcajeDialog(
        paso = paso,
        totems = viewModel.totemsDisponibles,
        foto = foto,
        horaMarca = horaMarca,
        onSeleccionarTotem = { viewModel.seleccionarTotem(it) },
        onConfirmarAviso = { viewModel.confirmarAvisoFoto() },
        onFotoTomada = { viewModel.fotoTomada(it) },
        onContinuarFoto = { viewModel.continuarConFoto(horaActual()) },
        onReintentarFoto = { viewModel.reintentarFoto() },
        onContinuarBuenTurno = {
            viewModel.finalizarMarca(
                tipo = tipoMarca,
                fecha = fechaActual(),
                faena = nombreFaena
            )
        },
        onCancelar = { viewModel.cancelarValidacion() }
    )
}

/**
 * Versión sin ViewModel: solo recibe datos y eventos. Es la que se puede previsualizar.
 */
@Composable
fun MarcajeContent(
    estaConectado: Boolean,
    nombreFaena: String,
    tipoMarca: TipoMarca,
    estadoBluetooth: EstadoVerificacion,
    estadoGps: EstadoVerificacion,
    estadoCamara: EstadoVerificacion,
    horaTarjeta: String,
    marcas: List<RegistroMarca>,
    sincronizando: Boolean,
    onIniciarValidacion: () -> Unit,
    onSincronizar: () -> Unit,
    ubicacion: LecturaUbicacion? = null
) {
    val sinConexion = !estaConectado
    val tituloBase = if (tipoMarca == TipoMarca.SALIDA) "Salida por marcar" else "Validar y marcar entrada"
    val titulo = if (sinConexion) "$tituloBase sin conexión" else tituloBase

    val hayPendientes = marcas.any { it.estado == EstadoMarca.PENDIENTE }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Zona azul: conexión + faena
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FaenaActualCard(nombreFaena = nombreFaena)
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            EstadoConexionCard(estaConectado = estaConectado)
            // La alerta se reabre cada vez que llega una lectura nueva
            var alertaVisible by remember(ubicacion) { mutableStateOf(true) }
            AlertaAnomaliaUbicacion(
                visible = ubicacion?.estado == EstadoUbicacion.SIMULADA && alertaVisible,
                onCerrar = { alertaVisible = false }
            )
            TituloSeccion(texto = "Estados de permiso")

            PermisosMarcajeCard(
                estadoBluetooth = estadoBluetooth,
                estadoGps = estadoGps,
                estadoCamara = estadoCamara
            )

            TarjetaMarcaje(
                titulo = titulo,
                hora = horaTarjeta,
                sinConexion = sinConexion,
                onClick = onIniciarValidacion
            )

            val latitud = ubicacion?.latitud
            val longitud = ubicacion?.longitud
            TituloSeccion(texto = "Tu ubicación")
            if (latitud != null && longitud != null) {
                MapaUbicacionCard(latitud = latitud, longitud = longitud)
            } else {
                Text(
                    text = when (ubicacion?.estado) {
                        null -> "Obteniendo ubicación GPS..."
                        EstadoUbicacion.SIN_PERMISO ->
                            "Activa el permiso de ubicación para mostrar el mapa."
                        EstadoUbicacion.SIN_SENAL ->
                            "No se pudo obtener una ubicación. Verifica que el GPS esté activo."
                        EstadoUbicacion.VERIFICADA, EstadoUbicacion.SIMULADA ->
                            "No hay coordenadas disponibles para mostrar el mapa."
                    }
                )
            }

            BotonAccionGradiente(
                texto = "Escanear QR supervisor",
                icono = Icons.Outlined.QrCodeScanner,
                fondo = SmartVoltGradients.SecondaryButton,
                colorContenido = TextoSobreAzul
            )

            BotonAccionGradiente(
                texto = "Modo Offline",
                icono = Icons.Outlined.WifiOff,
                fondo = SmartVoltGradients.MarcajeOffline,
                colorContenido = TextoSobreAmarillo
            )

            // ---- Sección de prueba: marcas guardadas en Room ----
            TituloSeccion(texto = "Marcas guardadas (${marcas.size})")

            if (marcas.isEmpty()) {
                Text(text = "Aún no hay marcas. Toca la tarjeta para registrar una.")
            }

            marcas.forEach { registro ->
                ItemMarcaAsistencia(registro = registro)
            }

            Button(
                onClick = onSincronizar,
                enabled = hayPendientes && !sincronizando,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (sincronizando) "Sincronizando..." else "Sincronizar pendientes")
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

// ---------- Previews (usan datos de ejemplo, sin ViewModel ni Room) ----------

private val marcasEjemplo = listOf(
    RegistroMarca(
        id = "1",
        tipo = TipoMarca.ENTRADA,
        hora = "08:31",
        fecha = "12 de octubre",
        ubicacionFaena = "Obra frente 2",
        estado = EstadoMarca.VALIDADA
    ),
    RegistroMarca(
        id = "2",
        tipo = TipoMarca.ENTRADA_COLACION,
        hora = "13:05",
        fecha = "12 de octubre",
        ubicacionFaena = "Obra frente 2",
        estado = EstadoMarca.PENDIENTE
    )
)

@Preview(showBackground = true, showSystemUi = true, name = "1. Online - Sin marcas")
@Composable
fun MarcajeContentOnlinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeContent(
            estaConectado = true,
            nombreFaena = "Obra frente 2",
            tipoMarca = TipoMarca.ENTRADA,
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.ADVERTENCIA,
            estadoCamara = EstadoVerificacion.ERROR,
            horaTarjeta = "08:30 a.m",
            marcas = emptyList(),
            sincronizando = false,
            onIniciarValidacion = {},
            onSincronizar = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "2. Sin conexión - Con marcas")
@Composable
fun MarcajeContentOfflinePreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeContent(
            estaConectado = false,
            nombreFaena = "Obra frente 2",
            tipoMarca = TipoMarca.ENTRADA,
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.CORRECTO,
            estadoCamara = EstadoVerificacion.CORRECTO,
            horaTarjeta = "08:30 a.m",
            marcas = marcasEjemplo,
            sincronizando = false,
            onIniciarValidacion = {},
            onSincronizar = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "3. Sincronizando")
@Composable
fun MarcajeContentSincronizandoPreview() {
    SmartVoltTheme(dynamicColor = false) {
        MarcajeContent(
            estaConectado = true,
            nombreFaena = "Obra frente 2",
            tipoMarca = TipoMarca.SALIDA,
            estadoBluetooth = EstadoVerificacion.CORRECTO,
            estadoGps = EstadoVerificacion.CORRECTO,
            estadoCamara = EstadoVerificacion.CORRECTO,
            horaTarjeta = "17:30 p.m",
            marcas = marcasEjemplo,
            sincronizando = true,
            onIniciarValidacion = {},
            onSincronizar = {}
        )
    }
}

// ---------- Utilidades ----------

private fun horaActual(): String =
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

private fun fechaActual(): String =
    SimpleDateFormat("d 'de' MMMM", Locale("es")).format(Date())
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/PerfilView.kt`

```kotlin
package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartvolt.model.domain.DatosPerfil
import com.example.smartvolt.ui.components.encabezados.Header
import com.example.smartvolt.ui.components.perfil.AvatarPerfil
import com.example.smartvolt.ui.components.perfil.CampoDatoPerfil
import com.example.smartvolt.ui.theme.AzulCorporativo
import com.example.smartvolt.ui.theme.AzulRey
import com.example.smartvolt.ui.theme.FondoPrincipal
import com.example.smartvolt.ui.theme.SmartVoltTheme
import com.example.smartvolt.ui.theme.Superficie
import com.example.smartvolt.ui.theme.TextoPrincipal

@Composable
fun PerfilView(
    datos: DatosPerfil = DatosPerfil(),
    onEditarFoto: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
    ) {
        // Zona azul: mismo Header de las demás pantallas, solo con título
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AzulRey)
                .statusBarsPadding()
                .padding(bottom = 24.dp)
        ) {
            Header(
                saludo = "Mi perfil",
                fecha = null,
                mostrarNotificaciones = false
            )
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Superficie),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // TODO: pasar imagen = painterResource(R.drawable.tu_avatar) cuando agregues la imagen
                    AvatarPerfil(onEditar = onEditarFoto)

                    Text(
                        text = "Tus datos",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoPrincipal
                    )

                    CampoDatoPerfil(texto = datos.nombre)
                    CampoDatoPerfil(texto = datos.apellido)
                    CampoDatoPerfil(texto = datos.rut)
                    CampoDatoPerfil(texto = datos.telefono)
                    CampoDatoPerfil(texto = datos.correo)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = buildAnnotatedString {
                            append("Para cambiar tus datos personales,\n")
                            withStyle(SpanStyle(color = AzulCorporativo)) {
                                append("contacta al administrador")
                            }
                        },
                        fontSize = 13.sp,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Center,
                        color = TextoPrincipal
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilViewPreview() {
    SmartVoltTheme(dynamicColor = false) {
        PerfilView()
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/ui/view/SplashScreen.kt`

```kotlin
package com.example.smartvolt.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartvolt.model.navigation.Destinos
import com.example.smartvolt.ui.theme.AmarilloPrincipal
import com.example.smartvolt.ui.theme.SmartVoltGradients
import com.example.smartvolt.ui.theme.TextoSobreAzul
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Temporizador de 3 segundos antes de navegar al Login
    LaunchedEffect(key1 = true) {
        delay(3000) // 3000 ms (3 segundos)
        navController.navigate(route = Destinos.Login.ruta) {
            // Elimina la pantalla de Splash/Inicio del historial para no volver a ella con el botón "Atrás"
            popUpTo(route = Destinos.Inicio.ruta) { inclusive = true }
        }
    }

    // Diseño del Splash basado en el mockup y la estructura de la clase
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = SmartVoltGradients.LoginBackground), // Color corporativo del proyecto
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            // Logo SMART (blanco) + VOLT (amarillo)
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = TextoSobreAzul)) { append("SMART") }
                    withStyle(SpanStyle(color = AmarilloPrincipal)) { append("VOLT") }
                },
                fontSize = 44.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(72.dp))
            Text(
                text = "Bienvenido a SmartVolt",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = TextoSobreAzul
            )
            Spacer(modifier = Modifier.height(72.dp))
            Text(
                text = "~Tu control de\nasistencia preferido~",
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = TextoSobreAzul.copy(alpha = 0.8f)
            )
            // El mockup no muestra indicador de carga. Si lo quieren, descomenten:
            Spacer(modifier = Modifier.height(32.dp))
            CircularProgressIndicator(color = TextoSobreAzul)
        }
    }
}
```

---

## `app/src/main/java/com/example/smartvolt/viewmodel/AsistenciaViewModel.kt`

```kotlin
package com.example.smartvolt.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.model.local.database.SmartVoltDatabase
import com.example.smartvolt.model.repository.MarcaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
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
}
```

---

## `app/src/main/java/com/example/smartvolt/viewmodel/MarcajeViewModel.kt`

```kotlin
package com.example.smartvolt.viewmodel


import com.example.smartvolt.geo.UbicacionProvider
import com.example.smartvolt.model.domain.LecturaUbicacion
import com.example.smartvolt.model.domain.PasoValidacion
import com.example.smartvolt.model.domain.Totem
import kotlinx.coroutines.Job
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartvolt.model.domain.RegistroMarca
import com.example.smartvolt.model.domain.TipoMarca
import com.example.smartvolt.model.local.database.SmartVoltDatabase
import com.example.smartvolt.model.local.temporal.FotoTemporalStorage
import com.example.smartvolt.model.repository.MarcaRepository
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
```

---

