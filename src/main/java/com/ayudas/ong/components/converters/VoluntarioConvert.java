package com.ayudas.ong.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Voluntario;
import com.ayudas.ong.repositories.models.dtos.VoluntarioAdminDTO;
import com.ayudas.ong.repositories.models.dtos.VoluntarioDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class VoluntarioConvert {

    private final ModelMapper model;

    public VoluntarioAdminDTO VoluntarioAdminToDTO(Voluntario socio) {
        VoluntarioAdminDTO socioDTO = model.map(socio, VoluntarioAdminDTO.class);
        socioDTO.setSede(socio.getSede().getNombre());
        return socioDTO;
    }

    public VoluntarioDTO VoluntarioToDTO(Voluntario socio) {
        VoluntarioDTO socioDTO = model.map(socio, VoluntarioDTO.class);
        socioDTO.setSede(socio.getSede().getNombre());
        return socioDTO;
    }

    
    
}
