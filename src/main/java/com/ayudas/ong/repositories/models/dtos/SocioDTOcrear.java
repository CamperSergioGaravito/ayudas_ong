package com.ayudas.ong.repositories.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocioDTOcrear {

    private long cedula;

    private String p_nombre;

    private String s_nombre;

    private String p_apellido;
    
    private String s_apellido;

    private String rol;

    private String email;

    private String passWord;

    private Long cuentaBancaria;

    private String sede;

}
