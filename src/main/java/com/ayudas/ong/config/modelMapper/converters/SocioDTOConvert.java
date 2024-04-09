package com.ayudas.ong.config.modelMapper.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTOcrear;

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

    public Socio socioCargarDataDtoCrear(Socio socio, SocioDTOcrear socioDTOcrear, Rol rol, Sede sede) {

        socio.setCuentaBancaria(socioDTOcrear.getCuentaBancaria());
        socio.setEmail(socioDTOcrear.getEmail());
        socio.setP_nombre(socioDTOcrear.getP_apellido());
        socio.setS_nombre(socioDTOcrear.getS_nombre());
        socio.setP_apellido(socioDTOcrear.getP_apellido());
        socio.setS_apellido(socioDTOcrear.getS_apellido());
        socio.setPassWord(socioDTOcrear.getPassWord());
        

        return socio;

    }

}
