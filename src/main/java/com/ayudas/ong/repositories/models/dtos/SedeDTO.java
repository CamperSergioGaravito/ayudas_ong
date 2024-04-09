package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SedeDTO implements Serializable {

    private String nombre;

    private List<SocioDTO> socios;

    private CiudadDTO ciudad;

    private List<VoluntarioDTO> voluntarios;

    private String direccion;

    private DirectorDTO director;

    private List<EnvioDTO> enviosAyudas;
    
}
