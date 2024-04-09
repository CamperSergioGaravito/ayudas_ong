package com.ayudas.ong.services.socios.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.repositories.SocioRepository;
import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.services.socios.SocioServicesPriv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SocioServicePrivImp implements SocioServicesPriv {

    private final SocioRepository socioRepository;

    @Override
    public List<Socio> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Socio findById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Socio findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public Socio findByCedula(long cedula) {
        return socioRepository.findByCedula(cedula);
    }
    
}
