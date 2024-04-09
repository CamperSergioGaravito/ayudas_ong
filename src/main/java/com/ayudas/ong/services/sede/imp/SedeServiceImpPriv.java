package com.ayudas.ong.services.sede.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.repositories.SedeRepository;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.services.sede.SedeServicesPriv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SedeServiceImpPriv implements SedeServicesPriv {

    private final SedeRepository sedeRepository;

    @Override
    public List<Sede> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Sede findById(final Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Sede findByNombre(final String nombre) {
        return sedeRepository.findByNombre(nombre);
    }
    
}
