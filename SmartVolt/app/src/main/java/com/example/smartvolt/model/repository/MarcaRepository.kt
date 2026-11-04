package com.example.smartvolt.model.repository

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
}