# SmartVolt 🔋

Aplicación móvil Android para el **control de asistencia antifraude y gestión offline en faenas de construcción**. Permite a los trabajadores registrar su entrada y salida de jornada, validar su presencia física mediante balizas Bluetooth (BLE) y tótems de faena, y mantener las marcas guardadas localmente cuando no hay conectividad.

> **Proyecto en Android Studio/Kotlin** · Asignatura DSY1105 · Desarrollo de Aplicaciones Móviles
> Caso propuesto por el Servicio de Ingeniería Smart-Volt SpA.
> Este repositorio corresponde a un **MVP de simulación**, no a una aplicación lista para lanzamiento comercial.


---

## Problema que resuelve

Los métodos actuales de registro de asistencia en faena (planillas firmadas a mano o apps que usan el GPS del celular) pueden ser vulnerados con software de simulación de ubicación (*Fake GPS* / *Mock Locations*) o por suplantación entre compañeros de cuadrilla. Esto genera pagos indebidos de horas extra y dificulta la planificación diaria de las jornadas.

SmartVolt propone validar la presencia física real del trabajador combinando:

- Detección de **tótems / balizas BLE** instalados en la faena.
- **Verificación de identidad** mediante foto.
- **Ubicación GPS** y estado de permisos del dispositivo.
- **Persistencia local** (Room) para operar sin conexión y sincronizar después.

## Funcionalidades

| Pantalla | Descripción |
|---|---|
| **Splash** | Pantalla de bienvenida con redirección automática al login. |
| **Login** | Formulario de acceso de trabajador (autenticación simulada). |
| **Inicio** | Saludo, botón de asistencia, avisos y estado de la jornada del día. |
| **Asistencia** | Últimas marcas, resumen mensual de asistencias, calendario y horas extra por jornada (aprobadas, pendientes, rechazadas). |
| **Marcaje** | Estado de conexión, faena asignada, estado de permisos (Bluetooth, GPS, cámara), flujo de validación con tótems y registro de marcas. |
| **Perfil** | Datos personales del trabajador en modo lectura. |
| **Menú** | Pendiente de implementación. |

### Flujo de marcaje (entrada)

1. El usuario toca la tarjeta **"Validar y marcar entrada"**.
2. La app busca tótems cercanos (simulado).
3. El usuario elige un tótem de la lista.
4. Se solicita el permiso de cámara para confirmar identidad.
5. Se confirma la foto (pendiente de implementar la captura real).
6. La marca se guarda localmente con estado **PENDIENTE**.
7. Al sincronizar, el servidor la confirma y pasa a **VALIDADA**.

Cuando no hay conexión, la marca queda en la base local y se sube cuando el dispositivo vuelve a estar en línea.

## Estado actual del MVP

Para ser transparentes sobre el alcance de esta versión:

**Implementado**
- Navegación completa entre pantallas con `Navigation Compose` y barra inferior.
- Interfaz según el mockup, con Material Design 3 y tema corporativo propio.
- Persistencia local de marcas con Room (`MarcaDao`, `MarcaEntity`, `SmartVoltDatabase`).
- Repositorio con marcas pendientes y sincronización simulada.
- Preferencias de sesión con DataStore (`PreferenciasSesion`).
- Solicitud de permiso de cámara en tiempo de ejecución.
- Componentes reutilizables: tarjetas de asistencia, calendario, resumen mensual, horas extra, permisos, marcaje.
- Sistema de Geolocalización de GPs

**Simulado / con datos ficticios**
- Autenticación (el botón de ingreso solo navega a Inicio).
- Lista de tótems y su búsqueda BLE.
- Estado de permisos y de conexión.
- Historial de asistencias, horas extra y calendario (datos de ejemplo).
- Envío al servidor (`enviarAlServidor` devuelve `true` tras una espera de 1,5 s).

**Pendiente**
- Escaneo BLE real de balizas (UUIDs) y validación de proximidad.
- Verificación de ubicación con geofencing sobre perímetros de faena.
- Detección de Mock Locations / modo desarrollador.
- Captura real de foto para validación de identidad.
- Integración con backend (Retrofit + API REST / Spring Boot).
- Vista del supervisor (`InicioSupervisorView`, vacía).

## Tecnologías

