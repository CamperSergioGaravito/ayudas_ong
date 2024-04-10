package com.ayudas.ong.components.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Ciudad;
import com.ayudas.ong.repositories.entities.Director;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.SedeDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.SedeDTOcrear;
import com.ayudas.ong.repositories.models.dtos.para_anidar.SedeDTOmostrar;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SedeConverter {

    private final ModelMapper model;
    private final SocioDTOConvert socioDTOConvert;

    public SedeDTO entityToDto(Sede sede) {
        SedeDTO sedeDTO = model.map(sede, SedeDTO.class);
        sedeDTO.setCiudad(sede.getCiudad().getNombre());
        Director director = sede.getDirector();

        String nombre = director.getP_nombre().concat(" ")
                .concat(director.getS_nombre()).concat(" ")
                .concat(director.getP_apellido()).concat(" ")
                .concat(director.getS_apellido());

        sedeDTO.setDirector(nombre);

        sedeDTO.setSocios(
            sede.getSocios().stream()
            .map(socio -> socioDTOConvert.socioToDTO(socio)).toList()
        );

        /* sedeDTO.setVoluntarios(
            sede.getVoluntarios().stream()
            .map(voluntario -> )
        ); */

        return sedeDTO;
    }

    public Sede dtoCrearToEntity(SedeDTOcrear sedeDTOcrear, Director director, Ciudad ciudad) {
        Sede sede = model.map(sedeDTOcrear, Sede.class);
        sede.setDirector(director);
        sede.setCiudad(ciudad);

        return sede;
    }

    public Sede updateEntityDtoUpdate(Sede sede, SedeDTOupdate sedeDTOupdate, Director director, Ciudad ciudad){
        sede.setNombre(sedeDTOupdate.getNombre());
        sede.setCiudad(ciudad);
        sede.setDireccion(sedeDTOupdate.getDireccion());
        sede.setDirector(director);

        return sede;
    }

    public SedeDTOmostrar entityToDtoMostrar(Sede sede) {
        SedeDTOmostrar sedeDTOmostrar = model.map(sede, SedeDTOmostrar.class);

        sedeDTOmostrar.setSocios(
            sede.getSocios().stream()
            .map(socio -> socio.getP_nombre().concat(" ")
            .concat(socio.getS_nombre()).concat(" ")
            .concat(socio.getP_apellido()).concat(" ")
            .concat(socio.getS_apellido())
            ).toList()
        );

        sedeDTOmostrar.setVoluntarios(
            sede.getVoluntarios().stream()
            .map(
                voluntario -> voluntario.getP_nombre().concat(" ")
                .concat(voluntario.getS_nombre()).concat(" ")
                .concat(voluntario.getP_apellido()).concat(" ")
                .concat(voluntario.getS_apellido())
            ).toList()
        );

        sedeDTOmostrar.setCiudad(sede.getCiudad().getNombre());

        sedeDTOmostrar.setDirector(sede.getDirector().getP_nombre().concat(" ")
            .concat(sede.getDirector().getS_nombre())
        );

        return sedeDTOmostrar;
    }

}
