package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SedeDTOcrear implements Serializable {

    private String nombre;

    private List<Long> socios;

    private String ciudad;

    private List<Long> voluntarios;

    private String direccion;

    private String director;

    private List<Long> enviosAyudas;
    
}