- **Lenguaje:** Kotlin
- **UI:** Jetpack Compose, Material Design 3
- **Arquitectura:** MVVM (ViewModel + StateFlow)
- **Persistencia:** Room (SQLite) y DataStore Preferences
- **Navegación:** Navigation Compose
- **Concurrencia:** Kotlin Coroutines y Flow
- **Permisos:** Accompanist Permissions y Activity Result API
- **Mapas :** osmdroid, Mapbox
- **Planificado:** Retrofit, Spring Boot (backend), BLE y geolocalización nativa

## Arquitectura

```
┌──────────────────────────────────────────────┐
│                    UI                        │
│  ui/view (pantallas)  ui/components (piezas) │
└───────────────┬──────────────────────────────┘
                │ StateFlow / eventos
┌───────────────▼──────────────────────────────┐
│               ViewModel                      │
│        viewmodel/MarcajeViewModel            │
└───────────────┬──────────────────────────────┘
                │
┌───────────────▼──────────────────────────────┐
│             Repository                       │
│        model/repository/MarcaRepository     │
└──────┬──────────────────────────────┬────────┘
       │                              │
┌──────▼───────────┐        ┌─────────▼────────┐
│  Room (local)    │        │  API REST        │
│  MarcaDao/Entity │        │  (pendiente)     │
└──────────────────┘        └──────────────────┘
```

Los modelos de dominio (`model/domain`) son independientes de la base de datos; las conversiones entre `MarcaEntity` y `RegistroMarca` están en `MarcaEntity.kt`.

## Estructura del proyecto

```
app/src/main/java/com/example/smartvolt/
├── MainActivity.kt              # Punto de entrada y NavHost raíz
├── geo/                         # Mapa y ubicación (en desarrollo)
├── model/
│   ├── domain/                  # Modelos de negocio (RegistroMarca, Totem, EstadoPermisos…)
│   ├── local/
│   │   ├── dao/                 # MarcaDao
│   │   ├── database/            # SmartVoltDatabase
│   │   ├── entity/              # MarcaEntity
│   │   └── preferences/         # PreferenciasSesion (DataStore)
│   ├── navigation/              # Destinos y barra inferior
│   └── repository/              # MarcaRepository
├── ui/
│   ├── components/              # Componentes reutilizables por dominio
│   │   ├── asistencia/  avisos/  botones/  calendario/  conexion/
│   │   ├── encabezados/  horasextra/  marcaje/  perfil/  permisos/
│   ├── theme/                   # Color, Type, Theme, SmartVoltGradients
│   └── view/                    # Pantallas (Login, Inicio, Asistencia, Marcaje, Perfil…)
└── viewmodel/
    └── MarcajeViewModel.kt
```

## Requisitos

- **Android Studio** (versión reciente con soporte para Jetpack Compose)
- **JDK 17** o superior
- Dispositivo Android o emulador con **API 24+** (minSdk según el código de `CalendarioAsistenciaDialog`; verificar en `build.gradle.kts`)
- Para pruebas reales de marcaje: dispositivo físico con **Bluetooth**, **GPS** y **cámara**

## Instalación y ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/<usuario>/<repositorio>.git
cd <repositorio>

# 2. Abrir la carpeta en Android Studio
#    File > Open > seleccionar la carpeta raíz del proyecto

# 3. Esperar a que termine el "Gradle Sync"

# 4. Ejecutar la app
#    Run > Run 'app'   (o Shift + F10)
```

Para generar el APK de compilación de depuración desde terminal:

```bash
./gradlew assembleDebug
```


## Datos de prueba

El proyecto utiliza **datos ficticios** en todas sus pantallas. No contiene bases de datos reales, nombres reales, credenciales, RUT ni datos personales de trabajadores.

Los tótems de prueba están definidos en `MarcajeViewModel`:

| ID | Nombre |
|----|--------|
| 1 | Totem Obra 2 |
| 2 | Totem Obra 3 |
| 3 | Totem Obra 6 |


## Protección de datos

El desarrollo se rige por el anexo de requerimiento del caso, que exige:

- Uso exclusivo de datos **ficticios, sintéticos o anonimizados**.
- Cumplimiento de la **Ley N.º 21.719** y la **Ley N.º 19.628** de protección de datos personales en Chile.
- Permisos de cámara y ubicación **simulados o probados sin capturar datos reales** de personas.

## Equipo

| Integrantes | 
|---|---|
| Santiago Esteva | 
| Marco Calfucura | 


## Licencia

Proyecto con fines académicos. Usar solamente dentro de Duoc!.
