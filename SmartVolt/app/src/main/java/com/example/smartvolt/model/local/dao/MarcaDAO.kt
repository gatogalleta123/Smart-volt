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