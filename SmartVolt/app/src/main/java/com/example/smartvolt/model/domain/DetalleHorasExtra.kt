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