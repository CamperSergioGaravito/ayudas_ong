package com.ayudas.ong.config.modelMapper.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTOcrear;
import com.ayudas.ong.repositories.models.dtos.SocioDTOupdate;

@Component
public class SocioDTOConvert {

    @Autowired
    ModelMapper model;

    @Autowired
    RolDTOConvert rolDTOConvert;

    public SocioDTO socioToDTO(Socio socio) {
        SocioDTO socioDTO = model.map(socio, SocioDTO.class);
        socioDTO.setRol(
                rolDTOConvert.RolToDTO(socio.getRol()));
        
        socioDTO.setSede(socio.getSede().getNombre());

        return socioDTO;
    }

    public Socio SocioDtoToEntity(SocioDTO socioDTO) {
        Socio socio = model.map(socioDTO, Socio.class);
        socio.setRol(
                rolDTOConvert.RolDtoToEntity(socioDTO.getRol()));

        return socio;
    }

    public Socio socioDtoCrearToEntity(SocioDTOcrear socioDTOcrear, Rol rol, Sede sede) {
        Socio socio = model.map(socioDTOcrear, Socio.class);
        socio.setRol(rol);
        socio.setSede(sede);

        return socio;
    }

    public Socio socioCargarDataDtoUpdate(Socio socio, SocioDTOupdate socioDTOupdate) {

        socio.setCuentaBancaria(socioDTOupdate.getCuentaBancaria());
        socio.setEmail(socioDTOupdate.getEmail());
        socio.setP_nombre(socioDTOupdate.getP_nombre());
        socio.setS_nombre(socioDTOupdate.getS_nombre());
        socio.setP_apellido(socioDTOupdate.getP_apellido());
        socio.setS_apellido(socioDTOupdate.getS_apellido());

        return socio;

    }

}
