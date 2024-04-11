package com.ayudas.ong.services.voluntario.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.components.converters.VoluntarioConvert;
import com.ayudas.ong.repositories.VoluntarioRepository;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Voluntario;
import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.models.dtos.VoluntarioAdminDTO;
import com.ayudas.ong.repositories.models.dtos.VoluntarioDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioAdminDTOupdate;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.VoluntarioDTOcrear;
import com.ayudas.ong.services.sede.SedeServicesPriv;
import com.ayudas.ong.services.voluntario.VoluntarioServices;
import com.ayudas.ong.util.exceptions.data_access.ManagerAccessExcp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VoluntarioServiceImpl implements VoluntarioServices {

    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioConvert voluntarioConvert;

    private final SedeServicesPriv sedeServicesPriv;

    @Override
    public List<VoluntarioAdminDTO> findAllAdministrativos(TipoVoluntario tipo) {
        return voluntarioRepository.findByTipo(tipo)
                .stream().map(
                        voluntario -> voluntarioConvert.VoluntarioAdminToDTO(voluntario))
                .toList();
    }

    @Override
    public List<VoluntarioDTO> findAllSanitarios(TipoVoluntario tipo) {
        return voluntarioRepository.findByTipo(tipo)
                .stream().map(
                        voluntario -> voluntarioConvert.VoluntarioToDTO(voluntario))
                .toList();
    }

    @Override
    public VoluntarioDTO crear(VoluntarioDTOcrear VoluntarioDTOcrear) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public VoluntarioDTO save(VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = voluntarioRepository.findByCedula(voluntarioDTO.getCedula());
        voluntario.setSede(null);
        return voluntarioConvert.VoluntarioToDTO2(voluntarioRepository.save(voluntario));
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

    @Override
    public VoluntarioAdminDTO updateAdmin(VoluntarioAdminDTOupdate voluntarioAdminDTOupdate, long cedula) throws ManagerAccessExcp {
        if (TipoVoluntario.exists(voluntarioAdminDTOupdate.getTipo())) {
            Sede sede = sedeServicesPriv.findByNombre(voluntarioAdminDTOupdate.getSede());

            if (sede == null) {
                throw new ManagerAccessExcp("Sede inexistente",
                        new Throwable("La sede " + voluntarioAdminDTOupdate.getSede() + " no existe"));
            }

            Voluntario voluntario = voluntarioRepository.findByCedula(cedula);
            return voluntarioConvert.entityToVoluntarioAdminDTO(
                    voluntarioRepository.save(
                            voluntarioConvert.dtoAdminUpdateToEntity(voluntario, voluntarioAdminDTOupdate, sede,
                                    TipoVoluntario.valueOf(voluntarioAdminDTOupdate.getTipo()))));
        } else {
            throw new ManagerAccessExcp("Tipo inexistente",
                    new Throwable(voluntarioAdminDTOupdate.getTipo() + " no existe"));
        }
    }

    @Override
    public VoluntarioDTO updateSanitario(VoluntarioDTOupdate voluntarioDTOupdate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSanitario'");
    }

}
