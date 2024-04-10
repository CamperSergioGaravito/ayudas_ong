package com.ayudas.ong.services.sede.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.SedeRepository;
import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.SedeDTOcrear;
import com.ayudas.ong.services.sede.SedeServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SedeServiceImpl implements SedeServices {

    private final SedeRepository sedeRepository;

    @Transactional(readOnly = true)
    @Override
    public List<SedeDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional
    @Override
    public SedeDTO crear(final SedeDTOcrear sedeDTOcrear) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Transactional
    @Override
    public SedeDTO save(final SedeDTO sedeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Transactional
    @Override
    public SedeDTO update(final Long id, final SedeDTO sedeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Transactional
    @Override
    public void delete(final Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Transactional(readOnly = true)
    @Override
    public SedeDTO findByNombre(final String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }
    
}
