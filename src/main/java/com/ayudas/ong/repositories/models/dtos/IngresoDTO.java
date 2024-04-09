package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.ayudas.ong.repositories.enums.TiposCuenta;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class IngresoDTO implements Serializable {

    private SocioDTO socio;

    private TiposCuenta tipoCuenta;

    private double cuota;

    private LocalDate fechaPago;
}
