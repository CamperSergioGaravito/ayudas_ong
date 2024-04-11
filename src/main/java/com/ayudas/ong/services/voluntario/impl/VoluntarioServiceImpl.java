package com.ayudas.ong.services.voluntario.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.components.converters.VoluntarioConvert;
import com.ayudas.ong.repositories.VoluntarioRepository;
import com.ayudas.ong.repositories.entities.Voluntario;
import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.models.dtos.VoluntarioAdminDTO;
import com.ayudas.ong.repositories.models.dtos.VoluntarioDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.VoluntarioDTOcrear;
import com.ayudas.ong.services.voluntario.VoluntarioServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VoluntarioServiceImpl implements VoluntarioServices{
    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioConvert voluntarioConvert;

    @Override
    public List<VoluntarioAdminDTO> findAllAdministrativos(TipoVoluntario tipo) {
        return voluntarioRepository.findByTipo(tipo)
        .stream().map(
            voluntario -> voluntarioConvert.VoluntarioAdminToDTO(voluntario)
        ).toList();
    }

    @Override
    public List<VoluntarioDTO> findAllSanitarios(TipoVoluntario tipo) {
        return voluntarioRepository.findByTipo(tipo)
        .stream().map(
            voluntario -> voluntarioConvert.VoluntarioToDTO(voluntario)
        ).toList();
    }

    @Override
    public VoluntarioDTO crear(VoluntarioDTOcrear VoluntarioDTOcrear) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public VoluntarioDTO save(VoluntarioDTO VoluntarioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public VoluntarioDTO update(Long cedula, VoluntarioDTOupdate VoluntarioDTOupdate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public VoluntarioDTO findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public VoluntarioDTO findByCedula(long cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCedula'");
    }

    
}
