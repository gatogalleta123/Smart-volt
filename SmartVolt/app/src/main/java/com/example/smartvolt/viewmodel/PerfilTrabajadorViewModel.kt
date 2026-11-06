package com.example.smartvolt.viewmodel

import androidx.lifecycle.ViewModel
import com.example.smartvolt.model.domain.DatosTrabajador
import com.example.smartvolt.model.domain.DiaSemana
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PerfilTrabajadorViewModel : ViewModel() {

    private val _datos = MutableStateFlow(DatosTrabajador())
    val datos: StateFlow<DatosTrabajador> = _datos.asStateFlow()

    init {
        cargarDatos()
    }


    private fun cargarDatos() {
        _datos.value = DatosTrabajador(
            rut = "11.111.111-1",
            nombreCompleto = "Juan Pérez González",
            cargo = "Operario",
            areaTrabajo = "Obras civiles",
            tipoContrato = "Indefinido",
            horasSemanales = 45,
            diasJornada = setOf(
                DiaSemana.LUNES,
                DiaSemana.MARTES,
                DiaSemana.MIERCOLES,
                DiaSemana.JUEVES,
                DiaSemana.VIERNES
            ),
            fechaIngreso = "15/03/2024",
            sueldoBruto = 850_000L,
            sueldoLiquido = 723_400L
        )
    }
}