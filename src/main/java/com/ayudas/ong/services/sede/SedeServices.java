package com.ayudas.ong.services.sede;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.SedeDTOcrear;

public interface SedeServices {

    List<SedeDTO> findAll();

    SedeDTO crear(final SedeDTOcrear sedeDTOcrear);

    SedeDTO save(final SedeDTO sedeDTO);

    SedeDTO update(final Long id, final SedeDTO sedeDTO);

    void delete(final Long id);

    SedeDTO findByNombre(final String nombre);

}
