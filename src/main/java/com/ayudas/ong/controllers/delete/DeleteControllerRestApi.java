package com.ayudas.ong.controllers.delete;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.services.socios.SocioServices;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/{rol}/delete")
public class DeleteControllerRestApi {

    private final SocioServices socioServices;

    @DeleteMapping("/socio/{cedula}")
    public ResponseEntity<Map<String, Object>> actualizarSocio(@PathVariable long cedula) {
        
        Map<String,Object> response = new HashMap<>();

        try {
            socioServices.delete(cedula);

        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo completar la actualización del socio");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", "El socio fue eliminado con éxito.");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
}
