package com.ayudas.ong.repositories.models.dtos;

import com.ayudas.ong.repositories.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {
    
    private Roles nombre;
    
    private String descripcion;
        
}
