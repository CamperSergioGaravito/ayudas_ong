package com.ayudas.ong.services.sede;

import java.util.List;

import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.SedeDTOcrear;

public interface SedeServices {

    List<Sede> findAll();

    Sede findById(final Long id);

    Sede crear(final SedeDTOcrear sedeDTOcrear);

    Sede save(final SedeDTO sedeDTO);

    Sede update(final Long id, final SedeDTO sedeDTO);

    void delete(final Long id);

    Sede findByNombre(final String nombre);

}
