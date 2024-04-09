package com.ayudas.ong.services.rol.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.config.modelMapper.converters.RolDTOConvert;
import com.ayudas.ong.repositories.RolRepository;
import com.ayudas.ong.repositories.enums.Roles;
import com.ayudas.ong.repositories.models.dtos.RolDTO;
import com.ayudas.ong.repositories.models.dtos.RolDTOcrear;
import com.ayudas.ong.services.rol.RolServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RolServiceImp implements RolServices {

    private final RolRepository rolRepository;
    private final RolDTOConvert rolDTOConvert;

    @Override
    public List<RolDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public RolDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public RolDTO crear(RolDTOcrear rolDTOcrear) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public RolDTO save(RolDTO rolDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public RolDTO update(Long id, RolDTO rolDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public RolDTO findByNombre(String nombre) {
        return rolDTOConvert.RolToDTO(rolRepository.findByNombre(Roles.valueOf(nombre)));
    }
    
}
