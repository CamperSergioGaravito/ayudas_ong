package com.ayudas.ong.config.modelMapper.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.repositories.models.dtos.RolDTO;
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

        return socioDTO;
    }

    public Socio SocioDtoToEntity(SocioDTO socioDTO) {
        Socio socio = model.map(socioDTO, Socio.class);
        socio.setRol(
                rolDTOConvert.RolDtoToEntity(socioDTO.getRol()));

        return socio;
    }

    public Socio socioDtoCrearToEntity(SocioDTOcrear socioDTOcrear, RolDTO rolDTO) {
        Socio socio = new Socio();
        socio.setRol(
                rolDTOConvert.RolDtoToEntity(rolDTO));

        socio.setCedula(socioDTOcrear.getCedula());
        socio.setEmail(socioDTOcrear.getEmail());
        socio.setP_nombre(socioDTOcrear.getP_nombre());
        socio.setS_nombre(socioDTOcrear.getS_nombre());
        socio.setP_apellido(socioDTOcrear.getP_apellido());
        socio.setS_apellido(socioDTOcrear.getS_apellido());
        

        return socio;
    }

}
