package com.ayudas.ong.repositories.models.dtos;

import java.util.List;

public class SocioDTO extends PersonaDTO {
    private Long cuentaBancaria;

    private SedeDTO sede;

    private List<IngresoDTO> ingresos;
}
