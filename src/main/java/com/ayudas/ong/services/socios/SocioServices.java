package com.ayudas.ong.services.socios;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.IngresoDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTOcrear;
import com.ayudas.ong.repositories.models.dtos.SocioDTOupdate;

public interface SocioServices {

    List<SocioDTO> findAll();

    SocioDTO crear(final SocioDTOcrear socioDTOcrear);

    SocioDTO save(final SocioDTO socioDTO);

    SocioDTO update(final Long cedula, final SocioDTOupdate socioDTO);

    void delete(final Long cedula);

    SocioDTO findByEmail(final String email);

    SocioDTO findByCedula(long cedula);

    List<IngresoDTO> buscarSocioByTipoCuenta(String tipo);
    
}
