package com.ayudas.ong.controllers.get;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.repositories.models.dtos.IngresoDTO;
import com.ayudas.ong.services.socios.SocioServices;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/{rol}/visualizar")
public class GetControllerRestApi {

    private final SocioServices socioServices;

    // Listar socios por tipo de cuota

    @GetMapping("/socios/tipo-cuenta/{cuenta}")
    public ResponseEntity<Map<String, Object>> verSociosTipoCuenta(@PathVariable("cuenta") String cuenta) {

        Map<String, Object> response = new HashMap<>();
        List<IngresoDTO> socios = new ArrayList<>();

        try {
            socios = socioServices.buscarSocioByTipoCuenta(cuenta);

        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo obtener el listado");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", " Lista de socios");
        response.put("Tipo de cuenta", cuenta);
        response.put("Lista de socios", socios);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
}
