package com.ayudas.ong.repositories.models.dtos;

import com.ayudas.ong.repositories.enums.Disponibilidad;
import com.ayudas.ong.repositories.enums.TipoVoluntario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class VoluntarioDTO extends PersonaDTO {

    private TipoVoluntario tipo;

    private ProfesionDTO profesion;

    private Disponibilidad disponibilidad;

    private int cantParticipacion;

    private SedeDTO sede;
    
}
