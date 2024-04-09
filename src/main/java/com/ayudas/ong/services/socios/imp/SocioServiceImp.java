package com.ayudas.ong.services.socios.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.config.modelMapper.converters.SocioDTOConvert;
import com.ayudas.ong.repositories.SocioRepository;
import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTOcrear;
import com.ayudas.ong.services.rol.imp.RolServiceImpPriv;
import com.ayudas.ong.services.sede.SedeServicesPriv;
import com.ayudas.ong.services.socios.SocioServices;
import com.ayudas.ong.util.exceptions.data_access.ManagerAccessExcp;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SocioServiceImp implements SocioServices {

    private final SocioRepository socioRepository;
    private final SocioDTOConvert socioDTOConvert;
    private final RolServiceImpPriv rolServiceImpPriv;
    private final SedeServicesPriv sedeServicesPriv;
    private final SocioServicePrivImp socioServicePrivImp;

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
    public SocioDTO crear(SocioDTOcrear socioDTOcrear) throws ManagerAccessExcp {

        Socio socio = socioServicePrivImp.findByCedula(socioDTOcrear.getCedula());

        System.out.println(socio);

        if(socio != null) {
            throw new ManagerAccessExcp("Socio existente", new Throwable(" El socio que se intenta crear, ya existe"));
        }
        else {
            socioDTOcrear.setRol(socioDTOcrear.getRol().toUpperCase());

            Rol rol = rolServiceImpPriv.findByNombre(socioDTOcrear.getRol());
            Sede sede = sedeServicesPriv.findByNombre(socioDTOcrear.getSede());

            if(sede == null) {
                throw new ManagerAccessExcp("Dato no encontrado", new Throwable(" ( Sede ) " + socioDTOcrear.getSede() + " no se encuentra registrada"));
            }
            if(rol == null) {
                throw new ManagerAccessExcp("Dato no encontrado", new Throwable(" ( Rol ) " + socioDTOcrear.getRol() + " no se encuentra registrada"));
            }

            System.out.println(sede.toString());
            
            return socioDTOConvert.socioToDTO(
                    socioRepository.save(socioDTOConvert.socioDtoCrearToEntity(socioDTOcrear, rol, sede)));
        }

    }

}
