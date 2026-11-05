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