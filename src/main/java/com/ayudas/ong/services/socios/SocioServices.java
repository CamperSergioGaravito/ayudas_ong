package com.ayudas.ong.services.socios;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTOcrear;

public interface SocioServices {

    List<SocioDTO> findAll();

    SocioDTO findById(final Long id);

    SocioDTO crear(final SocioDTOcrear socioDTOcrear);

    SocioDTO save(final SocioDTO socioDTO);

    SocioDTO update(final Long id, final SocioDTO socioDTO);

    void delete(final Long id);

    SocioDTO findByEmail(final String email);
    
}
