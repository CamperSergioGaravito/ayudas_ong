package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class ItemDTO implements Serializable {

    private EnvioDTO envio;

    private AyudaDTO item;

    private long cantidad;
    
}
