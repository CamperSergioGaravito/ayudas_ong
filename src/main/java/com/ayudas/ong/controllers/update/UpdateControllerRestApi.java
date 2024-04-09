package com.ayudas.ong.controllers.update;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTOupdate;
import com.ayudas.ong.services.socios.SocioServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/{rol}/update")
public class UpdateControllerRestApi {

    private final SocioServices socioServices;

    @PutMapping("/socio/{cedula}")
    public ResponseEntity<Map<String, Object>> actualizarSocio(@Valid @PathVariable long cedula, @RequestBody SocioDTOupdate socio, BindingResult result) {
        
        SocioDTO socioDTO = null;
        Map<String,Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(
                    error -> error.getField() + " " + error.getDefaultMessage()
                )
                .collect(Collectors.toList());
            
            response.put("Errores", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            socioDTO = socioServices.update(cedula, socio);

        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo completar la actualización del socio");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", "El socio fue actualizado con éxito.");
        response.put("Socio", socioDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
}
