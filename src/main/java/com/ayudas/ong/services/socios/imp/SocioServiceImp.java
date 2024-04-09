package com.ayudas.ong.services.socios.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.config.modelMapper.converters.SocioDTOConvert;
import com.ayudas.ong.repositories.SocioRepository;
import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.repositories.models.dtos.RolDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTOcrear;
import com.ayudas.ong.services.rol.RolServices;
import com.ayudas.ong.services.socios.SocioServices;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SocioServiceImp implements SocioServices {

    private final SocioRepository socioRepository;
    private final SocioDTOConvert socioDTOConvert;
    private final RolServices rolServices;

    @Override
    public List<SocioDTO> findAll() {
        List<SocioDTO> sDtos = new ArrayList<>();
        for(Socio socio : socioRepository.findAll()) {
            sDtos.add(socioDTOConvert.socioToDTO(socio));
        }
        return sDtos;
    }

    @Override
    public SocioDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Transactional
    @Override
    public SocioDTO save(SocioDTO socioDTO) {
        return socioDTOConvert.socioToDTO(
                socioRepository.save(
                        socioDTOConvert.SocioDtoToEntity(socioDTO)));
    }

    @Override
    public SocioDTO update(Long id, SocioDTO socioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public SocioDTO findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Transactional
    @Override
    public SocioDTO crear(SocioDTOcrear socioDTOcrear) {
        RolDTO rolDTO = rolServices.findByNombre(socioDTOcrear.getRol());
        Socio socio = socioDTOConvert.socioDtoCrearToEntity(socioDTOcrear, rolDTO);
        return socioDTOConvert.socioToDTO(
                socioRepository.save(socio));
    }

}
