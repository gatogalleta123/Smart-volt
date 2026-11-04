package com.example.smartvolt.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smartvolt.model.EstadoMarca
import com.example.smartvolt.model.RegistroMarca
import com.example.smartvolt.model.TipoMarca

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