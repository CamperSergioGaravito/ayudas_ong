package com.ayudas.ong.repositories.models.dtos;

import com.ayudas.ong.repositories.enums.TipoVoluntario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter @Setter
public class VoluntarioAdminDTO extends PersonaDTO{

    private TipoVoluntario tipo;
    private String sede;

    public VoluntarioAdminDTO() {
        super(); // Llama al constructor de la clase padre si es necesario
    }
}
