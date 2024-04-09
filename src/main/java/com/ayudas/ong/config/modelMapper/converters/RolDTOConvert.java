package com.ayudas.ong.config.modelMapper.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.models.dtos.RolDTO;

@Component
public class RolDTOConvert {
    
    @Autowired
    ModelMapper model;

    public RolDTO RolToDTO(Rol rol) {
        RolDTO rolDTO = model.map(rol, RolDTO.class);

        return rolDTO;
    }

    public Rol RolDtoToEntity(RolDTO rolDTO) {
        Rol rol = model.map(rolDTO, Rol.class);

        return rol;
    }

}
